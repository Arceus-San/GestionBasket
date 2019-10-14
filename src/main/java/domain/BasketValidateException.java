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
public class BasketValidateException extends Exception{
    
    public BasketValidateException(){
        super("Le panier est déjà validé");
    }
    
}
