package com.ociojaen.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 500)
    private String descripcion;

    private LocalDateTime fecha;

    @Column(nullable = false, length = 100)
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Usuario organizador; // El usuario con rol EMPRESA que lo organiza

    @Column(length = 500)
    private String imagenUrl;
}