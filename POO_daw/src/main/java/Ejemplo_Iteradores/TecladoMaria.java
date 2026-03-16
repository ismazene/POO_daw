package Ejemplo_Iteradores;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class TecladoMaria {
    static Scanner teclado = new Scanner(System.in);

    static void main() {

        String palabra = teclado.nextLine();

        ArrayList<Character> lista = new ArrayList<>();
        ListIterator<Character> it = lista.listIterator();

        for (Character caracter : palabra.toCharArray()){

            switch (caracter){
                case '<' :

                if (it.hasPrevious()){
                    it.previous();
                }
                break;

                case '>' :

                    if (it.hasNext()){
                        it.next();
                    }
                    break;

                case '#' :

                    if (it.hasPrevious()){
                        it.previous();
                        it.remove();
                    }

                    break;
                default:
                    it.add(caracter);

            }

        }
        for (Character caracter : lista){
            System.out.print(caracter);
        }

    }
}
