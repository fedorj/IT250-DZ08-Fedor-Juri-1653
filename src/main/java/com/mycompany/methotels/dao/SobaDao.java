/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.Soba;
import java.util.List;

/**
 *
 * @author Fedor
 */
public interface SobaDao {
    public List<Soba> getListaSvihSoba();
    public Soba getSobaById(Integer sobaid);
    public void dodajSobu(Soba soba);
    public void obrisiSobu(int sobaid);
}
