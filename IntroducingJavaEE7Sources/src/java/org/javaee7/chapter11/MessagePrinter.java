
package org.javaee7.chapter11;

/**
 *
 * @author Juneau
 */
public class MessagePrinter implements Runnable {

    @Override
    public void run() {
        printMessage();
    }
    
    public void printMessage(){
        System.out.println("Here we are performing some work...");
    }
}
