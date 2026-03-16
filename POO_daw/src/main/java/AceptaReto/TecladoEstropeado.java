package AceptaReto;

import java.util.ArrayList;
import java.util.ListIterator;


public class TecladoEstropeado {

    static java.util.Scanner teclado;

    public static boolean casoDePrueba() {
        if (!teclado.hasNext())
            return false;
        else {
            String palabra = teclado.nextLine();

            ArrayList<Character> lista = new ArrayList<>();
            ListIterator<Character> it = lista.listIterator();

            for (Character character : palabra.toCharArray()) {
                switch (character) {
                    case '-':
                        if (it.hasPrevious()){
                            while (it.hasPrevious()) {
                                it.previous();
                            }
                            break;
                        }
                        break;
                    case '+':
                        if (it.hasNext()) {
                            while (it.hasNext()) {
                                it.next();
                            }
                        }
                        break;
                    case '*':
                        if (it.hasNext()) {
                            it.next();
                        }
                        break;
                    case '3':
                        if (it.hasNext()) {
                            it.next();
                            it.remove();
                        }
                        break;
                    default:
                        it.add(character);
                }
            }

            for (Character character1 : lista){
                System.out.print(character1);
            }
            System.out.println();
            // (incluyendo la lectura del caso de prueba)
            return true;
        }
    }

    public static void main(String[] args) {
        teclado = new java.util.Scanner(System.in);
        while (casoDePrueba()) {
        }
    }

}