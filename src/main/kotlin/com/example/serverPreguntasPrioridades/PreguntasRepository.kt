package com.example.serverPreguntasPrioridades

import org.springframework.data.jpa.repository.JpaRepository

interface PreguntasRepository : JpaRepository<Preguntas, Identififador>