package com.b.dateroapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TRABAJADORES")
public class TrabajadoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_tra;
    private String nom_tra;
    private String ape_tra;
    private String dni_tra;
    private Boolean est_tra;

    private String user_tra;
    private String pass_tra;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id_rol", nullable = false)
    private RolesModel rolesModel;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_emp", nullable = false)
    private  EmpresasModel empresasModel;


    public TrabajadoresModel() {
    }

    public Long getId_tra() {
        return id_tra;
    }

    public void setId_tra(Long id_tra) {
        this.id_tra = id_tra;
    }

    public String getNom_tra() {
        return nom_tra;
    }

    public void setNom_tra(String nom_tra) {
        this.nom_tra = nom_tra;
    }

    public String getApe_tra() {
        return ape_tra;
    }

    public void setApe_tra(String ape_tra) {
        this.ape_tra = ape_tra;
    }

    public String getDni_tra() {
        return dni_tra;
    }

    public void setDni_tra(String dni_tra) {
        this.dni_tra = dni_tra;
    }

    public Boolean getEst_tra() {
        return est_tra;
    }

    public void setEst_tra(Boolean est_tra) {
        this.est_tra = est_tra;
    }

    public String getUser_tra() {
        return user_tra;
    }

    public void setUser_tra(String user_tra) {
        this.user_tra = user_tra;
    }

    public String getPass_tra() {
        return pass_tra;
    }

    public void setPass_tra(String pass_tra) {
        this.pass_tra = pass_tra;
    }

    public RolesModel getRolesModel() {
        return rolesModel;
    }

    public void setRolesModel(RolesModel rolesModel) {
        this.rolesModel = rolesModel;
    }

    public EmpresasModel getEmpresasModel() {
        return empresasModel;
    }

    public void setEmpresasModel(EmpresasModel empresasModel) {
        this.empresasModel = empresasModel;
    }
}
