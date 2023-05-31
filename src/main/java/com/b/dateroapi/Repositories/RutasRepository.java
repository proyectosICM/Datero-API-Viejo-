package com.b.dateroapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutasRepository extends JpaRepository<RutasRepository, Long> {
}
