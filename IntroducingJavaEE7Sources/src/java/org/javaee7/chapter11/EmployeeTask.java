
package org.javaee7.chapter11;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;

/**
 *
 * @author Juneau
 */

public class EmployeeTask implements Callable<EmployeeInfo>, ManagedTask {
    // The ID of the request to report on demand.
    BigDecimal employeeId;
    EmployeeInfo employeeInfo;
    Map<String, String> execProps;

    public EmployeeTask(BigDecimal id) {
        this.employeeId = id;
        execProps = new HashMap<>();
       
        execProps.put(ManagedTask.IDENTITY_NAME, getIdentityName());
    }

    public EmployeeInfo call() {
// Find the entity bean and return it to the client. 
        return employeeInfo;
    }

    public String getIdentityName() {
        return "EmployeeTask: AuthorID=" + employeeId;
    }

    public Map<String, String> getExecutionProperties() {
        return execProps;
    }

    public String getIdentityDescription(Locale locale) { 
        // Use a resource bundle...
        return "EmployeeTask asynchronous EJB invoker";
    }

    @Override
    public ManagedTaskListener getManagedTaskListener() {
        return new CustomManagedTaskListener();
    }
}
