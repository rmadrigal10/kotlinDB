package com.example.demo.repository

import com.example.demo.model.empleado
import org.springframework.data.repository.CrudRepository

interface personaRepository : CrudRepository<empleado, Long> {
}