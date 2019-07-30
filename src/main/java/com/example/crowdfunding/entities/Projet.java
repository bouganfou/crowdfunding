package com.example.crowdfunding.entities;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ==============================================================
 */

@Entity
@Table(name = "projet")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_projet")
    private String nomProjet;

    @Column(name = "description_projet")
    private String descriptionProjet;

    @Column(name = "delai_projet")
    private String delaiProjet;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "nature_projet")
    private String natureProjet;

    @Column(name = "is_cloture")
    private Boolean isCloture;

    @Column(name = "fonds_apportes")
    private Double fondsApportes;

    @Column(name = "fonds_a_lever")
    private Double fondsALever;

    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<TypeProjet> typeProjets = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Adresse> adresses = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<FichierAssocier> fichierAssociers = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PlanProjet> planProjets = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PlanningExecution> planningExecutions = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Rendement> rendements = new HashSet<>();
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "projet_contribution",
               joinColumns = @JoinColumn(name = "projets_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "contributions_id", referencedColumnName = "id"))
    private Set<Contribution> contributions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public Projet nomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
        return this;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public Projet descriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
        return this;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public String getDelaiProjet() {
        return delaiProjet;
    }

    public Projet delaiProjet(String delaiProjet) {
        this.delaiProjet = delaiProjet;
        return this;
    }

    public void setDelaiProjet(String delaiProjet) {
        this.delaiProjet = delaiProjet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Projet dateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getNatureProjet() {
        return natureProjet;
    }

    public Projet natureProjet(String natureProjet) {
        this.natureProjet = natureProjet;
        return this;
    }

    public void setNatureProjet(String natureProjet) {
        this.natureProjet = natureProjet;
    }

    public Boolean isIsCloture() {
        return isCloture;
    }

    public Projet isCloture(Boolean isCloture) {
        this.isCloture = isCloture;
        return this;
    }

    public void setIsCloture(Boolean isCloture) {
        this.isCloture = isCloture;
    }

    public Double getFondsApportes() {
        return fondsApportes;
    }

    public Projet fondsApportes(Double fondsApportes) {
        this.fondsApportes = fondsApportes;
        return this;
    }

    public void setFondsApportes(Double fondsApportes) {
        this.fondsApportes = fondsApportes;
    }

    public Double getFondsALever() {
        return fondsALever;
    }

    public Projet fondsALever(Double fondsALever) {
        this.fondsALever = fondsALever;
        return this;
    }

    public void setFondsALever(Double fondsALever) {
        this.fondsALever = fondsALever;
    }

    public Set<TypeProjet> getTypeProjets() {
        return typeProjets;
    }

    public Projet typeProjets(Set<TypeProjet> typeProjets) {
        this.typeProjets = typeProjets;
        return this;
    }

    public Projet addTypeProjet(TypeProjet typeProjet) {
        this.typeProjets.add(typeProjet);
        typeProjet.setProjet(this);
        return this;
    }

    public Projet removeTypeProjet(TypeProjet typeProjet) {
        this.typeProjets.remove(typeProjet);
        typeProjet.setProjet(null);
        return this;
    }

    public void setTypeProjets(Set<TypeProjet> typeProjets) {
        this.typeProjets = typeProjets;
    }

    public Set<Adresse> getAdresses() {
        return adresses;
    }

    public Projet adresses(Set<Adresse> adresses) {
        this.adresses = adresses;
        return this;
    }

    public Projet addAdresse(Adresse adresse) {
        this.adresses.add(adresse);
        adresse.setProjet(this);
        return this;
    }

    public Projet removeAdresse(Adresse adresse) {
        this.adresses.remove(adresse);
        adresse.setProjet(null);
        return this;
    }

    public void setAdresses(Set<Adresse> adresses) {
        this.adresses = adresses;
    }

    public Set<FichierAssocier> getFichierAssociers() {
        return fichierAssociers;
    }

    public Projet fichierAssociers(Set<FichierAssocier> fichierAssociers) {
        this.fichierAssociers = fichierAssociers;
        return this;
    }

    public Projet addFichierAssocier(FichierAssocier fichierAssocier) {
        this.fichierAssociers.add(fichierAssocier);
        fichierAssocier.setProjet(this);
        return this;
    }

    public Projet removeFichierAssocier(FichierAssocier fichierAssocier) {
        this.fichierAssociers.remove(fichierAssocier);
        fichierAssocier.setProjet(null);
        return this;
    }

    public void setFichierAssociers(Set<FichierAssocier> fichierAssociers) {
        this.fichierAssociers = fichierAssociers;
    }

    public Set<PlanProjet> getPlanProjets() {
        return planProjets;
    }

    public Projet planProjets(Set<PlanProjet> planProjets) {
        this.planProjets = planProjets;
        return this;
    }

    public Projet addPlanProjet(PlanProjet planProjet) {
        this.planProjets.add(planProjet);
        planProjet.setProjet(this);
        return this;
    }

    public Projet removePlanProjet(PlanProjet planProjet) {
        this.planProjets.remove(planProjet);
        planProjet.setProjet(null);
        return this;
    }

    public void setPlanProjets(Set<PlanProjet> planProjets) {
        this.planProjets = planProjets;
    }

    public Set<PlanningExecution> getPlanningExecutions() {
        return planningExecutions;
    }

    public Projet planningExecutions(Set<PlanningExecution> planningExecutions) {
        this.planningExecutions = planningExecutions;
        return this;
    }

    public Projet addPlanningExecution(PlanningExecution planningExecution) {
        this.planningExecutions.add(planningExecution);
        planningExecution.setProjet(this);
        return this;
    }

    public Projet removePlanningExecution(PlanningExecution planningExecution) {
        this.planningExecutions.remove(planningExecution);
        planningExecution.setProjet(null);
        return this;
    }

    public void setPlanningExecutions(Set<PlanningExecution> planningExecutions) {
        this.planningExecutions = planningExecutions;
    }

    public Set<Rendement> getRendements() {
        return rendements;
    }

    public Projet rendements(Set<Rendement> rendements) {
        this.rendements = rendements;
        return this;
    }

    public Projet addRendement(Rendement rendement) {
        this.rendements.add(rendement);
        rendement.setProjet(this);
        return this;
    }

    public Projet removeRendement(Rendement rendement) {
        this.rendements.remove(rendement);
        rendement.setProjet(null);
        return this;
    }

    public void setRendements(Set<Rendement> rendements) {
        this.rendements = rendements;
    }

    public Set<Contribution> getContributions() {
        return contributions;
    }

    public Projet contributions(Set<Contribution> contributions) {
        this.contributions = contributions;
        return this;
    }

    public Projet addContribution(Contribution contribution) {
        this.contributions.add(contribution);
        contribution.getProjets().add(this);
        return this;
    }

    public Projet removeContribution(Contribution contribution) {
        this.contributions.remove(contribution);
        contribution.getProjets().remove(this);
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
        Projet projet = (Projet) o;
        if (projet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Projet{" +
            "id=" + getId() +
            ", nomProjet='" + getNomProjet() + "'" +
            ", descriptionProjet='" + getDescriptionProjet() + "'" +
            ", delaiProjet='" + getDelaiProjet() + "'" +
            ", dateDebut='" + getDateDebut() + "'" +
            ", natureProjet='" + getNatureProjet() + "'" +
            ", isCloture='" + isIsCloture() + "'" +
            ", fondsApportes=" + getFondsApportes() +
            ", fondsALever=" + getFondsALever() +
            "}";
    }
}
