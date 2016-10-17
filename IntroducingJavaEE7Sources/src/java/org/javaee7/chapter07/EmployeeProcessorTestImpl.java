
package org.javaee7.chapter07;

import javax.enterprise.inject.Alternative;

/**
 * This bean would be a test implementation for the employee hiring process. 
 * To make this bean active, it must be specified within the beans.xml as an 
 * alternative implementation for EmployeeProcessor.
 * @author Juneau
 */
@Alternative
public class EmployeeProcessorTestImpl implements Hire {

    @Override
    public String badgeEmployee() {
        String result = null;
        // Perform a test implementation for badging an employee
        return result;
    }

    @Override
    public String trainEmployee() {
        String result = null;
        // Perform a test implementation for training an employee
        return result;
    }
    
}
