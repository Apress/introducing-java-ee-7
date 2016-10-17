
package org.javaee7.chapter08;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
//import javax.ws.rs.client.ClientFactory;

/**
 *
 * @author Juneau
 */
@ManagedBean(name="restClientOne")
public class RestClientOne {
   
    private String clientOutput;
    
    // May be able to do @Inject before final release
    public void testServiceOne(){
        // Obtain an instance of the client
        Client client = javax.ws.rs.client.ClientBuilder.newClient();
        
        WebTarget webTarget =  client.target("http://localhost:8080/IntroToJavaEE7/rest/simplerest");
        Response res = webTarget.request("text/plain").get();
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Invoked test client",
                "Invoked test client"));
        setClientOutput(res.toString());
      
    }

    /**
     * @return the clientOutput
     */
    public String getClientOutput() {
        return clientOutput;
    }

    /**
     * @param clientOutput the clientOutput to set
     */
    public void setClientOutput(String clientOutput) {
        this.clientOutput = clientOutput;
    }
    
}
