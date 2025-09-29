package ejercicio001.lanzamiento_proceso_basico;

import java.io.IOException;

/**
 * Clase principal que lanza un proceso externo utilizando {@link ProcessBuilder} para
 * abrir, en este caso, el bloc de notas.
 *
 * @author Adrián Guerrero
 */
public class Main {

    /**
     * Metodo principal que inicia la ejecución del programa.
     * Lanza el block de notas de Windows como proceso externo y espera a que finalice.
     *
     * @param args Argumentos de línea de comandos.
     */
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