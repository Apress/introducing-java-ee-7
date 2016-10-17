/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.services;

import java.util.concurrent.Executor;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author Juneau
 */
@Path("/async/longRunningservice")
public class LongRunningService {

    @Resource(name = "concurrent/BatchExecutor")
    ManagedExecutorService mes;

    @GET
    public void longRunningOp(@Suspended final AsyncResponse ar) {
        mes.submit(
                new Runnable() {
            public void run() {
                // Long running operation
                ar.resume("Return asynchrounosly!");
            }
        });
    }
}
