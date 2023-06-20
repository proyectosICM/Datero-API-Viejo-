package com.b.dateroapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "RP")
public class RPModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_rp;

    @ManyToOne
    @JoinColumn(name = "ruta_id", referencedColumnName = "id_ruta", nullable = false)
    private RutasModel rutasModel;

    @ManyToOne
    @JoinColumn(name = "par_id", referencedColumnName = "id_par", nullable = false)
    private ParaderosModel paraderosModel;


    private Integer orden_rp;
    private Boolean est_rp;

    public RPModel() {
    }

    public Long getId_rp() {
        return id_rp;
    }

    public void setId_rp(Long id_rp) {
        this.id_rp = id_rp;
    }

    public RutasModel getRutasModel() {
        return rutasModel;
    }

    public void setRutasModel(RutasModel rutasModel) {
        this.rutasModel = rutasModel;
    }

    public ParaderosModel getParaderosModel() {
        return paraderosModel;
    }

    public void setParaderosModel(ParaderosModel paraderosModel) {
        this.paraderosModel = paraderosModel;
    }


    public Integer getOrden_rp() {
        return orden_rp;
    }

    public void setOrden_rp(Integer orden_rp) {
        this.orden_rp = orden_rp;
    }

    public Boolean getEst_rp() {
        return est_rp;
    }

    public void setEst_rp(Boolean est_rp) {
        this.est_rp = est_rp;
    }
}
