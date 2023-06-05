package com.b.dateroapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Distritos")
public class DistritosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_dis;
    private String nom_dis;
    private Boolean est_dis;

    @JsonIgnore
    @OneToMany(mappedBy = "distritosModel")
    private List<ParaderosModel> paraderos;

    public DistritosModel() {
    }

    public Long getId_dis() {
        return id_dis;
    }

    public void setId_dis(Long id_dis) {
        this.id_dis = id_dis;
    }

    public String getNom_dis() {
        return nom_dis;
    }

    public void setNom_dis(String nom_dis) {
        this.nom_dis = nom_dis;
    }

    public Boolean getEst_dis() {
        return est_dis;
    }

    public void setEst_dis(Boolean est_dis) {
        this.est_dis = est_dis;
    }

    public List<ParaderosModel> getParaderos() {
        return paraderos;
    }

    public void setParaderos(List<ParaderosModel> paraderos) {
        this.paraderos = paraderos;
    }
}
