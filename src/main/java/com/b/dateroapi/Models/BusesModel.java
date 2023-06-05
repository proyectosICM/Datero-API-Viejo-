package com.b.dateroapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Buses")
public class BusesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_bus;
    private String mod_bus;
    private String placa_bus;
    private Boolean est_bus;

    @ManyToOne
    @JoinColumn(name = "trabajador_id", referencedColumnName = "id_tra", nullable = false)
    private TrabajadoresModel trabajadoresModel;

    @ManyToOne
    @JoinColumn(name = "rp_id", referencedColumnName = "id_rp", nullable = false)
    private RPModel rpModel;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id_emp", nullable = false)
    private EmpresasModel empresasModel;

    @ManyToOne
    @JoinColumn(name = "ruta_id", referencedColumnName = "id_ruta", nullable = false)
    private RutasModel rutasModel;

    @JsonIgnore
    @OneToMany(mappedBy = "busesModel")
    private List<RTiempoModel> tiempo;

    public BusesModel() {
    }

    public Long getId_bus() {
        return id_bus;
    }

    public void setId_bus(Long id_bus) {
        this.id_bus = id_bus;
    }

    public String getMod_bus() {
        return mod_bus;
    }

    public void setMod_bus(String mod_bus) {
        this.mod_bus = mod_bus;
    }

    public String getPlaca_bus() {
        return placa_bus;
    }

    public void setPlaca_bus(String placa_bus) {
        this.placa_bus = placa_bus;
    }

    public Boolean getEst_bus() {
        return est_bus;
    }

    public void setEst_bus(Boolean est_bus) {
        this.est_bus = est_bus;
    }

    public TrabajadoresModel getTrabajadoresModel() {
        return trabajadoresModel;
    }

    public void setTrabajadoresModel(TrabajadoresModel trabajadoresModel) {
        this.trabajadoresModel = trabajadoresModel;
    }

    public RPModel getRpModel() {
        return rpModel;
    }

    public void setRpModel(RPModel rpModel) {
        this.rpModel = rpModel;
    }

    public EmpresasModel getEmpresasModel() {
        return empresasModel;
    }

    public void setEmpresasModel(EmpresasModel empresasModel) {
        this.empresasModel = empresasModel;
    }

    public RutasModel getRutasModel() {
        return rutasModel;
    }

    public void setRutasModel(RutasModel rutasModel) {
        this.rutasModel = rutasModel;
    }

    public List<RTiempoModel> getTiempo() {
        return tiempo;
    }

    public void setTiempo(List<RTiempoModel> tiempo) {
        this.tiempo = tiempo;
    }
}
