package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  dao for the Contribution entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Long> {

}
