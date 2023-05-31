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

}
