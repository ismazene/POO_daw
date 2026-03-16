package Ejemplo_Iteradores;

import java.util.*;

public class Ejemplo_ListaIt {

    static void main(String[] args) {

        ArrayList<String> alumnos = new ArrayList<>(Arrays.asList("Juan", "Ismael", "Paula", "Rajoi"));

        ListIterator<String> it = alumnos.listIterator();

        while (it.hasNext()) {

            System.out.println(it.nextIndex());
            String nombre = it.next();
            System.out.println(it.nextIndex());

            if (nombre.equals("Ismael")){
                it.add("Patri");
            }

            System.out.println(nombre);
        }

        while (it.hasPrevious()) {

            System.out.println(it.previousIndex());
            String nombre = it.previous();
            System.out.println(it.previousIndex());

            System.out.println(nombre);
        }
    }
}