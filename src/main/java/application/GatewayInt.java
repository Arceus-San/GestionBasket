/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application;

import infra.Handler;

/**
 *
 * @author mgresse
 */
public interface GatewayInt {
    
    public void pushCommand(Command c);
    public void addCommandHandler(Handler h);
    
}
