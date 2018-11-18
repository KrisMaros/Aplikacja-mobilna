/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Krzychu-x
 */
@Entity
@Table(name = "STORE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
    , @NamedQuery(name = "Store.findByStoreid", query = "SELECT s FROM Store s WHERE s.storeid = :storeid")
    , @NamedQuery(name = "Store.findByAddressline1", query = "SELECT s FROM Store s WHERE s.addressline1 = :addressline1")
    , @NamedQuery(name = "Store.findByAddressline2", query = "SELECT s FROM Store s WHERE s.addressline2 = :addressline2")
    , @NamedQuery(name = "Store.findByPostcode", query = "SELECT s FROM Store s WHERE s.postcode = :postcode")})
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STOREID")
    private Integer storeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "POSTCODE")
    private String postcode;

    public Store() {
    }

    public Store(Integer storeid) {
        this.storeid = storeid;
    }

    public Store(Integer storeid, String addressline1, String addressline2, String postcode) {
        this.storeid = storeid;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.postcode = postcode;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeid != null ? storeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Store)) {
            return false;
        }
        Store other = (Store) object;
        if ((this.storeid == null && other.storeid != null) || (this.storeid != null && !this.storeid.equals(other.storeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Store[ storeid=" + storeid + " ]";
    }
    
}
