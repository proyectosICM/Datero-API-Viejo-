package com.b.dateroapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "rpModel")
    private List<BusesModel> buses;

    private Integer orden_rp;
    private Boolean est_rp;


}
