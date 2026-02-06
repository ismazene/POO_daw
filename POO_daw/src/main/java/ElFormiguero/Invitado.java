package ElFormiguero;

import imserso.Abuelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Invitado {

    private String nombre;
    private String profesion;
    private String fechaVisita;
    private int temporada;

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

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    //Metodos

    // Preguntar la fecha
    public void preguntarFecha() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la fecha por favor con este formato (dd-mm-aaaa):");
        String fecha = teclado.nextLine();
        setFechaVisita(fecha);
    }




    @Override
    public String toString() {
        return "Invitado{" + "nombre='" + nombre + '\'' + ", profesion='" + profesion + '\'' + ", fechaVisita='" + fechaVisita + '\'' + ", temporada=" + temporada + '}';
    }
}