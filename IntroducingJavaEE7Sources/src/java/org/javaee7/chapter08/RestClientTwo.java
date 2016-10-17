/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter08;

/**
 *
 * @author Juneau
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClientTwo {

    public static void main(String[] args){
        // Obtain an instance of the client
        Client client = ClientBuilder.newClient();
        client.register(MyProvider.class);
        WebTarget webTarget =  client.target("http://localhost:8080/IntroToJavaEE7/rest/simplerest");
        Response res = webTarget.request("text/plain").get();
        
            
        System.out.println(res.readEntity(String.class));
    }
}
