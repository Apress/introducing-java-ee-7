
package org.javaee7.jpa.session;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Juneau
 */
@MessageDriven(mappedName = "jms/Queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class AcmeMessageDrivenBean implements MessageListener {
    
    public AcmeMessageDrivenBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("The following message has been received: " + message);
    }
}
