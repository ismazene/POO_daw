package org.example;

import java.util.Scanner;

public class PedirParametros {
    static Scanner teclado = new Scanner(System.in);

    static void main() {

        System.out.println("Dame el nombre que quieres que tenga el paciente: ");
        String nombre = teclado.nextLine();

        System.out.println("Y la edad:");
        int edad = teclado.nextInt();

        System.out.println("Cual es el sexo del paciente: ");
        char sexo = teclado.next().charAt(0);

        
    }
}
