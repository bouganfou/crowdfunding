package com.example.crowdfunding.entities;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ==============================================================
 */


@Entity
@Table(name = "contributeur")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@DiscriminatorValue("C")
public class Contributeur extends Personne {

    private static final long serialVersionUID = 1L;



    @OneToMany(mappedBy = "contributeur")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Rendement> rendements = new HashSet<>();
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "contributeur_contribution",
               joinColumns = @JoinColumn(name = "contributeurs_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "contributions_id", referencedColumnName = "id"))
    private Set<Contribution> contributions = new HashSet<>();


    public Set<Rendement> getRendements() {
        return rendements;
    }

    public Contributeur rendements(Set<Rendement> rendements) {
        this.rendements = rendements;
        return this;
    }

    public Contributeur addRendement(Rendement rendement) {
        this.rendements.add(rendement);
        rendement.setContributeur(this);
        return this;
    }

    public Contributeur removeRendement(Rendement rendement) {
        this.rendements.remove(rendement);
        rendement.setContributeur(null);
        return this;
    }

    public void setRendements(Set<Rendement> rendements) {
        this.rendements = rendements;
    }

    public Set<Contribution> getContributions() {
        return contributions;
    }

    public Contributeur contributions(Set<Contribution> contributions) {
        this.contributions = contributions;
        return this;
    }

    public Contributeur addContribution(Contribution contribution) {
        this.contributions.add(contribution);
        contribution.getContributeurs().add(this);
        return this;
    }

    public Contributeur removeContribution(Contribution contribution) {
        this.contributions.remove(contribution);
        contribution.getContributeurs().remove(this);
        return this;
    }

    public void setContributions(Set<Contribution> contributions) {
        this.contributions = contributions;
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
        Contributeur contributeur = (Contributeur) o;
        if (contributeur.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), contributeur.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Contributeur{" +
            "id=" + getId() +
            "}";
    }
}
