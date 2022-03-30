package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id
@Entity
data class User(@Id var id:Int) {

    @ElementCollection var listaDePreguntas= mutableListOf<Preguntas>()

    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}