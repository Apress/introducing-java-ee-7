
package org.javaee7.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Juneau
 */
@Entity
@DiscriminatorValue("A")
public class WidgetA extends Product implements Serializable {
    
    @Column(name="COLOR")
    private String color;
    
    public WidgetA(){
        
    }
   

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    
   
}
