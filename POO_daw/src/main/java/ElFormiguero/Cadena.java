package ElFormiguero;

import java.util.ArrayList;
import java.util.Arrays;

public class Cadena {
    private String nombre;
    private ArrayList<Programa> listaProgramas;

    /// Constructor
    public Cadena(String nombre) {
        this.nombre = nombre;
        listaProgramas = new ArrayList<>();

    }

    /// Getter Setter
    public ArrayList<Programa> getListaProgramas() {
        return listaProgramas;
    }

    public void setListaProgramas(ArrayList<Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /// Metodos

    public void insertarPrograma(Programa... Programa){
        listaProgramas.addAll(Arrays.asList(Programa));
    }

    public void borrarPrograma(Programa Programa){
        listaProgramas.remove(Programa);
    }






    /// ToString
    @Override
    public String toString() {
        return "Cadena{" +
                "nombre='" + nombre + '\'' +
                ", listaProgramas=" + listaProgramas +
                '}';
    }
}
