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

}
