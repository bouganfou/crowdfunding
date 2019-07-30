package com.example.crowdfunding.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Adresse.
 */
@Entity
@Table(name = "adresse")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "pays")
    private String pays;

    @Column(name = "region")
    private String region;

    @Column(name = "prefecture")
    private String prefecture;

    @Column(name = "commun")
    private String commun;

    @ManyToOne
    @JsonIgnoreProperties("adresses")
    private Projet projet;

//    @ManyToOne
//    @JsonIgnoreProperties("adrPersonne")
//    private Personne personne;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public Adresse adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPays() {
        return pays;
    }

    public Adresse pays(String pays) {
        this.pays = pays;
        return this;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public Adresse region(String region) {
        this.region = region;
        return this;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public Adresse prefecture(String prefecture) {
        this.prefecture = prefecture;
        return this;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCommun() {
        return commun;
    }

    public Adresse commun(String commun) {
        this.commun = commun;
        return this;
    }

    public void setCommun(String commun) {
        this.commun = commun;
    }

    public Projet getProjet() {
        return projet;
    }

    public Adresse projet(Projet projet) {
        this.projet = projet;
        return this;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Adresse adresse = (Adresse) o;
        if (adresse.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), adresse.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Adresse{" +
            "id=" + getId() +
            ", adresse='" + getAdresse() + "'" +
            ", pays='" + getPays() + "'" +
            ", region='" + getRegion() + "'" +
            ", prefecture='" + getPrefecture() + "'" +
            ", commun='" + getCommun() + "'" +
            "}";
    }
}
