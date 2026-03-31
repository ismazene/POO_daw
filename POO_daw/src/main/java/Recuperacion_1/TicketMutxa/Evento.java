package Recuperacion_1.TicketMutxa;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Evento {

    private String nombre;
    private LocalDate fecha;
    private double precio;

    public Evento(String nombre, LocalDate fecha, double precio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento evento)) return false;
        return Objects.equals(nombre, evento.nombre) && Objects.equals(fecha, evento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fecha);
    }
}
