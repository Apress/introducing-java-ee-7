package org.javaee7.chapter09;

import java.io.IOException;
import java.nio.ByteBuffer;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Juneau
 */
@ServerEndpoint(value="/acmechat")
public class AcmeChatEndpoint {

    /**
     * Message receiver method
     *
     * @param message
     * @return
     */
    @OnMessage
    public String messageReceiver(String message) {
        System.out.println("Received message:" + message);
        // Do something with message
        return message;
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen: " + session.getId());
        // Do something with session object
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println(session.getId());
        // Do something with session object
    }
}
