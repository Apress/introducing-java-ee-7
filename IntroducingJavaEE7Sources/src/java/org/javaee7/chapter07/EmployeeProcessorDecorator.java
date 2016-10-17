
package org.javaee7.chapter07;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;

import javax.inject.Inject;

/**
 * This decorator class is applied to the employee hiring process to implement
 * additional functionality to any of the methods implemented within are called.
 * @author Juneau
 */
@Decorator
public class EmployeeProcessorDecorator implements Hire{
    
    @Inject
    @Delegate
    @Any
    Hire hire;

    @Override
    public String badgeEmployee() {
        String result = null;
        // Perform a test implementation for badging an employee
        hire.badgeEmployee();
        return result;
    }

    @Override
    public String trainEmployee() {
        String result = null;
        // Perform a test implementation for training an employee
        hire.trainEmployee();
        return result;
    }
}
