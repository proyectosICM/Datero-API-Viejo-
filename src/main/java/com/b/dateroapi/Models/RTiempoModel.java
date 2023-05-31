package com.b.dateroapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "RTiempo")
public class RTiempoModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_rt;

    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "id_bus", nullable = false)
    private BusesModel busesModel;

}
