
package org.javaee7.chapter11;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Managed Bean for scheduling new employee alerts
 * @author Juneau
 */
@Named
public class ScheduledEmployeeAlerter {

    Future alertHandle = null;

    @Resource(name="concurrent/__defaultManagedScheduledExecutorService")
    ManagedScheduledExecutorService mes;
    

    public void alertScheduler() {

        ScheduledEmployeeAlert ae = new ScheduledEmployeeAlert();
        alertHandle = mes.scheduleAtFixedRate(
                ae, 5L, 5L, TimeUnit.MINUTES);
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Task Scheduled", "Task Scheduled");
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);

    }
    
}

