package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long> {
    @Query(value = "CALL ROLESXH(:est)", nativeQuery = true)
    List<Object[]>ListRolesH(@Param("est") Boolean est);
}
