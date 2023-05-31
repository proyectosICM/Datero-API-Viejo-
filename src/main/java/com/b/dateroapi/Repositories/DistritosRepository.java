package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.DistritosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritosRepository extends JpaRepository<DistritosModel, Long> {
}
