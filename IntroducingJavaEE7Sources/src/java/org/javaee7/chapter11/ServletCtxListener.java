
package org.javaee7.chapter11;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Servlet Context Listener:  Prints message when context is initialized
 * @author Juneau
 */
public class ServletCtxListener implements ServletContextListener {
    Thread printerThread = null;
    
    @Resource(name ="concurrent/AcmeThreadFactory")
    ManagedThreadFactory threadFactory;

    @Override
    public void contextInitialized(ServletContextEvent scEvent) {

        MessagePrinter printer = new MessagePrinter();
        Thread loggerThread = threadFactory.newThread(printer);
        loggerThread.start();
    }

    public void contextDestroyed(ServletContextEvent scEvent) {
        synchronized (printerThread) {
            printerThread.interrupt();
        }
    }
}