package org.example.Biblio;

import java.util.ArrayList;
import java.util.Arrays;

public class Editorial {

    private String nombre;
    private String pais;
    private ArrayList<Libro> listaLibros;

    public Editorial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        listaLibros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void insertarLibro(Libro libro){
        listaLibros.addAll(Arrays.asList(libro));
    }

    public void borrarLibro(Libro libro){
        listaLibros.remove(libro);
    }
}
