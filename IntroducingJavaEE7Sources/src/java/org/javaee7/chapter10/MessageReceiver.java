
package org.javaee7.chapter10;

import java.util.Enumeration;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;

/**
 *
 * @author Juneau
 */
@Named("messageReceiver")
public class MessageReceiver {
    
    // Inject JMSContext if working within application server
    //  - Injection without any parameters utlizes the default application server
    //    connection factory
    // @Inject
    // JMSContext context myContext;
    
    @Resource(name = "jms/acmeConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/Queue")
    Queue inboundQueue;
    
    private String messageReceived = null;
    
    public String receiveMessage() {
        JMSContext context = connectionFactory.createContext();
        JMSConsumer consumer = context.createConsumer(inboundQueue);
        return consumer.receiveBody(String.class);      
    }
    
    public void receiveAsync(){
        JMSContext context = connectionFactory.createContext();
        JMSConsumer consumer = context.createConsumer(inboundQueue);
        javax.jms.MessageListener acmeMessageListener = new AcmeMessageListener();
        consumer.setMessageListener(acmeMessageListener);

        messageReceived = consumer.receiveBody(String.class);    
    }

    /**
     * @return the messageReceived
     */
    public String getMessageReceived() {
        return messageReceived;
    }

    /**
     * @param messageReceived the messageReceived to set
     */
    public void setMessageReceived(String messageReceived) {
        this.messageReceived = messageReceived;
    }
    
    
    public void browseMessages() {

        try(Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueBrowser browser = session.createBrowser(inboundQueue);) {

            Enumeration msgs = browser.getEnumeration();
            
            if(!msgs.hasMoreElements()){
                System.out.println("No more messages within the queue...");
            } else {
                while(msgs.hasMoreElements()){
                    Message currMsg = (Message)msgs.nextElement();
                    System.out.println("Message ID: " + currMsg.getJMSMessageID());       
                }
            }

        } catch (JMSException ex) {
            System.out.println(ex);
        } 
    }


    
}
