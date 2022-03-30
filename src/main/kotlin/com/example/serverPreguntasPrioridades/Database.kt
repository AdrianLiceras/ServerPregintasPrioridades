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
                Identififador(1,"Ordene estas cuatro metodologías de aprendizaje por orden de preferencia asignando la puntuación de 4 a la más preferida hasta 1 a la menos preferida."),
                Identififador(2,"Ordene estas cuatro metodologías de aprendizaje según perciba que se han priorizado durante el curso asignando 4 a la de mayor presencia hasta 1 a la de menor presencia.")
            )

            listaIdentificador.forEach {
                identificadorRepository.save(it)
            }
            println("--------------------------------------------------------")
            identificadorRepository.findAll().forEach{
                println(it.toString())
            }
            val listaValoresRespuesta = listOf(

                ValoresRespuesta(1,"Aprendizaje basado en proyectos",1),
                ValoresRespuesta(1,"Aprendizaje significativo",2),
                ValoresRespuesta(1,"Educación STEM",3),
                ValoresRespuesta(1,"Cultura maker",4),
                /*ValoresRespuesta(2,"Aprendizaje basado en proyectos",1),
                ValoresRespuesta(2,"Aprendizaje significativo",2),
                ValoresRespuesta(2,"Educación STEM",3),
                ValoresRespuesta(2,"Cultura maker",4)*/

            )
            listaValoresRespuesta.forEach{
                valoresRespuestaRepository.save(it)
            }
            println("--------------------------------------------------------")
            valoresRespuestaRepository.findAll().forEach {
                println(it.toString())
            }

            val listaDePreguntas = mutableListOf<Preguntas>()

            identificadorRepository.findAll().forEach{ identificador->
                valoresRespuestaRepository.findAll().forEach { valorRespuesta->

                    if (identificador.id==valorRespuesta.idPreg)
                        listaDePreguntas.add(Preguntas(identificador.id,identificador.pregunta,listaValoresRespuesta))

                }

            }

            listaDePreguntas.forEach {
                preguntasRepository.save(it)
            }
            println("----------------------------------------------")

        }

    }


}