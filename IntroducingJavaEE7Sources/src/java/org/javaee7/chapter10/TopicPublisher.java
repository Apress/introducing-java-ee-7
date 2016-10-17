/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter10;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.jms.JMSException;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.NamingException;

/**
 *
 * @author Juneau
 */
@Named("topicPublisher")
public class TopicPublisher implements java.io.Serializable {

    @Resource(name = "jms/TopicConnFactory")
    private TopicConnectionFactory topicConnFactory;
    @Resource(lookup = "jms/Topic")
    Topic topic;

    public void publishMessage() throws NamingException, JMSException {

        try (TopicConnection topicConnection = topicConnFactory.createTopicConnection();
                TopicSession topicSession =
                topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);) {
            topicConnection.start();
            Topic createdtopic = topicSession.createTopic("JavaEE");

            // create the message to send
            TextMessage textMessage = topicSession.createTextMessage("This is a test message");

            javax.jms.TopicPublisher topicPublisher = topicSession.createPublisher(createdtopic);
            topicPublisher.setDeliveryDelay(1000);
            topicPublisher.publish(textMessage);

        }
    }
}
