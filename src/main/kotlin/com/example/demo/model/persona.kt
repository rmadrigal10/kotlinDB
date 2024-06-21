package com.example.demo.model

import jakarta.persistence.*

@Entity(name="persona")
data class persona (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column
    val nombre: String,
    @Column
    val apellido: String,
    @Column
    val direccion: String,
    @Column
    val telefono: String

) {}