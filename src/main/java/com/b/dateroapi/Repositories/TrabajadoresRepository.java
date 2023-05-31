package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadoresRepository extends JpaRepository<TrabajadoresModel, Long> {
}
