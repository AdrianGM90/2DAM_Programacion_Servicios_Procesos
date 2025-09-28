package ejercicio001.lanzamiento_proceso_basico;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ProcessBuilder processBuilder = new ProcessBuilder("C:\\Windows\\System32\\notepad.exe");

        try {
            System.out.println("Abriendo bloc de notas...");
            processBuilder.start().waitFor();
            System.out.println("Proceso finalizado");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}