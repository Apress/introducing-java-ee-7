/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter10;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.NamingException;

/**
 *
 * @author Juneau
 */
@Named("queueSenderModule")
public class QueueSenderModule {
    
    @Resource(name = "jms/QueueConnFactory")
    private QueueConnectionFactory queueConnFactory;
    @Resource(lookup = "jms/Queue")
    Queue queue;

    /**
     * Create and send a message using QueueSession
     * @throws NamingException
     * @throws JMSException 
     */
    public void sendMessage() throws NamingException, JMSException {

        try (QueueConnection queueConnection = queueConnFactory.createQueueConnection();
                ) {
            queueConnection.start();
            QueueSession queueSession =
                queueConnection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            queue = queueSession.createQueue("JavaEEQueue");

            // create the message to send
            TextMessage textMessage = queueSession.createTextMessage("This is a test message");

            QueueSender sender = queueSession.createSender(queue);
            sender.send(textMessage);
            queueSession.close();

        }
    }
}
