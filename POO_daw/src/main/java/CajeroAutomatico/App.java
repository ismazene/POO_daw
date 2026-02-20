package CajeroAutomatico;

import java.util.Scanner;

public class App {

    static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria(500);

        int opcion;

        do {
            System.out.println("=== CAJERO AUTOMÁTICO ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Ingresar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();

            try {
                switch (opcion) {

                    case 3:
                        System.out.print("Cantidad a ingresar: ");
                        double ingreso = teclado.nextDouble();
                        cuenta.ingresar(ingreso);
                        break;

                    case 2:
                        System.out.print("Cantidad a retirar: ");
                        double retirada = teclado.nextDouble();
                        cuenta.retirar(retirada);
                        break;

                    case 1:
                        System.out.println("Saldo actual: " + cuenta.consultarSaldo() + "€");
                        break;

                    case 4:
                        System.out.println("Gracias por usar el cajero.");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (SaldoInsuficienteException | LimiteDiarioException | DepositoMaximoException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 4);

    }
}