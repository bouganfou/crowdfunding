package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.Visiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  dao for the Visiteur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {

}
