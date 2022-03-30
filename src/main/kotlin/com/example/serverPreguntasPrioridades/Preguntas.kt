package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Preguntas(@Id var id:Int , var pregunta:String, @ElementCollection var listaOpciones: List<ValoresRespuesta> ) {



    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}