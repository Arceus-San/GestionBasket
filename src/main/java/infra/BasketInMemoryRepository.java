/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import java.util.HashMap;
import domain.BasketRepository;
import domain.DAOBasket;

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
    public DAOBasket getLastSaveOfBasket(int id){
        if(!this.memory.containsKey(id)) throw new IllegalArgumentException("Le Basket correspondant n'existe pas");
        return this.memory.get(id);
    }

    @Override
    public HashMap<Integer, DAOBasket> getAllBaskets() {
        return this.memory;
    }
    
}
