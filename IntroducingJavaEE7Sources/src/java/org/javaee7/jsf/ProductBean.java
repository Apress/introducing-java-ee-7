
package org.javaee7.jsf;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.javaee7.jpa.session.ProductSession;

/**
 *
 * @author Juneau
 */
@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean implements Serializable {
    
    @EJB
    ProductSession productSession;

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
    
    public List productType(){
        return productSession.obtainProduct();
    }
}
