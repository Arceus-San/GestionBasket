/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application;

import domain.*;
import infra.BasketJSONRepository;
import infra.Gateway;


/**
 *
 * @author mgresse
 */
public class BasketService {
    
    BasketJSONRepository br;
    Gateway gateway;
    
    public BasketService(Gateway g, BasketRepository br){
        this.br=new BasketJSONRepository();
        this.gateway=g;
    }
    
    public void addCommandAndSave(Reference ref, int quantity, int id) throws BasketValidateException{
        Basket b = br.getLastSaveOfBasket(id);
        
        //Command
        this.gateway.pushCommand(new AddAndSaveCommand(b,ref,quantity,br));
        
    }
    
}
