/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import com.google.gson.Gson;
import java.util.HashMap;
import domain.BasketRepository;
import domain.DAOBasket;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgresse
 */
public class BasketJSONRepository implements BasketRepository{

    @Override
    public void save(DAOBasket b) {
        Gson gson = new Gson();
        try {
            gson.toJson("oui", new FileWriter("json/Basket"+b.getId()+".json"));
        } catch (IOException ex) {
            Logger.getLogger(BasketJSONRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DAOBasket getLastSaveOfBasket(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, DAOBasket> getAllBaskets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
