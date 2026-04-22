package com.demo.tareas.notification;

public interface NotificationInterface {
    String tipo();
    void enviar(String destino, byte[] contenido);
}
