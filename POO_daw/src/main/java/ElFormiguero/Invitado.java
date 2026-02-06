package ElFormiguero;

import java.time.LocalDate;
import java.util.Scanner;

public class Invitado {

    private String nombre;
    private String profesion;
    private LocalDate fechaVisita;
    private int temporada;

    /**
     * Crea un invitado y pide la fecha
     *
     * @param nombre Nombre del invitado.
     * @param profesion Profesion del invitado.
     * @param temporada Temporada en la que participa
     */
    public Invitado(String nombre, String profesion, int temporada) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.temporada = temporada;
        preguntarFecha();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    /**
     * Pide por consola la fecha de visita y lo valida.
     */
    public void preguntarFecha() {
        Scanner teclado = new Scanner(System.in);
        boolean fechaValida = false;

        while (!fechaValida) {
            try {
                System.out.print("Introduce el año por encima de 2026: ");
                int anio = teclado.nextInt();
                if (anio < 2026) {
                    System.out.println("Año inválido, inténtalo de nuevo.");
                    continue;
                }

                System.out.print("Introduce el mes del 1 al 12: ");
                int mes = teclado.nextInt();
                if (mes < 1 || mes > 12) {
                    System.out.println("Mes inválido, inténtalo de nuevo.");
                    continue;
                }

                System.out.print("Introduce el día: ");
                int dia = teclado.nextInt();

                // Intentamos crear la fecha
                LocalDate fecha = LocalDate.of(anio, mes, dia);
                setFechaVisita(fecha);
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Día inválido, inténtalo de nuevo.");
                teclado.nextLine();
            }
        }
    }


    @Override
    /**
     * Lo que se va a ver en la consola
     *
     * @return Cadena con los datos
     */
    public String toString() {
        return "Invitado{" +
                "nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                ", fechaVisita=" + fechaVisita +
                ", temporada=" + temporada +
                '}';
    }
}
