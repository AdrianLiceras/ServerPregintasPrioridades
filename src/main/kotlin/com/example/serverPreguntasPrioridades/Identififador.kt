package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.Id


data class Identififador(var id:Int, var pregunta:String) {
    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}