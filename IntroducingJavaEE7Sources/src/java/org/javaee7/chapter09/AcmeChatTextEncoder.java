/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter09;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Juneau
 */
public class AcmeChatTextEncoder implements javax.websocket.Encoder.Text<AcmeChatObj> {

    @Override
    public String encode(AcmeChatObj object) throws EncodeException {
        return object.getMessage();
    }

    @Override
    public void init(EndpointConfig config) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
