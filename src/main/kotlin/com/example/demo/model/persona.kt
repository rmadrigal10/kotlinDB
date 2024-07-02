package com.example.demo.model

import jakarta.persistence.*
import java.sql.Timestamp

@Entity(name="empleado")
data class empleado (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column
    val idPlaza: Int,
    @Column
    val idCandidato: Int,
    @Column
    val fechaAltaIMSS: Timestamp,
    //@Column
    //val documentos: ,
    @Column
    val fechaIngreso: Timestamp,
    @Column
    val fechaRegistro: Timestamp,
    @Column
    val fechaFiniquito: Timestamp,
    @Column
    val idEstadoFiniquito: Int,
    @Column
    val montoFiniquito: Float,
    @Column
    val cantidadVacaciones: Int,
    @Column
    val fechaBaja: Timestamp,
    @Column
    val anios: Int,
    @Column
    val activo: Int,
    @Column
    val tarjetaSecundaria: String

) {}