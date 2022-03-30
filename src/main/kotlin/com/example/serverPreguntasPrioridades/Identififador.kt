package com.example.serverPreguntasPrioridades

import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Identififador(@Id var id:Int, var pregunta:String) {
    override fun toString(): String {
        val gson = Gson()

        return gson.toJson(this)

    }
}