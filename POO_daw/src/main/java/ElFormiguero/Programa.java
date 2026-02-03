package ElFormiguero;

import java.util.ArrayList;
import java.util.Arrays;

public class Programa {

    private String nombre;
    private Cadena cadena;
    private int temporadas;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Invitado> listaInvitados;
    private Empleado director;

    // Constructor
    public Programa(String nombre, Cadena cadena) {

        this.nombre = nombre;
        this.cadena = cadena;
        this.temporadas = 0;

        listaEmpleados = new ArrayList<>();
        listaInvitados = new ArrayList<>();

        /// director (Empleado) – créalo en el mismo constructor y añádelo a la listaEmpleados
        /// Por defecto, se crean con 0 temporadas y no tendremos empleados (excepto el director) ni
        /// invitados hasta que se vayan añadiendo conforme se va contratando o invitando.
        director = new Empleado();
        listaEmpleados.add(director);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public Cadena getCadena() {
        return cadena;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Invitado> getListaInvitados() {
        return listaInvitados;
    }

    public Empleado getDirector() {
        return director;
    }

    // Métodos
    public void insertarEmpleado(Empleado... empleados) {
        listaEmpleados.addAll(Arrays.asList(empleados));
    }

    public void borrarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);
    }

    public void insertarInvitado(Invitado... invitados) {
        listaInvitados.addAll(Arrays.asList(invitados));
    }

    public void borrarInvitado(Invitado invitado) {
        listaInvitados.remove(invitado);
    }

    @Override
    public String toString() {
        return "Programa{" +
                "nombre='" + nombre + '\'' +
                ", cadena=" + cadena +
                ", temporadas=" + temporadas +
                ", director=" + director +
                ", listaEmpleados=" + listaEmpleados +
                ", listaInvitados=" + listaInvitados +
                '}';
    }
}
