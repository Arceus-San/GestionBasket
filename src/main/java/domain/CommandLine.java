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
public class CommandLine {
    
    private Reference ref;
    private int quantity;
    
    public CommandLine(Reference r, int q){
        if(q<=0) throw new IllegalArgumentException("Quantité négative");
        else{
            this.quantity=q;
        }
        this.ref=r;
    }
    
    public void addQuantity(int q){
        this.quantity+=q;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
}
