
package org.javaee7.chapter02.jsf;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Juneau
 */
@Named(value="viewActionManagedBean")
@RequestScoped
public class ViewActionManagedBean {
    
    private String msgFromBean = "Original Message in Bean...";

    /**
     * Creates a new instance of ViewActionManagedBean
     */
    public ViewActionManagedBean() {
    }

    public String viewActionExample() {
        msgFromBean = "The view action has been invoked!";
        System.out.println("This is being written to the server log when the "
                + "view is accessed...");
        return null;
    }

    /**
     * @return the msgFromBean
     */
    public String getMsgFromBean() {
        return msgFromBean;
    }

    /**
     * @param msgFromBean the msgFromBean to set
     */
    public void setMsgFromBean(String msgFromBean) {
        this.msgFromBean = msgFromBean;
    }


}
