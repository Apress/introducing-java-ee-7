
package org.javaee7.entity.listener;

import javax.annotation.Resource;
import javax.persistence.PrePersist;
import org.javaee7.entity.Employee;

/**
 * Entity Listener class for the Employee entity
 * @author Juneau
 */
public class EmployeeEntityListener {
    
    @Resource(name="jndi/AcmeMail") 
    javax.mail.Session mailSession;
    
    @PrePersist
    public void prePersist(Employee employee){
        System.out.println("The following Employee enity is about to be persisted: " + employee.getLast());
        // use the mail session
    }
    
}
