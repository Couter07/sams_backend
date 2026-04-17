package org.server.sams.repository;

import org.server.sams.model.LocalArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocalAreaRepository extends JpaRepository<LocalArea, Integer> {

    @Query("select local from LocalArea local where local.name = :name")
    Optional<LocalArea> findLocalAreaByName(String name);

}
