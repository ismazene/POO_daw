package chalet;

public class Habitacion {
    private String nombre;
    private Double metros;

    public Habitacion(String nombre, Double metros) {
        this.nombre = nombre;
        this.metros = metros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMetros() {
        return metros;
    }

    public void setMetros(Double metros) {
        this.metros = metros;
    }
}
