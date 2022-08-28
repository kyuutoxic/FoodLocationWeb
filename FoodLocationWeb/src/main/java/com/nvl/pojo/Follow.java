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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kyuut
 */
@Entity
@Table(name = "follow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Follow.findAll", query = "SELECT f FROM Follow f"),
    @NamedQuery(name = "Follow.findByIdFollow", query = "SELECT f FROM Follow f WHERE f.idFollow = :idFollow")})
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_follow")
    private Integer idFollow;
    @JoinColumn(name = "id_store", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idStore;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;

    public Follow() {
    }

    public Follow(Integer idFollow) {
        this.idFollow = idFollow;
    }

    public Integer getIdFollow() {
        return idFollow;
    }

    public void setIdFollow(Integer idFollow) {
        this.idFollow = idFollow;
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
        hash += (idFollow != null ? idFollow.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Follow)) {
            return false;
        }
        Follow other = (Follow) object;
        if ((this.idFollow == null && other.idFollow != null) || (this.idFollow != null && !this.idFollow.equals(other.idFollow))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nvl.pojo.Follow[ idFollow=" + idFollow + " ]";
    }
    
}
