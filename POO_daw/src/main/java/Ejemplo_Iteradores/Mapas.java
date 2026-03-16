package Ejemplo_Iteradores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Mapas {
    static void main() {
        HashMap<String,Integer> goleadores = new HashMap<>();
        goleadores.put("ANDREA SILVA",6);
        goleadores.put("RONALDO NAZARIO",6);

        Iterator<Map.Entry<String,Integer>> itmapita = goleadores.entrySet().iterator();

        while (itmapita.hasNext()){
            /// Es importante hacer el next para empezar a recorrer el array
            Map.Entry<String,Integer> goleadorGol = itmapita.next();
            System.out.println(goleadorGol.getKey() + " ha marcado " + goleadorGol.getValue() + " goles");
        }
    }
}
