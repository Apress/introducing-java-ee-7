
package org.javaee7.chapter11;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.javaee7.entity.Employee;

/**
 * Chapter 11 - Scheduled Logger
 * @author Juneau
 */
public class ScheduledEmployeeAlert implements Runnable {

    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    @Override
    public void run() {
        emf = Persistence.createEntityManagerFactory("IntroToJavaEE7PU");
        em = emf.createEntityManager();
        queryEmployees();
    }
    
    public void queryEmployees(){
        EntityTransaction entr = em.getTransaction();
        entr.begin();
        String qry = "select object(o) from Employee o";
        Query query = em.createQuery(qry);
        List<Employee> emps = query.getResultList();
        for(Employee emp: emps){
            // if employee is new then alert
        } 
    }
}
