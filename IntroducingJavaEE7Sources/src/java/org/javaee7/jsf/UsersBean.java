/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.jsf;

import java.io.Serializable;
import java.util.Set;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.javaee7.entity.Users;
import org.javaee7.jpa.session.UsersSession;

/**
 *
 * @author Juneau
 */
@ManagedBean(name = "usersBean")
@SessionScoped
public class UsersBean implements Serializable {

    @EJB
    UsersSession ejbFacade;
    private Users users;
    @Inject
    Validator validator;

    public UsersBean() {
    }

    /**
     * Inserts a new user record into the database
     */
    public void createUser() {
        ejbFacade.create(getUsers());
    }

    /**
     * Validator method for a user ID
     *
     * @param context
     * @param component
     * @param value
     */
    public void validateUserId(FacesContext context,
            UIComponent component,
            Object value) {
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

    /**
     *
     * @param o
     */
    public void performValidation(Object o) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(o);
        for (ConstraintViolation<Object> violation : constraintViolations) {
            // do something 
        }
    }

    /**
     * @return the users
     */
    public Users getUsers() {
        if (users == null) {
            users = new Users();
        }

        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }
}
