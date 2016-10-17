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
@ValidateOnExecution(type={javax.validation.executable.ExecutableType.GETTER_METHODS, 
                           javax.validation.executable.ExecutableType.CONSTRUCTORS})
public class WidgetOrderingService extends CatalogService {
    
    public WidgetOrderingService(){
    }

    @Override
    public Order placeOrder(
            @NotNull @Size(min = 3, max = 20) String customerNumber,
            @NotNull @Valid Widget widget,
            @Min(1) int quantity) {
        Order order = new Order();
        order.setCustomerNumber(customerNumber);
        order.setProduct(widget);
        order.setQuantity(quantity);
        // Do something specific with widget order
        return order;

    }
}
