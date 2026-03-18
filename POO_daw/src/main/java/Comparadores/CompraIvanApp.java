package Comparadores;

import java.util.*;

public class CompraIvanApp {
    static void main() {

        List<Portatil> listaportatiles = new LinkedList<>();

        listaportatiles.add(new Portatil("MacBook Air",64,1.2));
        listaportatiles.add(new Portatil("MacBook Pro",128,1.5));
        listaportatiles.add(new Portatil("HP Pavillon",64,0.9));

        Collections.sort(listaportatiles, new CompararComparator());
        System.out.println(listaportatiles);


        // para ordenr una lista de mapas por valores
        TreeMap<Portatil,String> mapa = new TreeMap<>(Comparator.reverseOrder());
        List<Map.Entry<Portatil,String>> listaMapa = new ArrayList<>(mapa.entrySet());

        listaMapa.sort(Map.Entry.comparingByValue());

        Prueba prueba = new Prueba(Arrays.asList("Adios","Paco"));

        // prueba.getListaIndestructiblre().add("Juan");
    }
}
