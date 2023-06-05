package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.BusesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusesRepository extends JpaRepository<BusesModel, Long> {
    @Query(value = "SELECT * FROM LISTBUSESD", nativeQuery = true)
    List<Object[]>ListBusesD();

}
