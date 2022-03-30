package com.example.serverPreguntasPrioridades

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Database {
    @Bean
    fun initDatabase(userRepository: UserRepository,preguntasRepository: PreguntasRepository,valoresRespuestaRepository: ValoresRespuestaRepository,identificadorRepository: IdentificadorRepository):CommandLineRunner{
        return CommandLineRunner{

            val listaIdentificador= listOf(
                Identififador(1,"¿Que entorno conoces más?")
            )


            val listaValoresRespuesta = listOf(

                ValoresRespuesta(1,"IntelliJ",1),
                ValoresRespuesta(1,"Eclipse",2),
                ValoresRespuesta(1,"BlueJ",3),
                ValoresRespuesta(1,"AndroidStudio",4)

            )
            listaValoresRespuesta.forEach{
                valoresRespuestaRepository.save(it)
            }

            val listaDePreguntas = mutableListOf<Preguntas>()

            listaIdentificador.forEach{ identificador->
                listaValoresRespuesta.forEach { valorRespuesta->

                    if (identificador.id==valorRespuesta.idPreg)
                        listaDePreguntas.add(Preguntas(identificador.id,identificador.pregunta,listaValoresRespuesta))

                }

            }

            listaDePreguntas.forEach {
                preguntasRepository.save(it)
            }

        }

    }


}