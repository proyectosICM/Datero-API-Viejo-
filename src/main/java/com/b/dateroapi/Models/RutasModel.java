package com.b.dateroapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "RUTAS")
public class RutasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ruta;
    private String nom_ruta;
    private Boolean est_ruta;
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id_emp", nullable = false)
    private EmpresasModel empresasModel;

    @JsonIgnore
    @OneToMany(mappedBy = "rutasModel")
    private List<RPModel> rp;

    @JsonIgnore
    @OneToMany(mappedBy = "rutasModel")
    private List<BusesModel> buses;

    public RutasModel() {
    }

    public Long getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(Long id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNom_ruta() {
        return nom_ruta;
    }

    public void setNom_ruta(String nom_ruta) {
        this.nom_ruta = nom_ruta;
    }

    public Boolean getEst_ruta() {
        return est_ruta;
    }

    public void setEst_ruta(Boolean est_ruta) {
        this.est_ruta = est_ruta;
    }

    public EmpresasModel getEmpresasModel() {
        return empresasModel;
    }

    public void setEmpresasModel(EmpresasModel empresasModel) {
        this.empresasModel = empresasModel;
    }

    public List<RPModel> getRp() {
        return rp;
    }

    public void setRp(List<RPModel> rp) {
        this.rp = rp;
    }

    public List<BusesModel> getBuses() {
        return buses;
    }

    public void setBuses(List<BusesModel> buses) {
        this.buses = buses;
    }
}
