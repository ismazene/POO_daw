package chalet;

public class Electrodomestico {
    private String nombre;
    private String consumo;
    public Electrodomestico(String nombre, String consumo) {
        this.nombre = nombre;
        this.consumo = consumo;
    }
    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarElectrodomestico(){


    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "nombre='" + nombre + '\'' +
                ", consumo='" + consumo + '\'' +
                '}';
    }




}
