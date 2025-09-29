package ejercicio002.lanzamiento_proceso_argumentos;

import java.io.File;
import java.io.IOException;

/**
 * Clase principal que ejecuta un proceso externo con argumentos
 * utilizando {@link ProcessBuilder}.
 * En este caso, se lanza en comando {@code java -version} y se redirige su
 * salida a un fichero.
 * <p>
 * La salida estándar y de error se redirigen al fichero {@code version_output.txt}
 *
 * @author Adrián Guerrero
 */
public class Main {

    /**
     * Metodo principal que inicia la ejecución del programa.
     * Ejecuta el comando {@code java -version} y guarda la salida en un archivo de texto.
     *
     * @param args Argumentos de línea de comandos.
     */
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