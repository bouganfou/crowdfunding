package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.EntrepreneurProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  dao for the EntrepreneurProjet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntrepreneurProjetRepository extends JpaRepository<EntrepreneurProjet, Long> {

}
