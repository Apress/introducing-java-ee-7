
package org.javaee7.chapter07;

import java.lang.annotation.Annotation;
import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Juneau
 */
@Named("Order")
public class OrderProcessor {
    @Inject Bean<OrderProcessor> bean;
    
    public String getBeanName(){
        return bean.getName();
    }
    
    public Class<? extends Annotation> getScope(){
        return bean.getScope();
    }
}
