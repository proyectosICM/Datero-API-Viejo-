package com.b.dateroapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class RolesModel2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_rol;
    private String nom_rol;
    private Boolean est_rol;

    public RolesModel2() {
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }

    public Boolean getEst_rol() {
        return est_rol;
    }

    public void setEst_rol(Boolean est_rol) {
        this.est_rol = est_rol;
    }

}
