package com.example.demo.controller

import com.example.demo.model.persona
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
    fun getAll() : MutableList<persona>{
        return personaServiceApi.all
    }

    @RequestMapping("/save")
    fun save(@RequestBody persona: persona) : ResponseEntity<persona>{
        var obj = personaServiceApi.save(persona);
        return ResponseEntity<persona>(persona, HttpStatus.OK)
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<persona>{
        val persona = personaServiceApi.get(id)
        if (persona != null) {
            personaServiceApi.delete(id)
        } else {
            return ResponseEntity<persona>(HttpStatus.NO_CONTENT)
        }
        return ResponseEntity<persona>(persona, HttpStatus.OK)
    }
}