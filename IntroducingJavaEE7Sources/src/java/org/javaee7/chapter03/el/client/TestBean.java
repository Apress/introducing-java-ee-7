/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter03.el.client;

/**
 *
 * @author Juneau
 */
public class TestBean {
    
    private int num1 = 5;
    private int num2 = 7;

    /**
     * @return the num1
     */
    public int getNum1() {
        return num1;
    }

    /**
     * @param num1 the num1 to set
     */
    public void setNum1(int num1) {
        this.num1 = num1;
    }

    /**
     * @return the num2
     */
    public int getNum2() {
        return num2;
    }

    /**
     * @param num2 the num2 to set
     */
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    public static String obtainMessage(){
        return "Hello from the function";
    }
}
