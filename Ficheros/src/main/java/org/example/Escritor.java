package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritor {
    static void main() {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("C:/Users/Ismael/Desktop/Programacion/Ficheros/src/main/resources/aprobados/Nombre2.txt"));

            escritor.write("Hola ");
            escritor.newLine();
            escritor.write("En un lugar de la Mancha de cuyo nombre no quiero acordarme");
            escritor.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void actividad8 (){
        
    }
}
