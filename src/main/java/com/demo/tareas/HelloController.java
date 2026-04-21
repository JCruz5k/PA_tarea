package com.demo.tareas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelpAiService aiService;

    public HelloController(HelpAiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String hello() {
        return this.aiService.generateGreating();
    }
}
