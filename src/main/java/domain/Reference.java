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
public class Reference {
    
    private String number;
    private String name;
    private String description;
    private int price;
    
    public Reference(String number, String name, String desc, int prix){
        String pattern= "^[a-zA-Z0-9]*$";
        if(!number.matches(pattern)) throw new IllegalArgumentException("Le numéro n'est pas alphanumérique");
        else{
            this.number=number;
        }
        if(name.length()>20) throw new IllegalArgumentException("Nom trop long");
        else{
            this.name=name;
        }
        if(desc.length()>200) throw new IllegalArgumentException("Description trop longue");
        else{
            this.description=desc;
        }
        if(prix<=0) throw new IllegalArgumentException("Prix négatif");
        else{
            this.price=prix;
        }
    }
    
    public String getNumber(){
        return this.number;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDesc(){
        return this.description;
    }
    
    public int getPrice(){
        return this.price;
    }
    
}
