package org.javaee7.jpa.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import org.javaee7.entity.Employee;

/**
 *
 * @author Juneau
 */
@Stateless
public class EmployeeSession extends AbstractFacade<Employee> implements Serializable {

    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeSession() {
        super(Employee.class);
    }

    /**
     * Returns a list of employees that make greater than 50,000
     *
     * @return
     */
    public List obtainActiveEmployeeCount() {
       TypedQuery<Object[]> qry = em.createQuery("SELECT j.title, count(e) "
                + "FROM Jobs j LEFT JOIN j.employees e "
                + "ON e.status = 'ACTIVE' "
                + "WHERE j.salary >= 50000 "
                + "GROUP BY j.title", Object[].class);
        
       List data = new ArrayList();
        if (!qry.getResultList().isEmpty()) {
             List<Object[]> tdata = qry.getResultList();
            for (Object[] t : tdata) {
                HashMap resultMap = new HashMap();
                resultMap.put("title", t[0]);
                resultMap.put("count", t[1]);
                data.add(resultMap);
            }
        }
        return data;

    }
    
    public List obtainActiveEmployees(){
        return em.createQuery("select object(o) from Employee o").getResultList();
    }
    
    /**
     * 
     * @param firstName
     * @param lastName
     * @param status 
     */
    public boolean createEmp(String firstName, String lastName, String status){
        boolean result = false;
        System.out.println("executing the stored procedure");
        StoredProcedureQuery qry = em.createNamedStoredProcedureQuery("createEmp");
       // qry.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        qry.setParameter("firstname", firstName);
       // qry.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        qry.setParameter("lastname",lastName);
       // qry.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        qry.setParameter("status", status);
        
        try { 
            qry.execute();
            String response = qry.getOutputParameterValue(1).toString();
            System.out.println("stored procedure executed..." + response);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public void createEmpOld(String first,
                          String last,
                          String status) {
       
        Query qry = em.createNativeQuery("select CREATE_EMP(:first, :last, :status) from dual")
                .setParameter("first", first)
                .setParameter("last", last)
                .setParameter("status", status);
        qry.executeUpdate();
        
        
    }
    
    

}
