package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.Enrepreneur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  dao for the Enrepreneur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EnrepreneurRepository extends JpaRepository<Enrepreneur, Long> {

    @Query("select e from Enrepreneur e where e.nom like :x or  e.prenom like :x")
    public Page<Enrepreneur> chercher(@Param("x") String mc, Pageable pageable);

}
