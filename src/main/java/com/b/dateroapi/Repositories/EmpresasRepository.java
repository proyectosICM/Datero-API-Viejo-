package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasModel, Long> {
    /*
    List<EmpresasModel> findByEst_emp(Boolean est_emp);

    @Query(value = "SELECT * FROM EMPRESAS_HABILITADAS", nativeQuery = true)
    List<Object[]> EmpHabilitadas();

    @Query(value = "SELECT * FROM EMPRESAS_DESHABILITADAS", nativeQuery = true)
    List<Object[]> EmpDeHabilitadas();

    List<EmpresasModel> findByEst_emp(Boolean est_emp);

        @Query(value = "CALL DETALLESVALORES(:camion)", nativeQuery = true)
    List<Object[]> getDetallesValores(@Param("camion") int camion);
    */

    @Query(value = "CALL EMPEST(:est)", nativeQuery = true)
    List<Object[]> getEmpest(@Param("est") boolean est);

    @Query(value = "SELECT * FROM EMPRESAS_HABILITADAS", nativeQuery = true)
    List<Object[]> EmpHabilitadas();

    @Query(value = "SELECT * FROM EMPRESAS_DESHABILITADAS", nativeQuery = true)
    List<Object[]> EmpDeHabilitadas();

}