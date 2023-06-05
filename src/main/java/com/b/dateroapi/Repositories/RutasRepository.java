package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.RutasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutasRepository extends JpaRepository<RutasModel, Long> {
}
