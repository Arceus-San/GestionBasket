/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import application.Command;
import application.HandlerInt;

/**
 *
 * @author mgresse
 */
public class Handler implements HandlerInt {

    public void handle(Command c) {
        c.execute();
    }

    

    
}
