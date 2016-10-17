
package org.javaee7.chapter01;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.WebConnection;

/**
 *
 * @author Juneau
 */
public class EchoProtocolHandler implements HttpUpgradeHandler {

    @Override
    public void init(WebConnection wc) {
        try {
              System.out.println("Upgrading the protocol...");
              ServletInputStream input = wc.getInputStream();
              ServletOutputStream output = wc.getOutputStream();
              ReadListener readListener = new ReadListenerImpl(input,output);
              input.setReadListener(readListener);
      } catch (Exception e){
            System.out.println("Exception has occurred " + e);
      }

    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
