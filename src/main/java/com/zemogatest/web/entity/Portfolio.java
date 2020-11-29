/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zemogatest.web.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author figue
 */
@Entity
@Table(name = "portfolio", catalog = "", schema = "zemoga_test_db")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Portfolio.findAll", query = "SELECT p FROM Portfolio p"),
    @NamedQuery(name = "Portfolio.findByIdportfolio", query = "SELECT p FROM Portfolio p WHERE p.idportfolio = :idportfolio"),
    @NamedQuery(name = "Portfolio.findByDescription", query = "SELECT p FROM Portfolio p WHERE p.description = :description"),
    @NamedQuery(name = "Portfolio.findByImageUrl", query = "SELECT p FROM Portfolio p WHERE p.imageUrl = :imageUrl"),
    @NamedQuery(name = "Portfolio.findByTwitterUserName", query = "SELECT p FROM Portfolio p WHERE p.twitterUserName = :twitterUserName"),
    @NamedQuery(name = "Portfolio.findByTitle", query = "SELECT p FROM Portfolio p WHERE p.title = :title"),
    @NamedQuery(name = "Portfolio.findByTittle", query = "SELECT p FROM Portfolio p WHERE p.tittle = :tittle"),
    @NamedQuery(name = "Portfolio.findByIdPortafolio", query = "SELECT p FROM Portfolio p WHERE p.idPortafolio = :idPortafolio")})
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idportfolio")
    private Integer idportfolio;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "image_url")
    private String imageUrl;
    @Size(max = 255)
    @Column(name = "twitter_user_name")
    private String twitterUserName;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "tittle")
    private String tittle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_portafolio")
    private int idPortafolio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private long id;
    
 
    public Portfolio() {
    }

    public Portfolio(Integer idportfolio) {
        this.idportfolio = idportfolio;
    }

    public Portfolio(Integer idportfolio, int idPortafolio) {
        this.idportfolio = idportfolio;
        this.idPortafolio = idPortafolio;
    }

    public Integer getIdportfolio() {
        return idportfolio;
    }

    public void setIdportfolio(Integer idportfolio) {
        this.idportfolio = idportfolio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getIdPortafolio() {
        return idPortafolio;
    }

    public void setIdPortafolio(int idPortafolio) {
        this.idPortafolio = idPortafolio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idportfolio != null ? idportfolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Portfolio)) {
            return false;
        }
        Portfolio other = (Portfolio) object;
        if ((this.idportfolio == null && other.idportfolio != null) || (this.idportfolio != null && !this.idportfolio.equals(other.idportfolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zemogatest.portfolio.entity.Portfolio[ idportfolio=" + idportfolio + " ]";
    }
    
}
