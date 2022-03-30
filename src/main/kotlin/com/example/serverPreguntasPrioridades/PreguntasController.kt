package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PreguntasController(private val userRepository: UserRepository, private val preguntasRepository: PreguntasRepository) {
    @GetMapping("inicio/{id}")
    fun obtenerUsuario(@PathVariable id:Int):String{

        val user=User(id)
        var preg=""
        preguntasRepository.findAll().forEach {
            user.listaDePreguntas.add(it)
        }
        userRepository.save(user)



        return preg

    }

}