
package org.javaee7.chapter09;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

/**
 *
 * @author Juneau
 */
@ClientEndpoint
public class AcmeChatClient {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to endpoint: " + session.getAsyncRemote());

        String name = "Message from the Acme Chat Client";

        session.getAsyncRemote().sendText(name);

    }

    @OnMessage
    public void processMessage(String message) {
        System.out.println("Received message in client: " + message);
    }
}
