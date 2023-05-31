package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.BusesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusesRepository extends JpaRepository<BusesModel, Long> {
}
