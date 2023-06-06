package com.b.dateroapi.Repositories;

import com.b.dateroapi.Models.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long> {
}
