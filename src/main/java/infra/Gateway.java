/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import application.Command;
import application.GatewayInt;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mgresse
 */
public class Gateway implements GatewayInt{
    
    private ArrayList<Handler> handlerList;
    
    public Gateway(){
        this.handlerList=new ArrayList<Handler>();
    }

    public void pushCommand(Command c) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.handlerList.size());
        this.handlerList.get(randomIndex).handle(c);
    }

    public void addCommandHandler(Handler h) {
        this.handlerList.add(h);
    }
    
    
    
}
