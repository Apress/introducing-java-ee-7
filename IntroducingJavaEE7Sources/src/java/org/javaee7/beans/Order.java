
package org.javaee7.beans;

import java.math.BigDecimal;
import org.javaee7.interfaces.Widget;

/**
 *
 * @author Juneau
 */
public class Order {
    
    private Widget product;
    private String customerNumber;
    private int quantity;
    private BigDecimal total;

    /**
     * @return the product
     */
    public Widget getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Widget product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the total
     */
    //@ValidateExecutable(type=GETTER_METHODS)
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return the customerNumber
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * @param customerNumber the customerNumber to set
     */
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
    
    
    public void calculateTotal(){
        if (product != null){
            total = product.getCost().multiply(new BigDecimal(quantity));
        } else {
            total = new BigDecimal(0.00);
        }
    }
}
