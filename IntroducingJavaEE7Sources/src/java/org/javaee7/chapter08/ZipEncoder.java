package org.javaee7.chapter08;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

/**
 *
 * @author Juneau
 */
// Uncomment to see the Zip Encoder in action
//@Provider
public class ZipEncoder implements WriterInterceptor {

    public void aroundWriteTo(WriterInterceptorContext ctx) throws IOException, WebApplicationException {
        ZipOutputStream zip = new ZipOutputStream(ctx.getOutputStream());
       
        try {
            zip.putNextEntry(new ZipEntry("Test Entry"));
            ctx.setOutputStream(zip);
            ctx.proceed();
        } catch (ZipException ex){
            System.out.println("ZipEncoder ERROR: " + ex);  
        } finally {
            zip.finish();
        }
    }
}

