
package org.javaee7.chapter08;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.javaee7.entity.Jobs;
import org.javaee7.jpa.session.JobsSession;

/**
 *
 * @author Juneau
 */
@Path("/jobsService")
public class JobsService {
    

    
    @EJB
    JobsSession jobsSession;
    
    public JobsService(){
        
    }
    
    @GET
    @Produces("text/html")
    public String getAsHtml() {
        List<Jobs> jobList = jobsSession.retrieveJobsSynchronously();
        StringBuilder sb = new StringBuilder();
        sb.append("<p>");
        for (Jobs job:jobList){
            sb.append(job.getJobId() + " = " + job.getTitle());
        }
        sb.append("<p>");
        return sb.toString();
    }
    
    @GET
    @Produces("application/xml")
    public Jobs getAsJobs(){
        List<Jobs> jobList = jobsSession.retrieveJobsSynchronously();
        return jobList.get(1);
    }
}
