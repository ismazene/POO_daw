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
        director = new Empleado("Director por defecto", "director", null);
        listaEmpleados.add(director);

        cadena.insertarPrograma(this);

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

    //Anyadir empleados
    public void insertarEmpleado(String nombre, String cargo) {
        Empleado e = new Empleado(nombre, cargo, director);
        listaEmpleados.add(e);
    }

    //Borrar empleado
    public void borrarInvitado(Invitado invitado) {
        listaInvitados.remove(invitado);
    }

    //Invitados por temporada
    public static void invitadosTemporada(ArrayList<Invitado> lista, int temporada) {
        int contador = 0;
        System.out.println("Invitados de la temporada " + temporada + ":");
        for (Invitado invitado : lista) {

            if (invitado.getTemporada() == temporada) {
                contador++;
                System.out.println(invitado.getNombre() + " - " + invitado.getProfesion());
            }
        }
        System.out.println("Total de invitados: " + contador);
    }

    // Metodo que devuelve cuántas veces ha ido un invitado por su nombre
    public static int vecesInvitado(ArrayList<Invitado> lista, String nombre) {
        int contador = 0;
        for (Invitado invitado : lista) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                contador++;
            }
        }
        return contador;
    }

    // Metodo rastrearInvitado
    public static void rastrearInvitado(ArrayList<Invitado> lista, String nombre) {
        int veces = vecesInvitado(lista, nombre);
        System.out.println(nombre + " ha ido al programa " + veces + " veces.");

        if (veces > 0) {
            System.out.println("Detalles de las visitas:");
            for (Invitado invitado : lista) {
                if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("- Fecha: " + invitado.getFechaVisita() + ", Temporada: " + invitado.getTemporada());
                }
            }
        }
    }

    public static boolean buscarInvitado(ArrayList<Invitado> lista, String nombre) {
        for (Invitado invitado : lista) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(nombre + " ha acudido al programa.");
                return true;
            }
        }
        System.out.println(nombre + " No ha acudido al programa.");
        return false;
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
