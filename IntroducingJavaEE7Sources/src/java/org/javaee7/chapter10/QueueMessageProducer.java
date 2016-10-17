package org.javaee7.chapter10;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author Juneau
 */
@Named("queueMessageProducer")
public class QueueMessageProducer {

    // Inject JMSContext if working within application server
    //  - Injection without any parameters utlizes the default application server
    //    connection factory
    // @Inject
    // JMSContext context myContext;
    
    @Resource(name = "jms/acmeConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/Queue")
    Queue inboundQueue;

    public void sendMessage() {
        JMSContext context = connectionFactory.createContext();
        StringBuilder message = new StringBuilder();
        message.append("Java EE 7 Is the Best!");
        context.createProducer().send(inboundQueue, message.toString());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Message sent",
                "Message sent"));

    }
}
