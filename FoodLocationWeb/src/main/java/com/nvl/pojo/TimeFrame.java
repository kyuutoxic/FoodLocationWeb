/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.pojo;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
<<<<<<< HEAD
 * @author Admin
=======
 * @author Copeoshihi
>>>>>>> dbed2fb3b52ac42832f141df85b6ec94d3d0d8ef
 */
@Entity
@Table(name = "time_frame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeFrame.findAll", query = "SELECT t FROM TimeFrame t"),
    @NamedQuery(name = "TimeFrame.findByIdTimeFrame", query = "SELECT t FROM TimeFrame t WHERE t.idTimeFrame = :idTimeFrame"),
    @NamedQuery(name = "TimeFrame.findByName", query = "SELECT t FROM TimeFrame t WHERE t.name = :name"),
    @NamedQuery(name = "TimeFrame.findByFrom", query = "SELECT t FROM TimeFrame t WHERE t.from = :from"),
    @NamedQuery(name = "TimeFrame.findByTo", query = "SELECT t FROM TimeFrame t WHERE t.to = :to")})
public class TimeFrame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_time_frame")
    private Integer idTimeFrame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimeFrame")
    private Collection<Menu> menuCollection;

    public TimeFrame() {
    }

    public TimeFrame(Integer idTimeFrame) {
        this.idTimeFrame = idTimeFrame;
    }

    public TimeFrame(Integer idTimeFrame, String name, Date from, Date to) {
        this.idTimeFrame = idTimeFrame;
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public Integer getIdTimeFrame() {
        return idTimeFrame;
    }

    public void setIdTimeFrame(Integer idTimeFrame) {
        this.idTimeFrame = idTimeFrame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTimeFrame != null ? idTimeFrame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeFrame)) {
            return false;
        }
        TimeFrame other = (TimeFrame) object;
        if ((this.idTimeFrame == null && other.idTimeFrame != null) || (this.idTimeFrame != null && !this.idTimeFrame.equals(other.idTimeFrame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvl.pojo.TimeFrame[ idTimeFrame=" + idTimeFrame + " ]";
    }
    
}
