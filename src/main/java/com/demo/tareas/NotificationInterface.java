package com.demo.tareas;

public interface NotificationInterface {
    String tipo();
    void enviar(String destino, byte[] contenido);
}
