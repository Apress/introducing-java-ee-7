/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter02.jsf;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Juneau
 */
@ManagedBean(name = "ptBean")
@RequestScoped
public class PtBean implements java.io.Serializable {
    private String ptValue1;
   
    private int ptValue2;
    private Map ptValues = new HashMap();
    

    /**
     * Creates a new instance of PtBean
     */
    public PtBean() {
    }

    /**
     * @return the ptValue1
     */
    public String getPtValue1() {
        return ptValue1;
    }

    /**
     * @param ptValue1 the ptValue1 to set
     */
    public void setPtValue1(String ptValue1) {
        this.ptValue1 = ptValue1;
        if(!ptValues.isEmpty()){
            ptValues.put("attr" + ptValues.size(), ptValue1);
        }
    }

    /**
     * @return the ptValue2
     */
    public int getPtValue2() {
        return ptValue2;
    }

    /**
     * @param ptValue2 the ptValue2 to set
     */
    public void setPtValue2(int ptValue2) {
        this.ptValue2 = ptValue2;
        if(!ptValues.isEmpty()){
            ptValues.put("attr" + ptValues.size(), ptValue2);
        }
    }

    /**
     * @return the ptValues
     */
    public Map getPtValues() {
        return ptValues;
    }

    /**
     * @param ptValues the ptValues to set
     */
    public void setPtValues(Map ptValues) {
        this.ptValues = ptValues;
    }

    
}
