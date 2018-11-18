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
@Table(name = "GROCERIE1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grocerie1.findAll", query = "SELECT g FROM Grocerie1 g")
    , @NamedQuery(name = "Grocerie1.findByProductid", query = "SELECT g FROM Grocerie1 g WHERE g.productid = :productid")
    , @NamedQuery(name = "Grocerie1.findByProductname", query = "SELECT g FROM Grocerie1 g WHERE g.productname = :productname")
    , @NamedQuery(name = "Grocerie1.findByQuantity", query = "SELECT g FROM Grocerie1 g WHERE g.quantity = :quantity")
    , @NamedQuery(name = "Grocerie1.findByPrice", query = "SELECT g FROM Grocerie1 g WHERE g.price = :price")})
public class Grocerie1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;

    public Grocerie1() {
    }

    public Grocerie1(Integer productid) {
        this.productid = productid;
    }

    public Grocerie1(Integer productid, String productname, int quantity, double price) {
        this.productid = productid;
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grocerie1)) {
            return false;
        }
        Grocerie1 other = (Grocerie1) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Grocerie1[ productid=" + productid + " ]";
    }
    
}
