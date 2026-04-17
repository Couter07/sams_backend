package org.server.sams.repository;

import org.server.sams.model.Address;
import org.server.sams.model.LocalArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("select max(a.id) from Address a")
    Integer findMaxId();


    @Modifying
    @Query("insert into Address(id, houseNumber, localArea)" +
            "values (:id, :houseNumber, :localArea)")
    void saveAddress(Integer id, String houseNumber, LocalArea localArea);
}
