
package org.javaee7.chapter07;

/**
 * This bean would be the default implementation for the employee hiring process.
 * @author Juneau
 */
public class EmployeeProcessor implements Hire {

    @Override
    public String badgeEmployee() {
        String result = null;
        // Perform tasks to badge an employee
        return result;
    }

    @Override
    public String trainEmployee() {
        String result = null;
        // Perform tasks to schedule up employee training
        // determineTraining();
        // scheduleTraining();
        return result;
        
    }
    
    
}
