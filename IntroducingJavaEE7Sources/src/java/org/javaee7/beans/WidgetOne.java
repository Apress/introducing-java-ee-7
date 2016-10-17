
package org.javaee7.beans;

import java.math.BigDecimal;
import org.javaee7.interfaces.Widget;
import org.javaee7.qualifier.Plastic;


/**
 *
 * @author Juneau
 */
@Plastic
public class WidgetOne implements Widget {
    private String name;
    private String type = Widget.PLASTIC;
    private String color;
    private BigDecimal price = new BigDecimal(15.29);
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
