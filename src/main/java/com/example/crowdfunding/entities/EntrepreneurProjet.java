package com.example.crowdfunding.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * ==============================================================
 */

@Entity
@Table(name = "entrepreneur_projet")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EntrepreneurProjet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_creation")
    private Instant dateCreation;

    @Column(name = "date_modification")
    private Instant dateModification;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateCreation() {
        return dateCreation;
    }

    public EntrepreneurProjet dateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    public void setDateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Instant getDateModification() {
        return dateModification;
    }

    public EntrepreneurProjet dateModification(Instant dateModification) {
        this.dateModification = dateModification;
        return this;
    }

    public void setDateModification(Instant dateModification) {
        this.dateModification = dateModification;
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
        EntrepreneurProjet entrepreneurProjet = (EntrepreneurProjet) o;
        if (entrepreneurProjet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), entrepreneurProjet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EntrepreneurProjet{" +
            "id=" + getId() +
            ", dateCreation='" + getDateCreation() + "'" +
            ", dateModification='" + getDateModification() + "'" +
            "}";
    }
}
