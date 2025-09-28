package ejercicio003_lanzamiento_multiple;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // Creación de la carpeta contenedora de los ficheros
        File file = new File("C:\\2º DAM\\Programación de Servicios y Procesos\\2DAM_Programacion_Servicios_Procesos\\src\\ejercicio003_lanzamiento_multiple\\logs");
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("Carpeta creada con éxito.");
        } else {
            System.out.println("La carpeta ya existe.");
        }

        // Declaración de los procesos
        ProcessBuilder pb1 = new ProcessBuilder("C:\\Windows\\System32\\calc.exe");
        ProcessBuilder pb2 = new ProcessBuilder("C:\\Windows\\System32\\notepad.exe");
        ProcessBuilder pb3 = new ProcessBuilder("C:\\Windows\\System32\\cmd.exe", "/c", "start cmd.exe /K echo CMD iniciado");


        // Asignación de salidas
        File file1 = new File(file, "calc_log.txt");
        File file2 = new File(file, "notepad_log.txt");
        File file3 = new File(file, "cmd_log.txt");
        pb1.redirectOutput(file1);
        pb2.redirectOutput(file2);

        // Inicio de los procesos
        try {
            System.out.println("Iniciando la calculadora...");
            crearLog(pb1, file1, "calculadora");
            crearLog(pb2, file2, "bloc de notas");
            crearLog(pb3, file3, "consola de Windows");
            System.out.printf("Se ha generado los ficheros en: %s%n", file.getAbsolutePath());
            System.out.println("Procesos finalizados");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void crearLog(ProcessBuilder pb, File file, String nombre) throws IOException, InterruptedException {
        System.out.printf("Iniciando %s... %n", nombre);

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("Inicio de " + nombre + ": " + LocalDateTime.now() + "\n");
        }

        pb.start().waitFor();

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("Fin de " + nombre + ": " + LocalDateTime.now() + "\n");
        }
    }
}