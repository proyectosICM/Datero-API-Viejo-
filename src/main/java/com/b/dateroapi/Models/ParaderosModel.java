package com.b.dateroapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Paraderos")
public class ParaderosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_par;
    private String nom_par;
    private Boolean est_par;
    @JsonIgnore
    @OneToMany(mappedBy = "paraderosModel")
    private List<RPModel> rp;

    @ManyToOne
    @JoinColumn(name = "dis_id", referencedColumnName = "id_dis", nullable = false)
    private DistritosModel distritosModel;

    public ParaderosModel() {
    }

    public Long getId_par() {
        return id_par;
    }

    public void setId_par(Long id_par) {
        this.id_par = id_par;
    }

    public String getNom_par() {
        return nom_par;
    }

    public void setNom_par(String nom_par) {
        this.nom_par = nom_par;
    }

    public Boolean getEst_par() {
        return est_par;
    }

    public void setEst_par(Boolean est_par) {
        this.est_par = est_par;
    }

    public List<RPModel> getRp() {
        return rp;
    }

    public void setRp(List<RPModel> rp) {
        this.rp = rp;
    }

    public DistritosModel getDistritosModel() {
        return distritosModel;
    }

    public void setDistritosModel(DistritosModel distritosModel) {
        this.distritosModel = distritosModel;
    }
}
