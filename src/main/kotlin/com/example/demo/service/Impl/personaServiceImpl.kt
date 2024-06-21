package com.example.demo.service.Impl

import com.example.demo.commons.genericServiceImpl
import com.example.demo.model.persona
import com.example.demo.repository.personaRepository
import com.example.demo.service.api.personaServiceApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class personaServiceImpl : genericServiceImpl<persona, Long>(), personaServiceApi {

    @Autowired
    lateinit var personaRepository: personaRepository
    override fun getDao(): CrudRepository<persona, Long> {
        return personaRepository
    }
}