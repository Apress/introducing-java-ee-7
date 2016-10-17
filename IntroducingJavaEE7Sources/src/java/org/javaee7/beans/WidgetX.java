
package org.javaee7.beans;

import java.math.BigDecimal;
import javax.enterprise.inject.Default;
import org.javaee7.interfaces.Widget;

/**
 *
 * @author Juneau
 */
@Default
public class WidgetX implements Widget {
    
    private String name;
    String type = Widget.GENERIC;
    private String color;
    private BigDecimal price = new BigDecimal(12.99);
    
    public String getType(){
        return type;
    }

    @Override
    public BigDecimal getCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
