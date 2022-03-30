package com.example.serverPreguntasPrioridades

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Database {
    @Bean
    fun initDatabase(userRepository: UserRepository,preguntasRepository: PreguntasRepository):CommandLineRunner{
        return CommandLineRunner{
            val listaDePreguntas= listOf<Preguntas>(
                Preguntas("¿Que entorno conoces más?",
                    ValoresRespuesta("IntelliJ",1),
                    ValoresRespuesta("Eclipse",2),
                    ValoresRespuesta("BlueJ",3),
                    ValoresRespuesta("AndroidStudio",4)
                )


            )

            listaDePreguntas.forEach {
                preguntasRepository.save(it)
            }
        }
    }
}