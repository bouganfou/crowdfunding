package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA dao for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
