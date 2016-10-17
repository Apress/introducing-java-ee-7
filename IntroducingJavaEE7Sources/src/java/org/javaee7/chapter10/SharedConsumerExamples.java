
package org.javaee7.chapter10;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author Juneau
 */
public class SharedConsumerExamples {
    
    // Inject JMSContext if working within application server
    //  - Injection without any parameters utlizes the default application server
    //    connection factory
    // @Inject
    // JMSContext context myContext;
    
    @Resource(name = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/Topic")
    Topic topic;
    
    public void createSharedDurable(){
        String topicName = "JavaEE";
        JMSContext context = connectionFactory.createContext();
        JMSConsumer consumer = context.createSharedConsumer(topic, topicName);
        consumer.receive();
        
    }
    
    public void createSharedNonDurable(){
        String topicName = "JavaEE";
        JMSContext context = connectionFactory.createContext();
        JMSConsumer consumer = context.createSharedConsumer(topic, topicName);
        consumer.receive();
        
    }
    
}
