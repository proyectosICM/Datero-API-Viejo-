package com.b.dateroapi.Models;

import jakarta.persistence.*;

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
}
