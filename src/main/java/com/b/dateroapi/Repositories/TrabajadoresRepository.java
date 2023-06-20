package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrabajadoresRepository extends JpaRepository<TrabajadoresModel, Long> {
/*
    @Query("select u from TrabajadoresModel u where u.user_tra = ?1")
    Optional<TrabajadoresModel> getName(String user_tra);
*/
    Optional<TrabajadoresModel> findByUsername(String username);

    @Query(value = "CALL TRABAJADORXEMPT(:emp)", nativeQuery = true)
    List<Object[]>ListTrabjadorxEmpT(@Param("emp") Long emp);

    @Query(value = "CALL TRABAJADORXEMPH(:est, :emp)", nativeQuery = true)
    List<Object[]>ListTrabjadorxEmpH(@Param("est") Boolean est, @Param("emp") Long emp );

    @Query(value = "CALL TRABAJADORXEMPR(:emp, :est, :rol)", nativeQuery = true)
    List<Object[]>ListTrabjadorxEmpR(@Param("emp") Long emp, @Param("est") Boolean est, @Param("rol") Integer rol);
}
