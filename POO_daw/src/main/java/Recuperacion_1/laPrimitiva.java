package Recuperacion_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class laPrimitiva {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Introduce tu boleto (ej: 1-2-3-4-5-6/7):");
        String entrada = teclado.nextLine();

        if (!entrada.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d")) {
            System.out.println("Formato incorrecto");
            return;
        }

        String[] partes = entrada.split("[-/]");
        int[] usuario = new int[6];

        for (int i = 0; i < 6; i++) {
            usuario[i] = Integer.parseInt(partes[i]);

            if (usuario[i] < 1 || usuario[i] > 49) {
                System.out.println("Numero fuera de rango");
                return;
            }

            for (int j = 0; j < i; j++) {
                if (usuario[i] == usuario[j]) {
                    System.out.println("No se pueden repetir numeros en el boleto");
                    return;
                }
            }
        }

        int reintegroUsuario = Integer.parseInt(partes[6]);
        int[] numeros = new int[6];

        for (int i = 0; i < 6; i++) {
            numeros[i] = random.nextInt(49) + 1;
            boolean duplicado = false;

            for (int j = 0; j < i; j++) {
                if (numeros[i] == numeros[j]) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) {
                i--;
            }
        }

        Arrays.sort(numeros);

        int complementario;
        boolean repetido;
        do {
            complementario = random.nextInt(49) + 1;
            repetido = false;

            for (int i = 0; i < 6; i++) {
                if (numeros[i] == complementario) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);

        int reintegro = random.nextInt(10);

        System.out.println("Sorteo: " + Arrays.toString(numeros));
        System.out.println("Complementario: " + complementario);
        System.out.println("Reintegro: " + reintegro);

        int aciertos = 0;
        for (int i = 0; i < 6; i++) {
            if (Arrays.binarySearch(numeros, usuario[i]) >= 0) {
                aciertos++;
            }
        }

        boolean reintegroBien = reintegro == reintegroUsuario;
        boolean complementarioBien = false;

        for (int i = 0; i < 6; i++) {
            if (usuario[i] == complementario) {
                complementarioBien = true;
                break;
            }
        }

        if (aciertos == 6 && reintegroBien) {
            System.out.println("Categoria especial");
        } else if (aciertos == 6) {
            System.out.println("1a categoria");
        } else if (aciertos == 5 && complementarioBien) {
            System.out.println("2a categoria");
        } else if (aciertos == 5) {
            System.out.println("3a categoria");
        } else if (aciertos == 4) {
            System.out.println("4a categoria");
        } else if (aciertos == 3) {
            System.out.println("5a categoria");
        } else if (reintegroBien) {
            System.out.println("Reintegro");
        } else {
            System.out.println("No premiado");
        }
    }
}
