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
}
