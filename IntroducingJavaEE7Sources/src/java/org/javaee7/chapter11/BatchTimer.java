/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter11;

import java.util.Properties;
import javax.annotation.Resource;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TimerService;

/**
 *
 * @author Juneau
 */
@Stateless
public class BatchTimer {

    @Resource
    TimerService timerService;
    
    
    @Schedule(minute="*", hour="*")
    public void scheduledTimerExample(){
        System.out.println("Initiating the batch job...");
        JobOperator job = BatchRuntime.getJobOperator();
        job.start("acmeFileProcessor", new Properties());
    }
}
