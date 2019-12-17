
package Pruebas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class crearTxt {
     public static void main(String[] args) {
            try {
            String prueba="XML", prueba2="prueba";
            String ruta = "/home/genaro/Documentos/filename.txt";
            String contenido = "Contenido de ejemplo "+prueba+" de "+prueba2;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}