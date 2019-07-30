package com.example.crowdfunding.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ==============================================================
 */

@Entity
@Table(name = "contribution")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Contribution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "montant_invistissement")
    private Integer montantInvistissement;

    @Column(name = "data_invistissement")
    private Instant dataInvistissement;

    @ManyToMany(mappedBy = "contributions")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Contributeur> contributeurs = new HashSet<>();

    @ManyToMany(mappedBy = "contributions")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Projet> projets = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMontantInvistissement() {
        return montantInvistissement;
    }

    public Contribution montantInvistissement(Integer montantInvistissement) {
        this.montantInvistissement = montantInvistissement;
        return this;
    }

    public void setMontantInvistissement(Integer montantInvistissement) {
        this.montantInvistissement = montantInvistissement;
    }

    public Instant getDataInvistissement() {
        return dataInvistissement;
    }

    public Contribution dataInvistissement(Instant dataInvistissement) {
        this.dataInvistissement = dataInvistissement;
        return this;
    }

    public void setDataInvistissement(Instant dataInvistissement) {
        this.dataInvistissement = dataInvistissement;
    }

    public Set<Contributeur> getContributeurs() {
        return contributeurs;
    }

    public Contribution contributeurs(Set<Contributeur> contributeurs) {
        this.contributeurs = contributeurs;
        return this;
    }

    public Contribution addContributeur(Contributeur contributeur) {
        this.contributeurs.add(contributeur);
        contributeur.getContributions().add(this);
        return this;
    }

    public Contribution removeContributeur(Contributeur contributeur) {
        this.contributeurs.remove(contributeur);
        contributeur.getContributions().remove(this);
        return this;
    }

    public void setContributeurs(Set<Contributeur> contributeurs) {
        this.contributeurs = contributeurs;
    }

    public Set<Projet> getProjets() {
        return projets;
    }

    public Contribution projets(Set<Projet> projets) {
        this.projets = projets;
        return this;
    }

    public Contribution addProjet(Projet projet) {
        this.projets.add(projet);
        projet.getContributions().add(this);
        return this;
    }

    public Contribution removeProjet(Projet projet) {
        this.projets.remove(projet);
        projet.getContributions().remove(this);
        return this;
    }

    public void setProjets(Set<Projet> projets) {
        this.projets = projets;
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
        Contribution contribution = (Contribution) o;
        if (contribution.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), contribution.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Contribution{" +
            "id=" + getId() +
            ", montantInvistissement=" + getMontantInvistissement() +
            ", dataInvistissement='" + getDataInvistissement() + "'" +
            "}";
    }
}
