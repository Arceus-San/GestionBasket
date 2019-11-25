/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application;

import domain.*;
import infra.BasketJSONRepository;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgresse
 */
public class AddAndSaveCommand extends Command {
    
    private Basket basket;
    private Reference ref;
    private int quantity;
    private BasketJSONRepository basketr;
    
    public AddAndSaveCommand(Basket b, Reference r, int q, BasketJSONRepository br){
        this.basket=b;
        this.ref=r;
        this.quantity=q;
        this.basketr=br;
    }

    @Override
    public void execute() {
        try {
            this.basket.addCommandLine(this.ref,this.quantity);
        } catch (BasketValidateException ex) {
            Logger.getLogger(AddAndSaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.basketr.save(this.basket.getDAO());
    }
    
    
    
    
}
