
package org.javaee7.jsf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.javaee7.entity.Jobs;
import org.javaee7.jpa.session.JobsSession;

/**
 *
 * @author Juneau
 */
@ManagedBean(name = "jobsBean")
@RequestScoped
public class JobsBean {
    
    @EJB
    JobsSession jobsSession;

    private List<Jobs> currJobs;
    
    /**
     * Creates a new instance of JobsBean
     */
    public JobsBean() {
    }
    
    public void printJobListing(){
        jobsSession.retrieveJobs();
    }
    
    public List<Jobs> obtainJobListing(){
        if(currJobs == null){
            jobsSession.getJobList();
        }
        if(jobsSession.obtainJobListing().isDone()){
            setCurrJobs(jobsSession.getJobList());
            System.out.println("Task Is Complete");
        } else {
            setCurrJobs((List<Jobs>) new ArrayList());
            Jobs inProgress = new Jobs();
            inProgress.setTitle("In Progress");
            getCurrJobs().add(inProgress);
            System.out.println("Not yet complete...");
        }
        
        return getCurrJobs();
    }

    /**
     * @return the currJobs
     */
    public List<Jobs> getCurrJobs() {
        
        return currJobs;
    }

    /**
     * @param currJobs the currJobs to set
     */
    public void setCurrJobs(List<Jobs> currJobs) {
        this.currJobs = currJobs;
    }
    
    /**
     * Create a jobs record
     * @param jobId
     * @param jobTitle
     * @param salary
     * @param division 
     */
    public void createJob(
            @NotNull @Size(min = 3, max = 20) Integer jobId,
            @NotNull String jobTitle,
            @DecimalMin("35000") BigDecimal salary,
            @NotNull String division) {
         Jobs newJob = new Jobs();
         newJob.setDivision(division);
         newJob.setJobId(jobId);
         newJob.setTitle(jobTitle);
         newJob.setSalary(salary);
         jobsSession.create(newJob);
    }

}
