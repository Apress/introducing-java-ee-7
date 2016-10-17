package org.javaee7.chapter05;

import javax.jms.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * This is a JSF managed bean that contains a method for sending messages to the
 * queue.
 *
 * @author Juneau
 */
@Named(value = "messageDrivenBean")
@RequestScoped
public class MessageDrivenBeanController implements java.io.Serializable {

    @Resource(mappedName = "jms/QueueConnectionFactory")
    private static QueueConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Queue")
    private static Queue myQueue;
    
    QueueConnection connection = null;
  QueueSender sender = null;
  QueueSession session = null;

    public MessageDrivenBeanController() {
    }

    public void sendMessage() {
        try {
            connection = connectionFactory.createQueueConnection();
            connection.start();
            session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            sender = session.createSender(myQueue);
            
            TextMessage message = session.createTextMessage();
            message.setText("This is a message from the MDB client!");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Message Sent",
                "Message Sent"));
        } catch (JMSException ex) {
            Logger.getLogger(MessageDrivenBeanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
