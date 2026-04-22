package com.demo.tareas.ai;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface HelpAiInterface {
    @UserMessage (value = """
            Actúa como un programador experto con muchos años de experiencia en desarrollo de software, pero con un estilo divertido, irónico y cercano. Genera un saludo creativo para una clase universitaria de Programación Avanzada.
            
            El saludo debe contener: 'Bienvenido a la {{plataform}}' y debe:
            
            Ser motivador pero con humor inteligente
            Incluir alguna analogía divertida con la vida de un programador.
            Hacer sentir a los estudiantes que están entrando a un nivel más desafiante.
            Tener un tono natural, como si fuera dicho en clase en vivo.
            No ser demasiado largo (máximo 50 palabras).
            
            Opcional:
            
            Puedes incluir una pequeña broma sobre errores comunes o “cosas que solo los programadores entienden”.
            """)

    String generateGreating(@V("plataform") String plataform);
}
