package ejercicio002.lanzamiento_proceso_argumentos;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("java", "-version");

        File file = new File("version_output.txt");

        pb.redirectOutput(file);
        pb.redirectErrorStream(true);

        try {
            System.out.println("Inicio del proceso");
            pb.start().waitFor();
            System.out.printf("El fichero se ha guardado en: %s%n", file.getAbsolutePath());
            System.out.println("Proceso terminado");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}