package Recuperacion_1;

import java.util.Random;
import java.util.Scanner;

public class Practica1_T3_BatallaSamurai {
    static Random random = new Random();
    static Scanner teclado = new Scanner(System.in);
    static int POTENCIA_MAXIMA = 30;
    static int NUM_SAMURAIS = 7;

    static void main() {
        int aleatorioNumSamurai = random.nextInt(NUM_SAMURAIS) + 1;

        // EQUIPO 1
        System.out.println("Equipo 1");
        int[] equipo1 = new int[7];
        int suma = 0;

        while (suma != POTENCIA_MAXIMA) {
            System.out.println("Introduce potencia de los samurais: ");
            String potencias = teclado.nextLine();
            String[] numeros = potencias.split(" ");

            if (numeros.length != NUM_SAMURAIS) {
                System.err.println("ERROR. Debes introducir " + NUM_SAMURAIS + " números.");
                continue;
            }

            suma = 0;
            for (int i = 0; i < NUM_SAMURAIS; i++) {
                equipo1[i] = Integer.parseInt(numeros[i]);
                suma += equipo1[i];
            }

            if (suma != POTENCIA_MAXIMA) {
                System.err.println("ERROR. La potencia total no suma 30.");
            } else {
                System.out.println("Equipo 1 completado.");
            }
        }

        // EQUIPO 2
        System.out.println("Equipo 2");
        int[] equipo2 = new int[NUM_SAMURAIS];
        int sumaEquipo2 = 0;

        while (sumaEquipo2 != POTENCIA_MAXIMA) {
            System.out.println("Introduce potencia de los samurais: ");
            String potencias2 = teclado.nextLine();
            String[] numeros2 = potencias2.split(" ");

            if (numeros2.length != NUM_SAMURAIS) {
                System.err.println("ERROR. Debes introducir " + NUM_SAMURAIS + " números.");
                continue;
            }

            sumaEquipo2 = 0;
            for (int i = 0; i < NUM_SAMURAIS; i++) {
                equipo2[i] = Integer.parseInt(numeros2[i]);
                sumaEquipo2 += equipo2[i];
            }

            if (sumaEquipo2 != POTENCIA_MAXIMA) {
                System.err.println("ERROR. La potencia total no suma 30.");
            } else {
                System.out.println("Equipo 2 completado.");
            }
        }

        // BATALLA
        System.out.println("La batalla inicia con el Samurai " + aleatorioNumSamurai);

        int bajasEquipo1 = 0;
        int bajasEquipo2 = 0;

        /// NUM_SAMURAIS = 7
        for (int i = 0; i < NUM_SAMURAIS; i++) {
            int pelea = (aleatorioNumSamurai - 1 + i) % NUM_SAMURAIS;

            System.out.print("Samurai " + (pelea + 1) + ". ");

            if (equipo1[pelea] > equipo2[pelea]) {
                System.out.println("Gana Equipo 1. " + equipo1[pelea] + " vs " + equipo2[pelea]);
                equipo2[pelea] = 0;
                bajasEquipo2++;
            } else if (equipo2[pelea] > equipo1[pelea]) {
                System.out.println("Gana Equipo 2. " + equipo1[pelea] + " vs " + equipo2[pelea]);
                equipo1[pelea] = 0;
                bajasEquipo1++;
            } else {
                System.out.println("Empate. " + equipo1[pelea] + " vs " + equipo2[pelea]);
                equipo1[pelea] = 0;
                equipo2[pelea] = 0;
                bajasEquipo1++;
                bajasEquipo2++;
            }
        }

        if (bajasEquipo1 > NUM_SAMURAIS / 2) {
            System.out.println("¡Equipo 2 GANA! Equipo 1 ha tenido " + bajasEquipo1 + " bajas.");
        } else if (bajasEquipo2 > NUM_SAMURAIS / 2) {
            System.out.println("¡Equipo 1 GANA! Equipo 2 ha tenido " + bajasEquipo2 + " bajas.");
        } else {
            System.out.println("Empate final. Bajas Equipo 1: " + bajasEquipo1 + ", Bajas Equipo 2: " + bajasEquipo2);
        }
    }
}