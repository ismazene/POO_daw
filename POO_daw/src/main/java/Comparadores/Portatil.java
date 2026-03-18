package Comparadores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter

@ToString
public class Portatil implements Comparable<Portatil> {
    private String nombre;
    private Integer ram;
    private Double peso;

    public Portatil(String nombre, int ram, double peso) {
        this.nombre = nombre;
        this.ram = ram;
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Portatil portatil = (Portatil) o;
        return ram == portatil.ram && Double.compare(peso, portatil.peso) == 0 && Objects.equals(nombre, portatil.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, peso, nombre);
    }


    @Override
    public int compareTo(Portatil o) {
        int comparar = ram.compareTo(o.getRam());
        if (comparar !=0){
            return comparar;
        }

        comparar = peso.compareTo(o.getPeso());
            if (comparar != 0){
                return comparar;
            }
        return nombre.compareTo(o.getNombre());
    }


}
