/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.entities.Gost;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author Fedor
 */
public class DodavanjeGosta {

    @Property
    private Gost gost;
    @Inject
    private Session session;

    @Property
    private ArrayList<Gost> gosti;

    void onActivate() {
        if (gosti == null) {
            gosti = new ArrayList<Gost>();
        }
        gosti = (ArrayList<Gost>) session.createCriteria(Gost.class).list();
    }

    @CommitAfter
    Object onSuccess() {
        session.persist(gost);
        return this;
    }

}
