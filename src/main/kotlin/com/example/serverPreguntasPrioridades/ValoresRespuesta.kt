package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
@Entity
data class ValoresRespuesta(var idPreg:Int, @Id var opcion:String , var valor:Int ) {

    /*@GeneratedValue
    @Id
    var id:Int=0*/
    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}