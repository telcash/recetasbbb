package com.recetabbb.repository;

import com.recetabbb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author carlossalazar
 **/
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
