package com.b.dateroapi.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_usu;
    private String user_usu;
    private String pass_usu;
    private Boolean est_usu;
}
