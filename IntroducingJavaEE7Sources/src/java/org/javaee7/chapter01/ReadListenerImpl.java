
package org.javaee7.chapter01;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

/**
 * Servlet Listener Implementation
 * 
 * @author Juneau
 */
public class ReadListenerImpl implements ReadListener {

    private ServletInputStream is = null;
    private AsyncContext context = null;
    private ServletOutputStream os = null;

    public ReadListenerImpl(ServletInputStream in, AsyncContext ac) {
        this.is = in;
        this.context = ac;
        System.out.println("read listener initialized");
    }
    
    public ReadListenerImpl(ServletInputStream in, ServletOutputStream os) {
        this.is = in;
        this.os = os;

    }

    @Override
    public void onDataAvailable() {
        System.out.println("onDataAvailable");
        try {
            StringBuilder sb = new StringBuilder();
            int len = -1;
            byte b[] = new byte[1024];
            while (is.isReady()
                    && (!is.isFinished())) {
                len = is.read(b);
                String data = new String(b, 0, len);
                System.out.println(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(ReadListenerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
        public void onAllDataRead() {
        System.out.println("onAllDataRead");
        context.complete();
       
    }

    @Override
        public void onError(Throwable thrwbl) {
        System.out.println("Error: " + thrwbl);
        context.complete();
    }
    
}
