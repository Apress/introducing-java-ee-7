package org.javaee7.chapter04.jsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juneau
 */
@ManagedBean
public class TreatExamples implements java.io.Serializable {

    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;

    public TreatExamples() {
    }
    
    public List<Map> factoryProductListing(){
        Query qry = em.createQuery("SELECT a.name, a.type, a.color " +
                    "FROM Factory b JOIN TREAT(b.product AS WidgetA) a");
        List<Object[]> results = qry.getResultList();
        List data = new ArrayList<>();
        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("name", result[0]);
                resultMap.put("type", result[1]);
                resultMap.put("color", result[2]);   

                data.add(resultMap);
            }
        
        }
        return data;
        
    }
}
