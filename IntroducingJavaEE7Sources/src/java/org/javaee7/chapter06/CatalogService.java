
package org.javaee7.chapter06;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;
import org.javaee7.beans.Order;
import org.javaee7.interfaces.Widget;

/**
 *
 * @author Juneau
 */
public class CatalogService {
    
    @ValidateOnExecution(type=javax.validation.executable.ExecutableType.NON_GETTER_METHODS)
    public Order placeOrder(
            @NotNull @Size(min = 3, max = 20) String customerNumber,
            @NotNull @Valid Widget widget,
            @Min(1) int quantity) {
        Order order = new Order();
        order.setCustomerNumber(customerNumber);
        order.setProduct(widget);
        order.setQuantity(quantity);
        
        // Send the order to the database
        return order;
    }
}
