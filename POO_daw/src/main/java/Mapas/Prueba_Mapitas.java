package Mapas;

import java.util.HashMap;
import java.util.Map;

public class Prueba_Mapitas {
    static void main() {
        HashMap<Integer, String> mapa = new HashMap<>();

        mapa.put(1, "Marruecos");
        mapa.put(2, "España");
        mapa.put(3, "Belgica");
        /// Pisamos a Belgica...
        mapa.put(3, "Francia");
        System.out.println(mapa.keySet());
        System.out.println(mapa.values());


        for (Map.Entry<Integer,String> mapita : mapa.entrySet()){
            System.out.println(mapita.getKey() + ": " + mapita.getValue());
        }
    }

}
