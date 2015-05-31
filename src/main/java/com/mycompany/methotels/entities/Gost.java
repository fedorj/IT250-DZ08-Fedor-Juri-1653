/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Fedor
 */
@Entity
@Table(name = "gost")
@NamedQueries({
    @NamedQuery(name = "Gost.findAll", query = "SELECT g FROM Gost g")})
public class Gost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GOSTID")
    private Integer gostid;
    @Column(name = "IME")
    private String ime;
    @Column(name = "PREZIME")
    private String prezime;
    @Column(name = "DOB")
    private Integer dob;
    @OneToMany(mappedBy = "gostid")
    private List<Soba> sobaList;

    @Inject
    public Gost() {
    }

    public Gost(Integer gostid) {
        this.gostid = gostid;
    }

    public Integer getGostid() {
        return gostid;
    }

    public void setGostid(Integer gostid) {
        this.gostid = gostid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getDob() {
        return dob;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }

    public List<Soba> getSobaList() {
        return sobaList;
    }

    public void setSobaList(List<Soba> sobaList) {
        this.sobaList = sobaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gostid != null ? gostid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gost)) {
            return false;
        }
        Gost other = (Gost) object;
        if ((this.gostid == null && other.gostid != null) || (this.gostid != null && !this.gostid.equals(other.gostid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Gost[ gostid=" + gostid + " ]";
    }
    
}
