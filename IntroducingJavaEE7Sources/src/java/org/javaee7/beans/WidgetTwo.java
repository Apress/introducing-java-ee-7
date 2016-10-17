
package org.javaee7.beans;

import java.math.BigDecimal;
import org.javaee7.interfaces.Widget;
import org.javaee7.qualifier.Metal;

/**
 *
 * @author Juneau
 */
@Metal
public class WidgetTwo implements Widget {
    private String name;
    private String type = Widget.METAL;
    private String color;
    private BigDecimal price = new BigDecimal(12.99);

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }
    
    public BigDecimal getCost() {
        return price;
    }
    
    public String getType(){
        return type;
    }
    
}
