package org.javaee7.jpa.session;

import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Bean that is used to demonstrate timer-based examples
 *
 * @author Juneau
 *
 */
@Stateless
public class AcmeTimerFacade {
    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;
    
    @Resource
    TimerService timerService;
    
    private String timerInfo;

    /**
     * Navigational Method
     *
     * @return
     */
    public String acmeReturnToIndex() {
        return "index";
    }
    

    public String createProgrammaticTimer() {
        long duration = 6000;
        Timer timer = timerService.createTimer(duration, "Created new programmatic timer");
        return "TimerExamples";
    }
    
    public String getTimerInfo(){
        Collection<Timer> timers = timerService.getAllTimers();
        StringBuffer sb = new StringBuffer();
        int x = 0;
        for (Timer timer:timers){
            sb.append("Time Remaining on timer #" + x );
            sb.append(" " + timer.getTimeRemaining());
            sb.append("    ");
            x++;
        }
        timerInfo = sb.toString();
        return timerInfo;
    }
    
    @Timeout
    public void timeout(Timer timer){
        System.out.println("The timer was just invoked...");
    }

    /**
     * @param timerInfo the timerInfo to set
     */
    public void setTimerInfo(String timerInfo) {
        this.timerInfo = timerInfo;
    }
    
    @Schedule(minute="*", hour="*")
    public void scheduledTimerExample(){
            System.out.println("This timer will go off every minute");
    }
}
