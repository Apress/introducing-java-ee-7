/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter03;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Juneau
 */
@ManagedBean(name = "elExampleManagedBean")
@SessionScoped
public class ElExampleManagedBean implements java.io.Serializable {

    /**
     * Creates a new instance of ElExampleManagedBean
     */
    public ElExampleManagedBean() {
    }
    
    public boolean determineWage(javax.el.LambdaExpression le){
        Employee e = new Employee();  // Grab an employee instance
      //  if (le.invoke(e)){
      //      return true;
      //  } else {
            return false;
      //  }
    }
    
    public boolean displayResult(javax.el.LambdaExpression le){
        Employee e = new Employee();  // Grab an employee instance
        if ((Boolean)le.invoke(e)){
            return true;
        } else {
            return false;
        }
    }
}
