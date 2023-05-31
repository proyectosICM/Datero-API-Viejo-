package com.b.dateroapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Rutas")
public class RutasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_ruta;
    private String nom_ruta;
    private Boolean est_ruta;

    @JsonIgnore
    @OneToMany(mappedBy = "rutasModel")
    private List<RPModel> rp;


}
