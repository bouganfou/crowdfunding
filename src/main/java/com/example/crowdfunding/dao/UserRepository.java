package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.Users;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA dao for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    String USERS_BY_LOGIN_CACHE = "usersByUsername";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<Users> findOneByActivationKey(String activationKey);

    //List<Users> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<Users> findOneByResetKey(String resetKey);

    Optional<Users> findOneByEmailIgnoreCase(String email);

    Optional<Users> findOneByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    Optional<Users> findOneWithAuthoritiesById(Long id);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<Users> findOneWithAuthoritiesByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<Users> findOneWithAuthoritiesByEmail(String email);

    Page<Users> findAllByUsernameNot(Pageable pageable, String username);
}
