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
public class DAOBasket {
    
    private HashMap<String,DAOCommandLine> basket;
    private boolean state;
    private int amount;
    private int id;
    
    public DAOBasket(boolean state, int amount, int id, HashMap<String,DAOCommandLine> basket){
        this.basket=basket;
        this.state=state;
        this.amount=amount;
        this.id=id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public boolean geState(){
        return this.state;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public HashMap<String,DAOCommandLine> getBasket(){
        return this.basket;
    }
    
}
