package Recuperacion_1.Squash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppSquash {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la secuencia del partido:");
        String entrada = teclado.nextLine().trim().toUpperCase();

        if (!esFormatoValido(entrada)) {
            System.out.println("Formato invalido");
            return;
        }

        ResultadoPartido resultado = procesarPartido(entrada);
        resultado.mostrarResumen();
    }

    public static boolean esFormatoValido(String entrada) {
        if (!entrada.endsWith("F")) {
            return false;
        }

        return !entrada.substring(0, entrada.length() - 1).contains("F");
    }

    public static ResultadoPartido procesarPartido(String entrada) {
        int puntosA = 0;
        int puntosB = 0;
        int setsA = 0;
        int setsB = 0;
        List<String> setsTerminados = new ArrayList<>();

        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);

            switch (c) {
                case 'A':
                    puntosA++;
                    break;
                case 'B':
                    puntosB++;
                    break;
                case 'S':
                    setsTerminados.add(puntosA + "-" + puntosB);
                    if (puntosA > puntosB) {
                        setsA++;
                    } else if (puntosB > puntosA) {
                        setsB++;
                    }
                    puntosA = 0;
                    puntosB = 0;
                    break;
                case 'F':
                    break;
                default:
                    break;
            }
        }

        return new ResultadoPartido(setsA, setsB, puntosA, puntosB, setsTerminados);
    }
}
