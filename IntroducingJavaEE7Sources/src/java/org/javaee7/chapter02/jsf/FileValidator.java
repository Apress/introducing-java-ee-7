/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter02.jsf;

import java.io.InputStream;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author Juneau
 */
@FacesValidator(value = "FileValidator")
public class FileValidator implements Validator {

    public FileValidator() {
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part file = (Part) value;
        String text = null;
        try {
            InputStream is = file.getInputStream();
            text = new Scanner(is).useDelimiter("\\A").next();
        } catch (Exception ex) {
            throw new ValidatorException(new FacesMessage("Exception thrown"));
        } 
    }
                    
}


