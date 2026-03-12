package JuegoDiccionario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiccionarioApp {
    static Scanner teclado = new Scanner(System.in);
    static HashMap<String,String> diccionario = new HashMap<>();

    static void main() {
        diccionario = Diccionario.crearDiccionario();
        nuevoPar();
        traduce();

    }

    public static void nuevoPar(){
        System.out.println("Dame una palabra en castellano y otra en ingles (castellano - ingles) ");
        String nuevoPar[] = teclado.nextLine().split("-");

        if (diccionario.containsKey(nuevoPar[0])){
            System.out.println("Lo siento pero este par ya existe");
        }else {
            diccionario.put(nuevoPar[0],(nuevoPar[1]));

            for (Map.Entry<String,String> mapita : diccionario.entrySet()){
                System.out.println("Palabra añadida con exito");
                System.out.println(mapita.getKey() + " --> " + mapita.getValue());

            }
        }



    }
    public static void traduce(){
        System.out.println("¿Qué palabra quieres traducir?");
        String palabra = teclado.next();

        if (diccionario.containsKey(palabra)) {
            String traduccion = diccionario.get(palabra);
            System.out.println("La traducción es: " + traduccion);
        } else {
            System.out.println("Esa palabra no está en el diccionario");

        }
    }
    public static void palabraAleatoria(){}
    public static void pimeraLetraTraduccion(){}


}
