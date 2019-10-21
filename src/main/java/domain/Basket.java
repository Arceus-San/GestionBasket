/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mgresse
 */
public class Basket{
    
    private HashMap<String,CommandLine> basket;
    private boolean state;
    private int amount;
    private int id;
    
    
    public Basket(int id){
        this.basket=new HashMap<String,CommandLine>();
        this.state=false;
        this.id=id;
    }
    
    public Basket(DAOBasket daob){
        this.amount=daob.getAmount();
        this.id=daob.getId();
        this.state=daob.geState();
        this.basket=new HashMap<String,CommandLine>();
        
        for (Map.Entry<String, DAOCommandLine> pair: daob.getBasket().entrySet()) {
            CommandLine cl = new CommandLine(pair.getValue().getReference(),pair.getValue().getQuantity());
            this.basket.put(pair.getKey(), cl);
        }
    }
    
    public void addCommandLine(Reference ref, int quantity) throws BasketValidateException{
        if(this.state) throw new BasketValidateException();
        String name_new_ref=ref.getName();
        if(this.basket.containsKey(name_new_ref)){
            CommandLine actual = this.basket.get(name_new_ref);
            actual.addQuantity(quantity);
        }else{
            this.basket.put(name_new_ref, new CommandLine(ref,quantity));
        }
        this.amount+=ref.getPrice()*quantity;
    }
    
    public void removeCommandLine(Reference ref) throws BasketValidateException{
        if(this.state) throw new BasketValidateException();
        String name_ref=ref.getName();
        if(!this.basket.containsKey(name_ref)) throw new IllegalArgumentException("Cette référence n'est pas dans le panier");
        this.amount-=ref.getPrice()*this.basket.get(name_ref).getQuantity();
        this.basket.remove(name_ref);
    }
    
    public DAOBasket getDAO(){
        HashMap<String,DAOCommandLine> basketDAO = new HashMap<String,DAOCommandLine>();
        
        for (Map.Entry<String, CommandLine> pair: this.basket.entrySet()) {
            DAOCommandLine daocl = new DAOCommandLine(pair.getValue().getReference(),pair.getValue().getQuantity());
            basketDAO.put(pair.getKey(), daocl);
        }
        
        DAOBasket daob = new DAOBasket(this.state,this.amount,this.id, basketDAO);

        return daob;
    }
    
}
