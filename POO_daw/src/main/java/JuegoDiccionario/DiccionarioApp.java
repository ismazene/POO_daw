package JuegoDiccionario;

import java.util.*;

public class DiccionarioApp {
    static Scanner teclado = new Scanner(System.in);
    static HashMap<String, String> diccionario = new HashMap<>();

    static void main() {
        diccionario = Diccionario.crearDiccionario();

        System.out.println("=== Bienvenido al juego del diccionario ===");
        System.out.println("[1] - Nuevo par");
        System.out.println("[2] - Traducir palabra");
        System.out.println("[3] - Palabra Aleatoria");
        System.out.println("[4] - Primera Letra de la Traduccion");
        System.out.println("[5] - Comenzar Juego");
        System.out.println("[X] - Salir");
        String opcion = teclado.nextLine();

        switch (opcion) {
            case "1":
                nuevoPar();
                break;
            case "2":
                traduce();
                break;
            case "3":
                System.out.println("Palabra aleatoria: " + palabraAleatoria(diccionario));
                break;
            case "4":
                primeraLetraTraduccion();
                break;
            case "5":
                comenzarJuego();
                break;
            case "X":
                System.out.println("Saliendo del programa...");
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Método para añadir un nuevo par al diccionario
    public static void nuevoPar() {
        System.out.println("Dame una palabra en castellano y otra en ingles (castellano - ingles) ");
        String nuevoPar[] = teclado.nextLine().split("-");

        if (diccionario.containsKey(nuevoPar[0])) {
            System.out.println("Lo siento pero este par ya existe");
        } else {
            diccionario.put(nuevoPar[0], nuevoPar[1]);
            System.out.println("Palabra añadida con éxito");
            System.out.println(nuevoPar[0] + " --> " + nuevoPar[1]);
        }
    }

    // Método para traducir
    public static void traduce() {
        System.out.println("¿Qué palabra quieres traducir?");
        String palabra = teclado.next();

        if (diccionario.containsKey(palabra)) {
            String traduccion = diccionario.get(palabra);
            System.out.println("La traducción es: " + traduccion);
        } else {
            System.out.println("Esa palabra no está en el diccionario");
        }
    }

    // Método que devuelve una palabra aleatoria (para test)
    public static String palabraAleatoria(HashMap<String, String> diccionario) {
        ArrayList<String> palabras = new ArrayList<>(diccionario.keySet());
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size()));
    }

    // Método que muestra la primera letra de la traducción
    public static void primeraLetraTraduccion() {
        System.out.println("Dame una palabra en español");
        String palabra = teclado.next();

        if (!diccionario.containsKey(palabra)) {
            System.out.println("La palabra: " + palabra + " no existe en la lista");
        } else {
            String traduccion = diccionario.get(palabra).toUpperCase();
            char primeraLetra = traduccion.charAt(0);
            System.out.println("La primera letra de la traducción es: " + primeraLetra + " ...");
        }
    }

    // Método para iniciar el juego de traducción
    public static void comenzarJuego() {
        Random random = new Random();
        ArrayList<String> palabras = new ArrayList<>(diccionario.keySet());

        int aciertos = 0;
        int errores = 0;

        System.out.println("=== COMIENZA EL JUEGO ===");
        System.out.println("Escribe 'fin' para terminar el juego.");

        while (true) {
            int indice = random.nextInt(palabras.size());
            String palabra = palabras.get(indice);

            String traduccion = diccionario.get(palabra);
            char primeraLetra = traduccion.toUpperCase().charAt(0);
            System.out.println(palabra + ": " + primeraLetra + " ...");

            System.out.print("Indique la respuesta: ");
            String respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("fin")) {
                break;
            }

            if (respuesta.equalsIgnoreCase(traduccion)) {
                System.out.println("¡CORRECTO!");
                aciertos++;
            } else {
                System.out.println("¡NO! La respuesta correcta es " + traduccion + "\n");
                errores++;
            }
        }

        int total = aciertos + errores;
        double porcentaje = 0;
        if (total > 0) {
            porcentaje = aciertos * 100.0 / total;
        }

        System.out.println("FIN DEL PROGRAMA");
        System.out.println("Total preguntas: " + total);
        System.out.println("Total aciertos: " + aciertos);
        System.out.println("Total errores: " + errores);
        System.out.println("Aciertos: " + (int) porcentaje + "%");
    }
}