package Recuperacion_1.Parking;

import java.util.Random;

public class Ticket implements Acciones {
    private String matricula;
    private Integer minutos;
    private Estado estado;
    static Random random = new Random();

    public Ticket(String matricula, Integer minutos, Estado estado) {
        this.matricula = matricula;
        this.minutos = minutos;
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public void generar() {
        String letras = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";
        String nuevaMatricula = "";

        System.out.println("Leyendo la matricula...");

        for (int i = 0; i < 4; i++) {
            nuevaMatricula += numeros.charAt(random.nextInt(numeros.length()));
        }

        for (int i = 0; i < 3; i++) {
            nuevaMatricula += letras.charAt(random.nextInt(letras.length()));
        }

        setMatricula(nuevaMatricula);
        setEstado(Estado.GENERADO);

        System.out.println("Matricula generada: " + getMatricula());
        System.out.println("Estado: " + getEstado());
    }

    @Override
    public void recoger() {
        System.out.println("Ticket generado.");
        System.out.println("Recoja su ticket.");
        setEstado(Estado.RECOGIDO);
        System.out.println("Bienvenido al parking.");
    }

    @Override
    public void pagar() {
        System.out.println("Procesando pago...");
        setEstado(Estado.PAGADO);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "matricula='" + matricula + '\'' +
                ", minutos=" + minutos +
                ", estado=" + estado +
                '}';
    }
}
