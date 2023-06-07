package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.DistritosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistritosRepository extends JpaRepository<DistritosModel, Long> {
    @Query(value = "CALL DISH(:est)", nativeQuery = true)
    List<Object[]>ListDish(@Param("est") boolean est);
}
