package MonnegreFC;

import java.util.Scanner;


public class AppMantenimiento {
    static Scanner teclado = new Scanner(System.in);

    /**
     * Es el main, no tiene mas
     */
    static void main() {
        AppMonnegreFC.main();
        menu1();
    }

    /**
     * Este es el menu principal, es el primero que se muestra y de aqui se llama a todos los
     * demás metodos, se pide una opcion y se hace un switch case para saber cual ha elegido, solo trabajamos con la primera como tal
     */
    public static void menu1() {
        System.out.println("=== App de mantenimiento del MONNEGRE FC ===");
        System.out.println();
        System.out.println("      [1]. Mantenimiento de jugadores");
        System.out.println("             Dentro podremos añadir jugadores, modificar datos y añadir acompañantes (sólo seniors).");
        System.out.println("      [2]. Mantenimiento de entrenadores (añadir-modificar-salir)");
        System.out.println("             Dentro podremos añadir entrenadores y modificar sus datos.");
        System.out.println("      [3]. Mantenimiento de entrenadores (añadir-modificar-salir)");
        System.out.println("            Dentro podremos añadir masajistas y modificar sus datos.");
        System.out.println("      [4]. Consultar equipos");
        System.out.println("            Dentro se deben listar los tipos de equipos del club y elegir uno.");
        System.out.println("      [x]. Salir");
        System.out.println();
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
                System.out.println();
                menu1();
                break;
            case "3":
                System.out.println("Esta opcion no esta disponible de momento");
                System.out.println();
                menu1();
                break;
            case "4":
                consultarEquipos();
                break;
            case "X":
                System.exit(0);
            default:
                System.out.println("Porfavor selecciona una opcion valida...");
                System.out.println();
                menu1();
        }
    }

    /**
     * Como he dicho0 antes aqui es donde se hace el submenu para el mantenimiento de los jugadores
     * funciona como el primer menu, pides una opcion y dentro del switch case haces algo con esa opcion, en mi caso llamo siempre
     * a un tercer menu
     *
     * Nunca dejo que termine el menu
     */
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
                menu1();
                System.out.println();
            default:
                System.out.println("Porfavor selecciona una opcion valida...");
                System.out.println();
                mantenimientoJugadores();
        }
    }

    /**
     * Si el usuario selecciona la segunda opcion del menu anterior aparece esta parte de codigo en la que el usuario
     * elige a quien hacerle los cambios
     *
     * Solo pregunta por el jugador
     */
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

    /**
     * Esta es un submenu de mantenimientoJugadoresOpcion2 aquí es donde se hace la logica para cambiar algún parametro del jugador
     * Como ya he mostrado antes la lista de jugadores ahora espero una opcion (int) dependiendo de la opcion hace un caso del switch o otro
     *
     * Nombre: Pide un nuevo nombre y lo modifica con un set
     * Edad: Pide un número y lo modifica con un set
     * Categoria: Este es diferente porque las categorias son un enum, entonces primero convertimos a enum con el valueOf
     * Dorsal: Pide un número (dorsal) y lo modifica con un set
     * Posicion: Igual que categoria son de tipo enum entonces tenemos que hacer un valueOf
     */
    public static void mantenimientoJugadoresSeleccionarJugador() {
        System.out.println("===================================================");
        System.out.println();

        System.out.println("Selecciona una opcion");
        int opcionMenu1Case1 = teclado.nextInt();

        if (opcionMenu1Case1 > Jugador.listaJugadores.size() - 1){
            System.err.println("No existe un jugador en esa posicion");
            System.out.println();
            mantenimientoJugadoresOpcion2();
        }

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
                System.out.println();
                mantenimientoJugadores();

            case "EDAD":
                System.out.print("Nueva edad: ");
                int nuevaEdad = teclado.nextInt();
                jugadorSeleccionado.setEdad(nuevaEdad);
                System.out.println();
                mantenimientoJugadores();

            case "CATEGORIA":
                System.out.print("Nueva categoría: ");
                String nuevaCategoria = teclado.next().toUpperCase();
                jugadorSeleccionado.setCategoria(Equipos.valueOf(nuevaCategoria));
                System.out.println();
                mantenimientoJugadores();

            case "DORSAL":
                System.out.print("Nuevo dorsal: ");
                int nuevoDorsal = teclado.nextInt();
                jugadorSeleccionado.setDorsal(nuevoDorsal);
                System.out.println();
                mantenimientoJugadores();

            case "POSICION":
                System.out.print("Nueva posición: ");
                String nuevaPosicion = teclado.next().toUpperCase();
                jugadorSeleccionado.setPosicion(Posiciones.valueOf(nuevaPosicion));
                System.out.println();
                mantenimientoJugadores();

            default:
                System.out.println("Tienes que poner una opcion valida");
                System.out.println();
                mantenimientoJugadoresSeleccionarJugador();
        }

        System.out.println();
        System.out.println("Jugador actualizado:");
        System.out.println(jugadorSeleccionado);
    }

    /**
     * Aqui hacemos lo de crear a un nuevo jugador y lo guardamos en la lista que ya tenemos
     * lo mismo que arriba a los tipo enum un valueOf y lo demas solo con el set, despues solo mostramos los jugadores
     * que tenemos y ya
     */
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
        System.out.println();
        mantenimientoJugadores();
    }

    /**
     * Este metodo es casi una copia de mantenimientoJugadoresOpcion1 solo que en este caso con acompañantes
     */
    public static void mantenimientoJugadoresOpcion3() {
        System.out.println("=== Crear acompañante (solo seniors) ===");

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

        Acompanyante acompanyante = new Acompanyante(nombre, edad, jugadorSeleccionado, parentesco);
        Acompanyante.listaAcompanyantes.add(acompanyante);

        System.out.println("Acompañante añadido correctamente a " + jugadorSeleccionado.getNombre());

    }

    /**
     * Muestra las categorias, y tu al seleccionar una te enseña el listado de juagdores que hay en ella
     */
    public static void consultarEquipos(){
        for (int i = 0; i < Equipos.values().length; i++) {
            System.out.println(Equipos.values()[i]);
        }


        System.out.println();
        System.out.println("Selecciona una opcion");
        Equipos opcionEquipo = Equipos.valueOf(teclado.next().toUpperCase());
        System.out.println();

        for (Jugador jugador: Jugador.listaJugadores) {
            if (jugador.getCategoria().equals(opcionEquipo)){
                System.out.println(jugador);
            }
        }
        System.out.println();
        mantenimientoJugadores();
    }
}
