/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.jsf;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.javaee7.entity.Employee;
import org.javaee7.jpa.session.EmployeeSession;

/**
 *
 * @author Juneau
 */
@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {
    
    @EJB
    EmployeeSession employeeSession;

    private Employee employee;
    private String firstName;
    private String lastName;
    private String status;
    
    /**
     * Creates a new instance of EmployeeBean
     */
    public EmployeeBean() {
    }
    
    public List activeEmployeeCount(){
        return employeeSession.obtainActiveEmployeeCount();
    }
    
    /**
     * Calls stored procedure to insert record into EMPLOYEE table
     */
    public String createEmployee(){
        boolean result = false;
        result = employeeSession.createEmp(employee.getFirst(), employee.getLast(), employee.getStatus());
        if (result){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Employee Successfully Created",
                "Employee Successfully Created"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR, "Employee Not created, see server log for details.",
                "Employee not created, see server log for details."));
        }
        return null;
    }



    /**
     * @return the employee
     */
    public Employee getEmployee() {
        if (employee == null){
            employee = new Employee();
        }
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
