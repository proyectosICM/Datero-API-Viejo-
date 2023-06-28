package com.b.dateroapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "RTIEMPO")
public class RTiempoModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_rt;
    private Integer tiempo;
    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "id_bus", nullable = false)
    private BusesModel busesModel;

    @ManyToOne
    @JoinColumn(name = "rp_id", referencedColumnName = "id_rp", nullable = false)
    private RPModel rpModel;

    public RTiempoModel() {
    }

    public Long getId_rt() {
        return id_rt;
    }

    public void setId_rt(Long id_rt) {
        this.id_rt = id_rt;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public BusesModel getBusesModel() {
        return busesModel;
    }

    public void setBusesModel(BusesModel busesModel) {
        this.busesModel = busesModel;
    }

    public RPModel getRpModel() {
        return rpModel;
    }

    public void setRpModel(RPModel rpModel) {
        this.rpModel = rpModel;
    }
}
