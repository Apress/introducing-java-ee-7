
package org.javaee7.chapter06;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.validation.Validation;
import javax.validation.executable.ExecutableValidator;

/**
 *
 * @author Juneau
 */
public class MethodValidationExamples {
    
    public MethodValidationExamples(){}
    
    public ExecutableValidator getExecutableValidator(){
        ExecutableValidator executableValidator = Validation
            .buildDefaultValidatorFactory().getValidator().forExecutables();
        return executableValidator;
    }
    
    public void validateEmployeeId(FacesContext context,
                                   UIComponent component,
                                   Object value){
        String idValue = (String) value;
        
        boolean result = idValue.matches("[0-9]{7}[JJ]");
        if (!result) {
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary(component.getClientId().substring(component.getClientId().indexOf(":") + 1) + " issue, please use the format XXXXXXXJJ");
            context.addMessage(component.getClientId(), message);
            // Set the component's valid attribute to false
            ((UIInput) component).setValid(false);
        } 
    }
    
    
}
