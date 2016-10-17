package org.javaee7.jpa.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.javaee7.entity.Product;

/**
 *
 * @author Juneau
 */
@Stateless
public class ProductSession extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductSession() {
        super(Product.class);
    }

    /**
     * Returns a list of employees that make greater than 50,000
     *
     * @return
     */
    public List obtainProduct() {
       TypedQuery<Object[]> qry = em.createQuery("select a.name, a.color " +
               "from Factory f JOIN TREAT(f.product as WidgetA) a", Object[].class);
        
       List data = new ArrayList();
        if (!qry.getResultList().isEmpty()) {
             List<Object[]> tdata = qry.getResultList();
            for (Object[] t : tdata) {
                HashMap resultMap = new HashMap();
                resultMap.put("name", t[0]);
                resultMap.put("color", t[1]);
                data.add(resultMap);
            }
        }
        return data;

    }
}
