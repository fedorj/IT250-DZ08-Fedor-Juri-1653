/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.pages;

import com.mycompany.methotels.dao.SobaDao;
import com.mycompany.methotels.entities.Soba;
import com.mycompany.methotels.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;


/**
 *
 * @author Fedor
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})
public class DodavanjeSobe {

    @Property
    private Soba soba;
    @Property
    private Soba onesoba;
    @Inject
    private SobaDao sobaDao;
    
    @Property
    private List<Soba> sobe;
    
    void onActivate(){
        if (sobe == null){
            sobe = new ArrayList<Soba>();
        }
        sobe = sobaDao.getListaSvihSoba();
    }
    
    @CommitAfter
    Object onSuccess(){
        sobaDao.dodajSobu(soba);
        return this;
    }
    
    @CommitAfter
    Object onActionFromDelete(int sobaid){
        sobaDao.obrisiSobu(sobaid);
        return this;
    }
}
