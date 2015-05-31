/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.User;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fedor
 */
public class UserDaoImpl implements UserDao {

    @Inject
    private Session session;

    @Override
    public User checkUser(String mail, String pass) {
        try {
            User u = (User) session.createCriteria(User.class).add(Restrictions.eq("mail",
                    mail)).add(Restrictions.eq("pass", pass)).uniqueResult();
            if (u != null) {
                return u;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public User registerUser(User user) {
        return (User) session.merge(user);
    }

    @Override
    public boolean checkIfEmailExists(String mail) {
        Long rows = (Long) session.createCriteria(User.class).add(Restrictions.eq("mail",
                mail)).setProjection(Projections.rowCount()).uniqueResult();
        return (rows == 0) ? false : true;
    }

}
