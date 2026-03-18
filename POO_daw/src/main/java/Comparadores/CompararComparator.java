package Comparadores;

import java.util.Comparator;

public class CompararComparator implements Comparator<Portatil> {



    @Override
    public int compare(Portatil o1, Portatil o2) {

        int compararRam = o1.getRam().compareTo(o2.getRam());
        if (compararRam != 0){
            return compararRam;
        }

        int compararPeso = o1.getPeso().compareTo(o2.getPeso());
        if (compararPeso != 0){
            return compararPeso;
        }

        return o1.getNombre().compareTo(o2.getNombre());
    }
}
