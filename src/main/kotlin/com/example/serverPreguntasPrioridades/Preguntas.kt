package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Preguntas(@Id var pregunta:String,var opcion1:ValoresRespuesta,var opcion2: ValoresRespuesta, var opcion3: ValoresRespuesta,opcion4: ValoresRespuesta) {
    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}