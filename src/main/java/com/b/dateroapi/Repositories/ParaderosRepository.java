package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.ParaderosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParaderosRepository extends JpaRepository<ParaderosModel, Long> {
}
