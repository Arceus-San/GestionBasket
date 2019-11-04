/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.BasketRepository;
import domain.DAOBasket;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgresse
 */
public class BasketJSONRepository implements BasketRepository{

    @Override
    public void save(DAOBasket b) {
        
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String res = gson.toJson(b);
            BufferedWriter writer;
            
            writer = new BufferedWriter(new FileWriter("json/Basket"+b.getId()+".json"));
            writer.write(res);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(BasketJSONRepository.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    @Override
    public DAOBasket getLastSaveOfBasket(int id) {
        try {
            Path path = Files.createTempFile("json/Basket"+id, ".json");
            if(Files.exists(path)){
                
                Gson gson = new Gson();
                Reader reader = new FileReader("json/Basket"+id+".json");
                DAOBasket basket = gson.fromJson(reader, DAOBasket.class);
                return basket;
            }
        } catch (IOException ex) {
            Logger.getLogger(BasketJSONRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public HashMap<Integer, DAOBasket> getAllBaskets() {
        HashMap<Integer, DAOBasket> res = new HashMap<Integer, DAOBasket>();
        File dir = new File("json/");
        File[] directoryListing = dir.listFiles();
        Gson gson = new Gson();
        if (directoryListing != null) {
          for (File child : directoryListing) {
              try {
                  Reader reader = new FileReader(child);
                  DAOBasket basket = gson.fromJson(reader, DAOBasket.class);
                  res.put(basket.getId(), basket);
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(BasketJSONRepository.class.getName()).log(Level.SEVERE, null, ex);
              }
            
          }
        }
        return res;
    }
    
}
