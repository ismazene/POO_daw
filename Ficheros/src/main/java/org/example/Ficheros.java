package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros {
    static Scanner teclado = new Scanner(System.in);
    static void main() {

//        File archivo = new File("C:/Users/Ismael/Desktop/Programacion/Ficheros/src/main/resources/aprobados.txt");
//        try {
//            if (archivo.createNewFile()){
//                System.out.printf("Archivo creado");
//            } else {
//                System.out.printf("No se ha creado el archivo");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.printf(archivo.getName());
//        if (archivo.exists()){
//            archivo.delete();
//        }
//
        File carpeta = new File("C:/Users/Ismael/Desktop/Programacion/Ficheros/src/main/resources/aprobados");
//        if (carpeta.mkdir()){
//            System.out.printf("Estupendo carpeta creada");
//        }else {
//            System.out.printf("Muy mal TODO MAL");
//        }
//        actividad4();

        String nombre_fichero [] = carpeta.list();
        for (String nombrecito : nombre_fichero){
            System.out.printf(nombrecito);
        }

        File ficheros[] = carpeta.listFiles();
        for (File ficherito : ficheros){
            System.out.printf(ficherito.getName() + " con tamaño " + ficherito.length());
        }
    }

    public static void actividad4 (){
        System.out.printf("Cuantos archivos de estos quieres perrroooo");
        int numero = teclado.nextInt();
        System.out.printf("Y en que carpeta lo quieres bicho");
        String donde = teclado.next();

        int contador = 0;

        for (int i = 0; i < numero; i++) {
            System.out.printf("Nombre " + contador + ". txt");

            File archivo = new File(donde + "/Nombre" + contador);
        try {
            if (archivo.createNewFile()){
                System.out.printf("Archivo creado");
            } else {
                System.out.printf("No se ha creado el archivo");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            contador++;

        }
    }
}
