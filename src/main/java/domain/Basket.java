/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.HashMap;

/**
 *
 * @author mgresse
 */
public class Basket implements Cloneable{
    
    private HashMap<String,CommandLine> basket;
    private boolean state;
    private int amount;
    private int id;
    
    
    public Basket(int id){
        this.basket=new HashMap();
        this.state=false;
        this.id=id;
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
    
    public int getAmount(){
        return this.amount;
    }
    
    public int getId(){
        return this.id;
    }
    
    @Override
    public Basket clone(){
        //à implémenter
        return this;
    }
    
}
