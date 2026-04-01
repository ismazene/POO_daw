package Recuperacion_1.Piscina;

import java.time.LocalDate;

public class Invitado extends Banista {
    private LocalDate fechaVisita;

    public Invitado(int numero, String nombre, int edad, TipoUsuario tipoUsuario) {
        super(numero, nombre, edad, tipoUsuario);
        this.fechaVisita = LocalDate.now();
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    @Override
    public void pagar() {
        System.out.println("Pago de invitado: 4 euros");
    }

    @Override
    public String toString() {
        return "Invitado{" +
                "numero=" + getNumero() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", fechaVisita=" + fechaVisita +
                '}';
    }
}
