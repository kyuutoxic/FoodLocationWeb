/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyuut
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "Menu.findByMenuName", query = "SELECT m FROM Menu m WHERE m.menuName = :menuName"),
    @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price"),
    @NamedQuery(name = "Menu.findByMenuStatus", query = "SELECT m FROM Menu m WHERE m.menuStatus = :menuStatus"),
    @NamedQuery(name = "Menu.findByMenuFrom", query = "SELECT m FROM Menu m WHERE m.menuFrom = :menuFrom"),
    @NamedQuery(name = "Menu.findByMenuTo", query = "SELECT m FROM Menu m WHERE m.menuTo = :menuTo"),
    @NamedQuery(name = "Menu.findByCreatedDate", query = "SELECT m FROM Menu m WHERE m.createdDate = :createdDate"),
    @NamedQuery(name = "Menu.findByUpdateDate", query = "SELECT m FROM Menu m WHERE m.updateDate = :updateDate")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu")
    private Integer idMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "menu_name")
    private String menuName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "menu_note")
    private String menuNote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "menu_status")
    private boolean menuStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "menu_from")
    private String menuFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "menu_to")
    private String menuTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "image")
    private String image;
    @Transient
    @JsonIgnore
    private int typeId;
    @Transient
    @JsonIgnore
    private MultipartFile file;
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private Type idType;
    @JoinColumn(name = "id_store", referencedColumnName = "id_user")
    @ManyToOne
    @JsonManagedReference
    private User idStore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenu")
    private Collection<OrderDetail> orderDetailCollection;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Menu(Integer idMenu, String menuName, float price, boolean menuStatus, String menuFrom, String menuTo, Date createdDate, Date updateDate, String image) {
        this.idMenu = idMenu;
        this.menuName = menuName;
        this.price = price;
        this.menuStatus = menuStatus;
        this.menuFrom = menuFrom;
        this.menuTo = menuTo;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
        this.image = image;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMenuNote() {
        return menuNote;
    }

    public void setMenuNote(String menuNote) {
        this.menuNote = menuNote;
    }

    public boolean getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }

    public String getMenuFrom() {
        return menuFrom;
    }

    public void setMenuFrom(String menuFrom) {
        this.menuFrom = menuFrom;
    }

    public String getMenuTo() {
        return menuTo;
    }

    public void setMenuTo(String menuTo) {
        this.menuTo = menuTo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getIdType() {
        return idType;
    }

    public void setIdType(Type idType) {
        this.idType = idType;
    }

    public User getIdStore() {
        return idStore;
    }

    public void setIdStore(User idStore) {
        this.idStore = idStore;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvl.pojo.Menu[ idMenu=" + idMenu + " ]";
    }

    /**
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
