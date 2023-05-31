package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.RPModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPRepository extends JpaRepository<RPModel, Long> {
}
