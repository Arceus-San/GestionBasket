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
public interface BasketRepository {
    
    public void save(DAOBasket b);
    public DAOBasket getLastSaveOfBasket(int id);
    public HashMap<Integer,DAOBasket> getAllBaskets();
    
}
