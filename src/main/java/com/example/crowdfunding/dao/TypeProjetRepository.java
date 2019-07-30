package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.TypeProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  dao for the TypeProjet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeProjetRepository extends JpaRepository<TypeProjet, Long> {

}
