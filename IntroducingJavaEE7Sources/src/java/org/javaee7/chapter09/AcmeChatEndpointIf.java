/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter09;

import javax.websocket.EndpointConfig;
import javax.websocket.Session;

/**
 * Interface implementation of a WebSocket Endpoint
 * @author Juneau
 */
public class AcmeChatEndpointIf extends javax.websocket.Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        // Implementation here
    }
    
    public void onClose(Session session){
        // Implementation here
    }
    
    public void onError(Session session){
        // Implementation here
    }
    
}
