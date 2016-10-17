package org.javaee7.chapter09;

import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Juneau
 */
public class AcmeChatTextDecoder implements javax.websocket.Decoder.Text<AcmeChatObj> {

    @Override
    public AcmeChatObj decode(String s) throws DecodeException {
        AcmeChatObj obj = new AcmeChatObj();
        obj.setMessage(s);
        return obj;
    }

    @Override
    public boolean willDecode(String s) {
        if (s != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void init(EndpointConfig config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
