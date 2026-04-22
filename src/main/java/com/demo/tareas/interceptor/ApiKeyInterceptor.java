package com.demo.tareas.interceptor;

import com.demo.tareas.exception.ApiKeyInvalidaException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ApiKeyInterceptor.class);
    private static final String HEADER_API_KEY = "X-API-KEY";

    @Value("${app.api-key}")
    private String apiKeyValida;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        long inicio = System.currentTimeMillis();
        request.setAttribute("inicio", inicio);

        log.info("ENTRADA: {} {} desde {}",
                request.getMethod(),
                request.getRequestURI(),
                request.getRemoteAddr());

        String apiKey = request.getHeader(HEADER_API_KEY);

        if (apiKey == null || apiKey.isBlank()) {
            log.warn("API Key ausente en {}", request.getRequestURI());
            throw new ApiKeyInvalidaException("Header X-API-KEY es obligatorio");
        }

        if (!apiKeyValida.equals(apiKey)) {
            log.warn("API Key inválida recibida: {}", apiKey);
            throw new ApiKeyInvalidaException("API Key inválida");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) {
        log.info("POST-HANDLE: status {} para {}",
                response.getStatus(), request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        long inicio = (Long) request.getAttribute("inicio");
        long duracion = System.currentTimeMillis() - inicio;

        log.info("SALIDA: {} {} - status {} - {}ms {}",
                request.getMethod(),
                request.getRequestURI(),
                response.getStatus(),
                duracion,
                ex != null ? "con excepción: " + ex.getMessage() : "OK");
    }
}