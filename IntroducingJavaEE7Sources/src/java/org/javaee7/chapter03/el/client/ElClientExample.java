/*
 * EL 3.0 Stand Alone API Examples
 */
package org.javaee7.chapter03.el.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELManager;
import javax.el.ELProcessor;

/**
 *
 * @author Juneau
 */
public class ElClientExample {

    public static void main(String[] args) {
        beanExample();
        variableExample();
        functionExample();
        classImportExample();
    }
    
    public static void beanExample(){
        ELProcessor el = new ELProcessor();
        // Assign a bean instance to a variable
        el.defineBean("c", new TestBean());
        el.setVariable("adder", "(x,y) -> x + y");
        // Utilize the bean instance variables
        Object result = el.eval("adder(c.num1, c.num2)");
        System.out.println(result);
    }
    
    public static void variableExample(){
        ELProcessor el = new ELProcessor();
        el.setVariable("sqrt", "x -> (x * x)");

        Object result = el.eval("sqrt(150)");
        System.out.println(result);
    }
    
    public static void functionExample(){
        ELProcessor el = new ELProcessor();
        try {
            el.defineFunction("org", "obtainMessage", "org.javaee7.chapter03.el.client.TestBean", "obtainMessage");
        } catch (ClassNotFoundException|NoSuchMethodException ex) {
            Logger.getLogger(ElClientExample.class.getName()).log(Level.SEVERE, null, ex);
        } 

        Object result = el.eval("org:obtainMessage()");
        System.out.println(result);
    }
    
     public static void classImportExample(){
        ELProcessor el = new ELProcessor();
        ELManager elMgr = el.getELManager();
        elMgr.importClass("org.javaee7.chapter03.el.client.TestBean");
        el.setVariable("bean", "new TestBean()");
        Object result = el.eval("bean.num1 + bean.num2");
         System.out.println(result);
    }
}
