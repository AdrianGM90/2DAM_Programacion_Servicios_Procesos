# EJERCICIO 3
## Lanzador con múltiples procesos y logging
Haz un programa Java que ejecute un comando externo que acepte una entrada estándar, por ejemplo, el comando "ping" a una dirección IP (por ejemplo "ping 8.8.8.8") o un script sencillo que acepte entrada.

El programa debe:
- Lanzar el proceso con ProcessBuilder
- Enviar manualmente una serie de líneas al proceso por su entrada estándar (usando Process.getOutputStream()).
- Leer en tiempo real la salida estándar del proceso (usando Process.getInputStream()) y mostrar cada línea que reciba en la consola de Java.
- Terminar el proceso una vez enviadas las líneas y recibida la respuesta.