/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.pojo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findByIdOrtherDetail", query = "SELECT o FROM OrderDetail o WHERE o.idOrtherDetail = :idOrtherDetail"),
    @NamedQuery(name = "OrderDetail.findByIdStore", query = "SELECT o FROM OrderDetail o WHERE o.idStore = :idStore"),
    @NamedQuery(name = "OrderDetail.findByQuantity", query = "SELECT o FROM OrderDetail o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderDetail.findByUnitPrice", query = "SELECT o FROM OrderDetail o WHERE o.unitPrice = :unitPrice")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orther_detail")
    private Integer idOrtherDetail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_store")
    private int idStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price")
    private int unitPrice;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
    @ManyToOne(optional = false)
    private Menu idMenu;
    @JoinColumn(name = "id_orther", referencedColumnName = "id_orther")
    @ManyToOne(optional = false)
    private Order1 idOrther;

    public OrderDetail() {
    }

    public OrderDetail(Integer idOrtherDetail) {
        this.idOrtherDetail = idOrtherDetail;
    }

    public OrderDetail(Integer idOrtherDetail, int idStore, int quantity, int unitPrice) {
        this.idOrtherDetail = idOrtherDetail;
        this.idStore = idStore;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Integer getIdOrtherDetail() {
        return idOrtherDetail;
    }

    public void setIdOrtherDetail(Integer idOrtherDetail) {
        this.idOrtherDetail = idOrtherDetail;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public Order1 getIdOrther() {
        return idOrther;
    }

    public void setIdOrther(Order1 idOrther) {
        this.idOrther = idOrther;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrtherDetail != null ? idOrtherDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.idOrtherDetail == null && other.idOrtherDetail != null) || (this.idOrtherDetail != null && !this.idOrtherDetail.equals(other.idOrtherDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvl.pojo.OrderDetail[ idOrtherDetail=" + idOrtherDetail + " ]";
    }
    
}
