package org.javaee7.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

// Set the PATH to http://host:port/application/rest/simplerest/
@Path("/simplerest")
public class SimpleRest {

    private String message = "Hello from a simple REST Service";
    private String htmlMessage = "<p><b>" + message + "</b></p>";

    @GET
    // Produces plain text message
    @Produces("text/plain")
    public String getPlainMessage() {
        return message;
    }

    @GET
    // Produces plain text message
    @Produces("text/html")
    public String getHTMLMessage() {
        return htmlMessage;
    }

    @PUT
    @Path("add")
    @Consumes("text/plain")
    public String add(@QueryParam("text") String text) {
        this.message = text;
        return message;
    }

    @Path("{user}")
    @GET
    @Produces("text/html")
    public String getUserMessage(@PathParam("user") String user) {
        return "Greetings " + "<b>" + user + "</b>";
    }
}