package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.ParaderosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParaderosRepository extends JpaRepository<ParaderosModel, Long> {
    @Query(value = "CALL PARH(:est)", nativeQuery = true)
    List<Object[]> ListParaderosH(@Param("est") Boolean est);
}
