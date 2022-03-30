package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.GeneratedValue
import javax.persistence.Id

class ValoresRespuesta(@Id var opcion:String , var valor:Int) {

    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}