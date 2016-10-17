
package org.javaee7.chapter08;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.javaee7.entity.Product;
import org.javaee7.jpa.session.ProductSession;

/**
 *
 * @author Juneau
 */
@Path("/productService")
@Stateless
public class ProductService {
    
    @EJB
    ProductSession productSession;
    
    @GET
    @Path("/get")
    // Produces an XML message
    @Produces(MediaType.APPLICATION_XML)
    public String getProducts() {
        List<Product> productList = productSession.findAll();
        StringBuilder xmlstring= new StringBuilder();
        for(Product product:productList){
            xmlstring.append("<product>");
            xmlstring.append("<id>" + product.getId() + "</id>");
            xmlstring.append("<name>" + product.getName() + "</name>");
            xmlstring.append("<description>" + product.getDescription() + "</description>");
            xmlstring.append("</product>");

        }
        return xmlstring.toString();
    }

}
