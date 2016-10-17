
package org.javaee7.chapter08;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 *
 * @author Juneau
 */
@Provider
public class MyProvider implements WriterInterceptor {

    @Override
    public void aroundWriteTo(WriterInterceptorContext ctx) throws IOException, WebApplicationException {
        String customMessage = "This is a custom message";
        OutputStream os = ctx.getOutputStream();
        ctx.proceed();
        os.write(customMessage.getBytes());
    }
    
}
