package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.RutasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutasRepository extends JpaRepository<RutasModel, Long> {
    @Query(value = "CALL RUTASXEMPT(:emp)", nativeQuery = true)
    List<Object[]>ListRutasXEmpT(@Param("emp") Long emp);

    @Query(value = "CALL RUTASXEMPH(:emp)", nativeQuery = true)
    List<Object[]>ListRutasXEmpH(@Param("emp") Long emp);

    @Query(value = "CALL RUTASXEMPD(:emp)", nativeQuery = true)
    List<Object[]>ListRutasXEmpD(@Param("emp") Long emp);
}
