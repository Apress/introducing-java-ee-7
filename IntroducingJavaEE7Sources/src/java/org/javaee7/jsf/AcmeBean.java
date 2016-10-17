
package org.javaee7.jsf;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.javaee7.jpa.session.AcmeFacade;
import org.javaee7.jpa.session.AcmeTimerFacade;

/**
 *
 * @author Juneau
 */
@ManagedBean(name = "acmeBean")
@SessionScoped
public class AcmeBean implements Serializable {
    
    @EJB
    private AcmeFacade facade;
    
    @EJB
    private AcmeTimerFacade timerFacade;
    
    @Inject
    ServletContext context;

    
    private String msg = "Look at the server log...the transaction has begun";

    /**
     * Creates a new instance of AcmeBean
     */
    public AcmeBean() {
        
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    /**
     * Creates a scheduled timer
     */
    public String createProgrammaticTimer(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Creating Programmatic Timer",
                "Creating Programmatic Timer"));
        return timerFacade.createProgrammaticTimer();
    }
    
    public String obtainTimerInfo(){
        String timerInfo = timerFacade.getTimerInfo();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, timerInfo,
                timerInfo));
        return "TimerExamples";
    }
    
    /**
     * 
     * @return 
     */
    public String getContextInfo(){
        return context.getServerInfo();
    }
    

}
