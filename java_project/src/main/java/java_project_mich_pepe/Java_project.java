package java_project_mich_pepe;

import javax.swing.*;

public class Java_project {

    public static void main(String[] args) {
        // Inicia el servidor en un hilo separado
        new Thread(() -> {
            // Crea y muestra la ventana del servidor
            SwingUtilities.invokeLater(() -> {
                chat_mich serverChat = new chat_mich();
                serverChat.setVisible(true);
            });

            // Ejecuta el servidor
            chat_mich.main(new String[0]);
        }).start();

        // Espera un momento para asegurarse de que el servidor esté en ejecución
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Inicia el cliente en otro hilo separado
        new Thread(() -> {
            // Crea y muestra la ventana del cliente
            SwingUtilities.invokeLater(() -> {
                chat_pepe clientChat = new chat_pepe();
                clientChat.setVisible(true);
            });

            // Ejecuta el cliente
            chat_pepe.main(new String[0]);
        }).start();
    }
}
