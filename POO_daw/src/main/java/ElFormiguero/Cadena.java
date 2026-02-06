package ElFormiguero;

import java.util.ArrayList;
import java.util.Arrays;

public class Cadena {
    private String nombre;
    private ArrayList<Programa> listaProgramas;

    /**
     * Crea una cadena con su nombre.
     *
     * @param nombre Nombre de la cadena.
     */
    public Cadena(String nombre) {
        this.nombre = nombre;
        listaProgramas = new ArrayList<>();
    }

    /**
     * Obtiene la lista de programas de la cadena.
     *
     * @return Lista de programas.
     */
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

    /**
     * Inserta programas en la cadena.
     *
     * @param programa
     */
    public void insertarPrograma(Programa... programa){
        listaProgramas.addAll(Arrays.asList(programa));
    }

    /**
     * Elimina un programa de la cadena.
     *
     * @param programa
     */
    public void borrarPrograma(Programa programa){
        listaProgramas.remove(programa);
    }

    @Override
    /**
     * Lo que se muestra por consola
     *
     * @return Cadena con los datos principales.
     */
    public String toString() {
        return "Cadena{" +
                "nombre='" + nombre + '\'' +
                ", listaProgramas=" + listaProgramas +
                '}';
    }
}
