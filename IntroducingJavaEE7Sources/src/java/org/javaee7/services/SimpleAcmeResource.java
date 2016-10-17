
package org.javaee7.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.javaee7.entity.Jobs;
import org.javaee7.interfaces.Alerter;

/**
 * Demonstrates a simple producer web service
 * @author Juneau
 */
@Path("/acmeSimple")
public class SimpleAcmeResource {
    
    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;
    
    @GET
    @Produces("text/html")
    @Alerter
    public String  getJobs(){
        Query qry = em.createQuery("select object(o) from Jobs o");
        List<Jobs> jobList = qry.getResultList();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<p>");
        for(Jobs job:jobList){
            htmlBuilder.append(job.getTitle());
            htmlBuilder.append("<br/>");
        }
        htmlBuilder.append("</p>");
        return htmlBuilder.toString();
    }
}
