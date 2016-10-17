
package org.javaee7.chapter02.jsf;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 *
 * @author Juneau
 */
@FacesComponent(value="components.SpecialComponent", createTag=true,
                namespace="http://www.apress.com/jsf/components")
public class SpecialComponent extends UIComponentBase {

    @Override
    public String getFamily() {
        // Do something here
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //...
}
