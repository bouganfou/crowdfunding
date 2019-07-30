package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.Contributeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  dao for the Contributeur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContributeurRepository extends JpaRepository<Contributeur, Long> {

    @Query(value = "select distinct contributeur from Contributeur contributeur left join fetch contributeur.contributions",
        countQuery = "select count(distinct contributeur) from Contributeur contributeur")
    Page<Contributeur> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct contributeur from Contributeur contributeur left join fetch contributeur.contributions")
    List<Contributeur> findAllWithEagerRelationships();

    @Query("select contributeur from Contributeur contributeur left join fetch contributeur.contributions where contributeur.id =:id")
    Optional<Contributeur> findOneWithEagerRelationships(@Param("id") Long id);

}
