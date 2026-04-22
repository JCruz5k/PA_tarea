package com.demo.tareas.controllers;
import com.demo.tareas.ai.HelpAiInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String prataform;
    private final HelpAiInterface aiService;

    public HelloController(@Value("${spring.application.name}") String prataform, HelpAiInterface aiService) {
        this.prataform = prataform;
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String hello() {
        return this.aiService.generateGreating(prataform);
    }
}
