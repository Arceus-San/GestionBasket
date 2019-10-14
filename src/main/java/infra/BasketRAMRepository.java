/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import java.util.HashMap;
import domain.Basket;
import domain.BasketRepository;

/**
 *
 * @author mgresse
 */
public class BasketRAMRepository implements BasketRepository{
    
    private HashMap<Integer,Basket> memory;
    
    public BasketRAMRepository(){
        this.memory=new HashMap<Integer,Basket>();
    }

    @Override
    public void save(Basket b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.memory.put(b.getId(), b);
    }
    
    @Override
    public Basket getLastSaveOfBasket(int id){
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(!this.memory.containsKey(id)) throw new IllegalArgumentException("Le Basket correspondant n'existe pas");
        return this.memory.get(id);
    }

    @Override
    public HashMap<Integer, Basket> getAllBaskets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.memory;
    }
    
}
