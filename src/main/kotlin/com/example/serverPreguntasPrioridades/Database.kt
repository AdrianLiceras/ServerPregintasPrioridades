package com.example.serverPreguntasPrioridades

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Database {
    @Bean
    fun initDatabase(userRepository: UserRepository,preguntasRepository: PreguntasRepository):CommandLineRunner{
        return CommandLineRunner{

            val listaIdentificador= listOf(
                Identififador(1,"Ordene estas cuatro metodologías de aprendizaje por orden de preferencia asignando la puntuación de 4 a la más preferida hasta 1 a la menos preferida."),
                Identififador(2,"Ordene estas cuatro metodologías de aprendizaje según perciba que se han priorizado durante el curso asignando 4 a la de mayor presencia hasta 1 a la de menor presencia.")
            )

            println("--------------------------------------------------------")
           listaIdentificador.forEach{
                println(it.toString())
            }
            val listaValoresRespuesta1 = listOf(

                ValoresRespuesta(1,"Aprendizaje basado en proyectos",1),
                ValoresRespuesta(1,"Aprendizaje significativo",2),
                ValoresRespuesta(1,"Educación STEM",3),
                ValoresRespuesta(1,"Cultura maker",4)

            )
            val listaValoresRespuesta2 = listOf(
                ValoresRespuesta(2,"Aprendizaje basado en proyectos",1),
                ValoresRespuesta(2,"Aprendizaje significativo",2),
                ValoresRespuesta(2,"Educación STEM",3),
                ValoresRespuesta(2,"Cultura maker",4)
            )

            println("--------------------------------------------------------")
            listaValoresRespuesta1.forEach {
                println(it.toString())
            }

            val listaDePreguntas = mutableListOf<Preguntas>()
            var flag1=false
            var flag2=false

            listaIdentificador.forEach { identificador ->

                if (!flag1)
                    if (identificador.id==1){
                        flag1=true
                        listaDePreguntas.add(Preguntas(identificador.id, identificador.pregunta,listaValoresRespuesta1))
                    }
                if(!flag2)
                    if (identificador.id==2){
                        flag2=true
                        listaDePreguntas.add(Preguntas(identificador.id, identificador.pregunta,listaValoresRespuesta2))
                    }
            }


            listaDePreguntas.forEach {
                preguntasRepository.save(it)
            }

            println("----------------------------------------------")

        }

    }


}