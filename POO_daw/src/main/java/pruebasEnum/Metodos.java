package pruebasEnum;

import java.util.Scanner;

public class Metodos {
    static void main() {

        Scanner teclado = new Scanner(System.in);

        Metodo opcion = Metodo.PAYPAL;

        System.out.println(opcion);

        /// Devuelve un vector
        for (Metodo metodo : Metodo.values()){
            System.out.println(metodo);
        }

        /// Pedir por teclado y
        System.out.println("Elige un metodo de pago: ");
        Metodo op = Metodo.valueOf(teclado.next().toUpperCase());

        System.out.println("Metodo elegido: " + op);

    }
}
