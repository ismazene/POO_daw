package Mapas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio3TemperaturaCiudades {

    static HashMap<String,Double> mapa = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);

    static void main() {
        System.out.println("*** REGISTRO DE TEMPERATURAS ***");


        while (true){

            System.out.println("Elige una opcion [insertar, actualizar, consultar, ver todas, salir]: ");
            String opcion = teclado.nextLine().toLowerCase();


            switch(opcion){

                case "insertar":
                    insertar();
                    break;
                case "actualizar":
                    actualiar();
                    break;
                case "consultar":
                    consultar();
                    break;
                case "ver todas":
                    verTodas();
                    break;
                case "salir":
                    return;
                default:
                    System.out.println("La opcion no existe elige otra");
            }
            for (Map.Entry<String,Double> mapita : mapa.entrySet()){
            }
        }

    }

    public static void insertar (){

        System.out.println("Introduce los nuevos datos (cidudad - temperatura): ");
        String datos[] = teclado.nextLine().split("/");

        mapa.put(datos[0],Double.valueOf(datos[1]));



    }
    public static void actualiar(){
        System.out.println("Introduce la ciudad a actualizar");
        String ciudad = teclado.nextLine();

        if (mapa.containsKey(ciudad)){
            System.out.println("Introduce la nueva temperatura");
            Double temp = teclado.nextDouble();
            mapa.put(ciudad,temp);
        }else {
            System.out.println("La ciudad no existe");
        }
    }
    public static void consultar(){
        System.out.println("Que ciudad quieres consultar:");
        String ciudad = teclado.nextLine();

        if (mapa.containsKey(ciudad)){
            System.out.println("La temperatura en la ciudad " +  ciudad + " es " + mapa.get(ciudad));
        }else {
            System.out.println("Esa ciudad no existe");
        }
    }
    public static void verTodas(){
        for (Map.Entry<String,Double> mapita : mapa.entrySet()){
            System.out.println(mapita.getKey() + " --> " + mapita.getValue());

        }
    }
}
