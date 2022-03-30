package com.example.serverPreguntasPrioridades

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PreguntasController(private val userRepository: UserRepository, private val preguntasRepository: PreguntasRepository) {
    @GetMapping("inicio/{id}")///{opcion1}/{opcion2}/{opcion3}/{opcion4}
    fun obtenerUsuario(@PathVariable id:Int/*,@PathVariable opcion1:Int,@PathVariable opcion2:Int,@PathVariable opcion3:Int,@PathVariable opcion4:Int*/ ):String{

        val user=User(id)

        preguntasRepository.findAll().forEach {
            user.listaDePreguntas.add(it)
        }

        return user.toString()
        
    }

}