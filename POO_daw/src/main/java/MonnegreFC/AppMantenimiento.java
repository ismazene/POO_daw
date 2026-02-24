package MonnegreFC;

import java.util.Scanner;

public class AppMantenimiento {
    static Scanner teclado = new Scanner(System.in);

    static void menu() {
        menu1();
    }

    public static void menu1() {
        System.out.println("=== App de mantenimiento del MONNEGRE FC ===");
        System.out.println("      [1]. Mantenimiento de jugadores");
        System.out.println("             Dentro podremos añadir jugadores, modificar datos y añadir acompañantes (sólo seniors).");
        System.out.println("      [2]. Mantenimiento de entrenadores (añadir-modificar-salir)");
        System.out.println("             Dentro podremos añadir entrenadores y modificar sus datos.");
        System.out.println("      [3]. Mantenimiento de entrenadores (añadir-modificar-salir)");
        System.out.println("            Dentro podremos añadir masajistas y modificar sus datos.");
        System.out.println("      [4]. Consultar equipos");
        System.out.println("            Dentro se deben listar los tipos de equipos del club y elegir uno.");
        System.out.println("      [x]. Salir");


        System.out.println("===================================================");
        System.out.println();

        System.out.println("Selecciona una opcion");
        String opcion = teclado.next().toUpperCase();

        switch (opcion) {
            case "1":
                menu2();
                break;
            case "2":
                System.out.println("Esta opcion no esta disponible de momento");
                break;
            case "3":
                System.out.println("Esta opcion no esta disponible de momento");
                break;
            case "4":
                System.out.println("Esta opcion no esta disponible de momento");
                break;
            case "X":
                System.exit(0);
            default:
                System.out.println("Porfavor selecciona una opcion valida...");
        }
    }

    public static void menu2() {
        System.out.println("=== Mantenimiento de Jugadores ===");
        System.out.println();
        System.out.println("        [1]. Añadir nuevo jugador");
        System.out.println("        [2]. Modificar datos de jugador existente");
        System.out.println("        [3]. Crear acompañantes (solo seniors)");
        System.out.println("        [X]. Volver al menú principal");
        System.out.println();

        System.out.println("===================================================");
        System.out.println();

        System.out.println("Selecciona una opcion");
        String opcionMenu2 = teclado.next().toUpperCase();

        switch (opcionMenu2) {
            case "1":
                menu1Case1();

                break;
            case "2":

                break;
            case "3":

                break;
            case "X":

            default:
                System.out.println("Porfavor selecciona una opcion valida...");
        }
    }

    public static void menu1Case1() {
        System.out.println("=== Mantenimiento de Jugadores. Modificar datos de jugador existente ===");
        System.out.println();
        System.out.println("¿De qué jugador quieres hacer cambios?");
        System.out.println();

        for (Jugador jugador: Jugador.listaJugadores) {
            System.out.println(jugador);
        }


            System.out.println("===================================================");
            System.out.println();

            System.out.println("Selecciona una opcion");
            String opcionMenu1Case1 = teclado.next().toUpperCase();

            switch (opcionMenu1Case1) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "X":

                default:
                    System.out.println("Porfavor selecciona una opcion valida...");
            }

        }
    }