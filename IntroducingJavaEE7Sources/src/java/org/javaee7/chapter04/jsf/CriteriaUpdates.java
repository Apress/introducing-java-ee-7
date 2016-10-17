package org.javaee7.chapter04.jsf;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.javaee7.entity.Employee;

/**
 * Examples of utilizing the bulk update feature
 *
 * @author Juneau
 */
@ManagedBean
public class CriteriaUpdates implements java.io.Serializable {

    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;
    @Resource
    private UserTransaction ut;
    private List employeeList;

    public String updateEmployeeStatusInactive() {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Employee> q = builder.createCriteriaUpdate(Employee.class);
            Root<Employee> e = q.from(Employee.class);
            q.set(e.get("status"), "INACTIVE")
                    .where(builder.equal(e.get("status"), "ACTIVE"));
            ut.begin();
            Query criteriaUpd = em.createQuery(q);
            criteriaUpd.executeUpdate();
            ut.commit();
        } catch (NotSupportedException | RollbackException | SystemException | HeuristicMixedException | HeuristicRollbackException ex) {
            Logger.getLogger(CriteriaUpdates.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String updateEmployeeStatusActive() {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Employee> q = builder.createCriteriaUpdate(Employee.class);
            Root<Employee> e = q.from(Employee.class);
            q.set(e.get("status"), "ACTIVE")
                    .where(builder.equal(e.get("status"), "INACTIVE"));
            ut.begin();
            Query criteriaUpd = em.createQuery(q);
            criteriaUpd.executeUpdate();
            ut.commit();
        } catch (NotSupportedException | RollbackException | SystemException | HeuristicMixedException | HeuristicRollbackException ex) {
            Logger.getLogger(CriteriaUpdates.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String obtainEmployees() {
        Query qry = em.createQuery("select e from Employee e");
        employeeList = qry.getResultList();
        return null;
    }

    public String deleteEmployeeOnStatus(String condition) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaDelete<Employee> q = builder.createCriteriaDelete(Employee.class);
            Root<Employee> e = q.from(Employee.class);
            q.where(builder.equal(e.get("status"), condition));
            ut.begin();
            Query criteriaDel = em.createQuery(q);
            criteriaDel.executeUpdate();
            ut.commit();
        } catch (NotSupportedException | RollbackException | SystemException | HeuristicMixedException | HeuristicRollbackException ex) {
            Logger.getLogger(CriteriaUpdates.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @return the employeeList
     */
    public List getEmployeeList() {
        if (employeeList == null) {
            obtainEmployees();
        }
        return employeeList;
    }

    /**
     * @param employeeList the employeeList to set
     */
    public void setEmployeeList(List employeeList) {
        this.employeeList = employeeList;
    }
}
