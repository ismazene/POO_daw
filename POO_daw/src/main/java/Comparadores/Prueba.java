package Comparadores;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prueba {

    private final List<String> listaIndestructiblre = Collections.unmodifiableList(new ArrayList<>());

    public Prueba(List<String> lista) {
        lista.add("Hla");
    }

    public List<String> getListaIndestructiblre(){
            return listaIndestructiblre;
    }
}

