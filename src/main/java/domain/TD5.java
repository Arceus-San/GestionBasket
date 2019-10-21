/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import infra.BasketInMemoryRepository;
import infra.BasketJSONRepository;

/**
 *
 * @author mgresse
 */
public class TD5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BasketValidateException {
        // TODO code application logic here
        
        Reference ref1 = new Reference("64684613","Couteau","Couteau de qualité",2);
        Reference ref2 = new Reference("98746564","Fourchette","Fourchette de qualité",2);
        Reference ref3 = new Reference("25479854","Cuillière","Cuillière de qualité",1);
        
        Basket basket = new Basket(1);
        Basket basket2 = new Basket(2);
        
        basket.addCommandLine(ref1, 4);
        basket.addCommandLine(ref2, 4);
        
        basket2.addCommandLine(ref3, 4);
        
        DAOBasket daobasket = basket.getDAO();
        
        BasketJSONRepository repo = new BasketJSONRepository();
        repo.save(daobasket);
        
        BasketInMemoryRepository repoIM = new BasketInMemoryRepository();
        repoIM.save(daobasket);
        
        DAOBasket backup = repoIM.getLastSaveOfBasket(1);
        System.out.println(backup.getAmount());
                
              
                
        
            
        
    }
    
}
