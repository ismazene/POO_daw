package Colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ParentesisBalanceados {

    static Scanner in;

    public static boolean casoDePrueba() {
        if (!in.hasNext())
            return false;
        else {

            ArrayList<Character> listaAbiertos = new ArrayList<>(Arrays.asList('(','[','{'));
            ArrayList<Character> listaCerrados = new ArrayList<>(Arrays.asList(')',']','}'));

            Stack<Character> pila = new Stack<>();
            String expresion = in.nextLine();

            for (int i = 0; i < expresion.length(); i++) {
                char c = expresion.charAt(i);
                if (listaAbiertos.contains(c)){pila.push(c);}
                else if (listaCerrados.contains(c)) {
                    if (pila.isEmpty()) {
                        System.out.println("NO");
                        return true;
                    }

                    int pos = listaCerrados.indexOf(c);

                    if (pila.peek() == listaAbiertos.get(pos)) {
                        pila.pop();
                    } else {
                        System.out.println("NO");
                        return true;
                    }
                }
            }

            if (pila.isEmpty()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            return true;
        }
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    }
}