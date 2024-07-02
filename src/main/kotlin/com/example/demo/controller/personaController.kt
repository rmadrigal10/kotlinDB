package com.example.demo.controller

import com.example.demo.model.empleado
import com.example.demo.service.api.personaServiceApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class personaController {

    @Autowired
    lateinit var personaServiceApi: personaServiceApi

    @RequestMapping("/all")
    fun getAll() : MutableList<empleado>{
        return personaServiceApi.all
    }

    @RequestMapping("/save")
    fun save(@RequestBody persona: empleado) : ResponseEntity<empleado>{
        val obj = personaServiceApi.save(persona);
        return ResponseEntity<empleado>(obj, HttpStatus.CREATED)
    }

    @RequestMapping("/get/{id}")
    fun getById(@PathVariable("id") id : Long) : ResponseEntity<empleado>{
        val obj = personaServiceApi.get(id);
        return ResponseEntity<empleado>(obj, HttpStatus.OK)
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<empleado>{
        val persona = personaServiceApi.get(id)
        if (persona != null) {
            personaServiceApi.delete(id)
        } else {
            return ResponseEntity<empleado>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<empleado>(persona, HttpStatus.OK)
    }
}