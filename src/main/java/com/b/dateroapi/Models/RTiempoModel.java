package com.b.dateroapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "RTiempo")
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
    @JoinColumn(name = "ruta_id", referencedColumnName = "id_ruta", nullable = false)
    private RutasModel rutasModel;

    @ManyToOne
    @JoinColumn(name = "paradero_id", referencedColumnName = "id_par", nullable = false)
    private ParaderosModel paraderosModel;

    @ManyToOne
    @JoinColumn(name = "rp_id", referencedColumnName = "id_rp", nullable = false)
    private RPModel rpModel;
}
