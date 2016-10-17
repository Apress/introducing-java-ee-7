/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.jpa.session;

import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import org.javaee7.entity.Jobs;

/**
 *
 * @author Juneau
 */
@Stateless
public class JobsSession extends AbstractFacade<Jobs> {

    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;
    
    private List<Jobs> jobList;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobsSession() {
        super(Jobs.class);
    }
    
    /**
     * Asynchronous session bean method for retrieving job database records
     */
    @Asynchronous
    public void retrieveJobs(){
        Query qry = em.createQuery("select j from Jobs j");
        List<Jobs> jobs = qry.getResultList();
        
        for (Jobs job:jobs){
            System.out.println(job.getTitle());
        }
    }
    
    @Asynchronous
    public Future<Boolean> obtainJobListing(){
        Query qry = em.createQuery("select j from Jobs j");
        List<Jobs> jobs = qry.getResultList();
        if(jobs.size() > 0){
            this.jobList = jobs;
            return new AsyncResult<Boolean>(true);
        } else {
            return new AsyncResult<Boolean>(false);
        }
    }

    /**
     * @return the jobList
     */
    public List<Jobs> getJobList() {
        if(jobList == null || jobList.isEmpty()){
            System.out.println("obtaining job listing");
            obtainJobListing();
        }
        return jobList;
    }
    
    /**
     * @return the jobList
     */
    public List<Jobs> retrieveJobsSynchronously() {
        Query qry = em.createQuery("select j from Jobs j");
        List<Jobs> jobList = qry.getResultList();
        return jobList;
    }

    /**
     * @param jobList the jobList to set
     */
    public void setJobList(List<Jobs> jobList) {
        this.jobList = jobList;
    }

    
}