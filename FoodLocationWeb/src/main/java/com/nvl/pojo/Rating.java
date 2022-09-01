/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nvl.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Copeoshihi
 */
@Entity
@Table(name = "rating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r"),
    @NamedQuery(name = "Rating.findByIdRating", query = "SELECT r FROM Rating r WHERE r.idRating = :idRating"),
    @NamedQuery(name = "Rating.findByRateQuality", query = "SELECT r FROM Rating r WHERE r.rateQuality = :rateQuality"),
    @NamedQuery(name = "Rating.findByRateService", query = "SELECT r FROM Rating r WHERE r.rateService = :rateService"),
    @NamedQuery(name = "Rating.findByRateSpace", query = "SELECT r FROM Rating r WHERE r.rateSpace = :rateSpace"),
    @NamedQuery(name = "Rating.findByRatePrice", query = "SELECT r FROM Rating r WHERE r.ratePrice = :ratePrice"),
    @NamedQuery(name = "Rating.findByRateLocation", query = "SELECT r FROM Rating r WHERE r.rateLocation = :rateLocation"),
    @NamedQuery(name = "Rating.findByCreatedDate", query = "SELECT r FROM Rating r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "Rating.findByUpdateDate", query = "SELECT r FROM Rating r WHERE r.updateDate = :updateDate")})
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rating")
    private Integer idRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_quality")
    private int rateQuality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_service")
    private int rateService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_space")
    private int rateSpace;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_price")
    private int ratePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_location")
    private int rateLocation;
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
    @JoinColumn(name = "id_store", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idStore;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;

    public Rating() {
    }

    public Rating(Integer idRating) {
        this.idRating = idRating;
    }

    public Rating(Integer idRating, int rateQuality, int rateService, int rateSpace, int ratePrice, int rateLocation, Date createdDate, Date updateDate) {
        this.idRating = idRating;
        this.rateQuality = rateQuality;
        this.rateService = rateService;
        this.rateSpace = rateSpace;
        this.ratePrice = ratePrice;
        this.rateLocation = rateLocation;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public Integer getIdRating() {
        return idRating;
    }

    public void setIdRating(Integer idRating) {
        this.idRating = idRating;
    }

    public int getRateQuality() {
        return rateQuality;
    }

    public void setRateQuality(int rateQuality) {
        this.rateQuality = rateQuality;
    }

    public int getRateService() {
        return rateService;
    }

    public void setRateService(int rateService) {
        this.rateService = rateService;
    }

    public int getRateSpace() {
        return rateSpace;
    }

    public void setRateSpace(int rateSpace) {
        this.rateSpace = rateSpace;
    }

    public int getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(int ratePrice) {
        this.ratePrice = ratePrice;
    }

    public int getRateLocation() {
        return rateLocation;
    }

    public void setRateLocation(int rateLocation) {
        this.rateLocation = rateLocation;
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

    public User getIdStore() {
        return idStore;
    }

    public void setIdStore(User idStore) {
        this.idStore = idStore;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRating != null ? idRating.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.idRating == null && other.idRating != null) || (this.idRating != null && !this.idRating.equals(other.idRating))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvl.pojo.Rating[ idRating=" + idRating + " ]";
    }
    
}
