package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.RPModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RPRepository extends JpaRepository<RPModel, Long> {
    @Query(value = "CALL PARADEROXRUTA(:ruta)", nativeQuery = true)
    List<Object[]>ListParaderoXRuta(@Param("ruta") Long  ruta);
}
