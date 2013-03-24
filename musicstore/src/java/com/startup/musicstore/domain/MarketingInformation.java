/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author geoffrey
 */
@Entity
public class MarketingInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String statusOfInformation;
    @OneToOne
    private Album album;
    @OneToOne(orphanRemoval=true,cascade= CascadeType.ALL)
    private ArtistInformation artistInformation;
    @OneToOne(orphanRemoval=true,cascade= CascadeType.ALL)
    private Review review;

    public String getStatusOfInformation() {
        return statusOfInformation;
    }

    public void setStatusOfInformation(String statusOfInformation) {
        this.statusOfInformation = statusOfInformation;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public ArtistInformation getArtistInformation() {
        return artistInformation;
    }

    public void setArtistInformation(ArtistInformation artistInformation) {
        this.artistInformation = artistInformation;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarketingInformation)) {
            return false;
        }
        MarketingInformation other = (MarketingInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.MarketingInformation[ id=" + id + " ]";
    }
    
}
