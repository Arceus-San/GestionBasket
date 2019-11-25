/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import domain.Basket;
import domain.BasketRepository;
import domain.DAOBasket;
import java.util.HashMap;

/**
 *
 * @author mgresse
 */
public class BasketInMemoryRepository implements BasketRepository{
    
    private HashMap<Integer,DAOBasket> memory;
    
    public BasketInMemoryRepository(){
        this.memory=new HashMap<Integer,DAOBasket>();
    }

    @Override
    public void save(DAOBasket b) {
        this.memory.put(b.getId(), b);
    }
    
    @Override
    public Basket getLastSaveOfBasket(int id){
        if(!this.memory.containsKey(id)) throw new IllegalArgumentException("Le Basket correspondant n'existe pas");
        return new Basket(this.memory.get(id));
    }

    @Override
    public HashMap<Integer, DAOBasket> getAllBaskets() {
        return this.memory;
    }
    
}
