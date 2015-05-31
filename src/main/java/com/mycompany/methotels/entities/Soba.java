/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Fedor
 */
@Entity
@Table(name = "soba")
@NamedQueries({
    @NamedQuery(name = "Soba.findAll", query = "SELECT s FROM Soba s")})
public class Soba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SOBAID")
    private Integer sobaid;
    @Column(name = "IME")
    private String ime;
    @Column(name = "SPRAT")
    private Integer sprat;
    @Column(name = "TV")
    private String tv;
    @Column(name = "INTERNET")
    private String internet;
    @Column(name = "JACUZZI")
    private String jacuzzi;
    @JoinColumn(name = "GOSTID", referencedColumnName = "GOSTID")
    @ManyToOne
    private Gost gostid;

    @Inject
    public Soba() {
    }

    public Soba(Integer sobaid) {
        this.sobaid = sobaid;
    }

    public Integer getSobaid() {
        return sobaid;
    }

    public void setSobaid(Integer sobaid) {
        this.sobaid = sobaid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getSprat() {
        return sprat;
    }

    public void setSprat(Integer sprat) {
        this.sprat = sprat;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(String jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public Gost getGostid() {
        return gostid;
    }

    public void setGostid(Gost gostid) {
        this.gostid = gostid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sobaid != null ? sobaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.sobaid == null && other.sobaid != null) || (this.sobaid != null && !this.sobaid.equals(other.sobaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Soba[ sobaid=" + sobaid + " ]";
    }
    
}
