package Mapas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejer2 {

    static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una palabra: ");
        String palabra = teclado.nextLine().toUpperCase();

        HashMap<Character, Integer> mapa = new HashMap<>();

        for (char letra : palabra.toCharArray()) {

            if (mapa.containsKey(letra)) {
                mapa.put(letra, mapa.get(letra) + 1);
            } else {
                mapa.put(letra, 1);
            }
        }

        for (Map.Entry<Character, Integer> mapita : mapa.entrySet()) {
            System.out.println(mapita.getKey() + ": " + mapita.getValue());
        }
    }
}