/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author mgresse
 */
public class DAOCommandLine {
    
    private Reference ref;
    private int quantity;
    
    public DAOCommandLine(Reference r, int quantity){
        this.ref=r;
        this.quantity=quantity;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public Reference getReference(){
        return this.ref;
    }
}
