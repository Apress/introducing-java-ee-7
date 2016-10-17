
package org.javaee7.interfaces;

import java.math.BigDecimal;

/**
 *
 * @author Juneau
 */
public interface Widget {
    public BigDecimal getCost();
    public String getType();
    public static String PLASTIC = "Plastic";
    public static String METAL = "Metal";
    public static String GENERIC = "Generic";
}
