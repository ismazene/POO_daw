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
                mantenimientoJugadores();
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

    public static void mantenimientoJugadores() {
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
                mantenimientoJugadoresOpcion1();

                break;
            case "2":
                mantenimientoJugadoresOpcion2();

                break;
            case "3":
                mantenimientoJugadoresOpcion3();

                break;
            case "X":

            default:
                System.out.println("Porfavor selecciona una opcion valida...");
        }
    }

    public static void mantenimientoJugadoresOpcion2() {
        System.out.println("=== Mantenimiento de Jugadores. Modificar datos de jugador existente ===");
        System.out.println();
        System.out.println("¿De qué jugador quieres hacer cambios?");
        System.out.println();

        int contador = 0;

        for (Jugador jugador : Jugador.listaJugadores) {
            System.out.println("[" + contador + ", " + jugador + "]");
            contador++;
        }
        mantenimientoJugadoresSeleccionarJugador();
    }

    public static void mantenimientoJugadoresSeleccionarJugador() {
        System.out.println("===================================================");
        System.out.println();

        System.out.println("Selecciona una opcion");
        int opcionMenu1Case1 = teclado.nextInt();

        System.out.println("=== Mantenimiento de Jugadores. Modificar datos de jugador existente ===");
        System.out.println();
        Jugador jugadorSeleccionado = Jugador.listaJugadores.get(opcionMenu1Case1);
        System.out.println("Modificando jugador: " + jugadorSeleccionado);
        System.out.println();

        System.out.println("Que quieres modificar? [nombre, edad, categoria, dorsal, posicion]");
        System.out.println();
        System.out.println("====================================================");
        System.out.println();
        String opcionModificar = teclado.next().toUpperCase();

        switch (opcionModificar) {
            case "NOMBRE":
                teclado.nextLine();
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = teclado.nextLine();
                jugadorSeleccionado.setNombre(nuevoNombre);
                break;

            case "EDAD":
                System.out.print("Nueva edad: ");
                jugadorSeleccionado.setEdad(teclado.nextInt());
                break;

            case "CATEGORIA":
                System.out.print("Nueva categoría: ");
                String nuevaCategoria = teclado.next().toUpperCase();
                jugadorSeleccionado.setCategoria(Equipos.valueOf(nuevaCategoria));
                break;

            case "DORSAL":
                System.out.print("Nuevo dorsal: ");
                int nuevoDorsal = teclado.nextInt();
                jugadorSeleccionado.setDorsal(nuevoDorsal);
                break;

            case "POSICION":
                System.out.print("Nueva posición: ");
                String nuevaPosicion = teclado.next().toUpperCase();
                jugadorSeleccionado.setPosicion(Posiciones.valueOf(nuevaPosicion));
                break;

            default:
                System.out.println("Tienes que poner una opcion valida");
        }

        System.out.println();
        System.out.println("Jugador actualizado:");
        System.out.println(jugadorSeleccionado);
    }

    public static void mantenimientoJugadoresOpcion1() {
        System.out.println("=== Mantenimiento de Jugadores. Añadir un nuevo jugador ===");
        System.out.println();

        teclado.nextLine();

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Edad: ");
        int edad = teclado.nextInt();

        System.out.print("Categoria: ");
        String categoriaTexto = teclado.next().toUpperCase();
        Equipos categoria = Equipos.valueOf(categoriaTexto);

        System.out.print("Dorsal: ");
        int dorsal = teclado.nextInt();

        System.out.print("Posicion: ");
        String posicionTexto = teclado.next().toUpperCase();
        Posiciones posicion = Posiciones.valueOf(posicionTexto);

        Jugador nuevoJugador = new Jugador(nombre, edad, categoria, dorsal, posicion);

        Jugador.listaJugadores.add(nuevoJugador);

        System.out.println();
        System.out.println("Jugador creado correctamente, estos son los que hay ahora...");
        System.out.println();
        for (Jugador jugador : Jugador.listaJugadores) {
            System.out.println(jugador);
        }
    }

    public static void mantenimientoJugadoresOpcion3() {
        System.out.println("=== Crear acompañante (solo seniors) ===");

        // Solo enseño los jugadores senior, da la casualidad de que solo tengo seniors, no es el mismo que el de arriba porque es solo
        // seniors
        int contador = 0;
        for (Jugador jugador : Jugador.listaJugadores) {
            if (jugador.getCategoria() == Equipos.SENIOR) {
                System.out.println("[" + contador + ", " + jugador + "]");
            }
            contador++;
        }

        System.out.println();
        System.out.print("Selecciona el jugador para añadir acompañante ");
        int indice = teclado.nextInt();
        teclado.nextLine();

        Jugador jugadorSeleccionado = Jugador.listaJugadores.get(indice);

        if (jugadorSeleccionado.getCategoria() != Equipos.SENIOR) {
            System.err.println("Este jugador no es SENIOR, no se puede añadir acompañante");
            return;
        }

        System.out.print("Nombre del acompañante: ");
        String nombre = teclado.nextLine();

        System.out.print("Edad del acompañante: ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Parentesco: ");
        String parentesco = teclado.nextLine();

        // Creamos el acompañante y lo añadimos a la lista
        Acompanyante acompanyante = new Acompanyante(nombre, edad, jugadorSeleccionado, parentesco);
        Acompanyante.listaAcompanyantes.add(acompanyante);

        System.out.println("Acompañante añadido correctamente a " + jugadorSeleccionado.getNombre());

//        for (Acompanyante acompanyante : Acompanyante.listaAcompanyantes) {
//            System.out.println(acompanyante);
//        }
    }
}