package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
@Embeddable
data class ValoresRespuesta(var idPreg:Int,  var opcion:String , var valor:Int) {


    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}