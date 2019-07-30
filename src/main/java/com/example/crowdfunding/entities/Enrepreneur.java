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
@Table(name = "enrepreneur")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@DiscriminatorValue("E")
public class Enrepreneur  extends Personne {

    private static final long serialVersionUID = 1L;



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Enrepreneur enrepreneur = (Enrepreneur) o;
        if (enrepreneur.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), enrepreneur.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Enrepreneur{" +
            "id=" + getId() +
            "}";
    }
}
