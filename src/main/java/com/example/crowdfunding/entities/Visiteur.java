package com.example.crowdfunding.entities;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * ==============================================================
 */

@Entity
@Table(name = "visiteur")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@DiscriminatorValue("V")
public class Visiteur extends Personne {

    private static final long serialVersionUID = 1L;



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Visiteur visiteur = (Visiteur) o;
        if (visiteur.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), visiteur.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Visiteur{" +
            "id=" + getId() +
            "}";
    }
}
