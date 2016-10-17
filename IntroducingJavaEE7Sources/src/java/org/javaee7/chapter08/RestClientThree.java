/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter08;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.javaee7.entity.Jobs;

/**
 *
 * @author Juneau
 */
public class RestClientThree {
    public static void main(String[] args){
        // Obtain an instance of the client
        Client client = ClientBuilder.newClient();
        
        Jobs jobs =  client.target("http://localhost:8080/IntroToJavaEE7/rest/jobsService")
                .request("application/xml").get(Jobs.class);
        
            
        System.out.println(jobs.getJobId() + " - " + jobs.getTitle());
        
        
    }
}
