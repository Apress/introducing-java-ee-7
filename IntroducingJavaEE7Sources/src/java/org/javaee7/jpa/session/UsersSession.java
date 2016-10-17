/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.jpa.session;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.javaee7.entity.Users;

/**
 *
 * @author Juneau
 */
@Stateless
public class UsersSession extends AbstractFacade<Users> implements Serializable {

    @PersistenceContext(unitName = "IntroToJavaEE7PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersSession() {
        super(Users.class);
    }
    
}
