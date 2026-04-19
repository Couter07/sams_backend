package org.server.sams.repository;

import org.server.sams.enums.Gender;
import org.server.sams.model.Address;
import org.server.sams.model.Country;
import org.server.sams.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("select max(u.id) from User u")
    Integer findMaxId();


    @Query("select u from User u")
    Optional<User> findUserById(Integer id);

    @Query("select u from User u where u.email = :email")
    Optional<User> findUserByEmail(String email);
}
