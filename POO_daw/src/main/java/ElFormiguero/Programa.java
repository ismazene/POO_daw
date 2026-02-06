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

    /**
     * Crea un programa y registra el director en la plantilla.
     * Tambien inserta el programa en la cadena indicada.
     *
     * @param nombre Nombre del programa.
     * @param cadena Cadena televisiva propietaria.
     * @param nombreDirector Nombre del director del programa.
     */
    public Programa(String nombre, Cadena cadena, String nombreDirector) {
        this.nombre = nombre;
        this.cadena = cadena;
        this.temporadas = 0;
        listaEmpleados = new ArrayList<>();
        listaInvitados = new ArrayList<>();
        director = new Empleado(nombreDirector, "director", null);
        listaEmpleados.add(director);
        cadena.insertarPrograma(this);
    }


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

    /**
     * Inserta empleados en el programa
     *
     * @param empleados Empleados a insertar.
     */
    public void insertarEmpleado(Empleado... empleados) {
        listaEmpleados.addAll(Arrays.asList(empleados));
    }

    /**
     * Borrar un empleado del programa
     *
     * @param empleado Empleado a eliminar.
     */
    public void borrarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);
    }

    /**
     * Crea un invitado y lo mete en la lista del programa.
     *
     * @param nombre Nombre del invitado.
     * @param profesion Profesion del invitado.
     * @param temporada Temporada en la que participo.
     */
    public void insertarInvitado(String nombre, String profesion, int temporada) {
        Invitado invitado = new Invitado(nombre, profesion, temporada);
        listaInvitados.add(invitado);
    }

    /**
     * Elimina un invitado de la lista.
     *
     * @param invitado Invitado a eliminar.
     */
    public void borrarInvitado(Invitado invitado) {
        listaInvitados.remove(invitado);
    }

    /**
     * Muestra los invitados de una temporada concreta
     *
     * @param temporada
     */
    public void invitadosTemporada(int temporada) {
        int contador = 0;
        System.out.println("Invitados de la temporada " + temporada + ":");
        for (Invitado invitado : listaInvitados) {
            if (invitado.getTemporada() == temporada) {
                contador++;
                System.out.println(invitado.getNombre() + " - " + invitado.getProfesion());
            }
        }
        System.out.println("Total de invitados: " + contador);
    }

    /**
     * Calcula cuantas veces ha sido invitada una persona.
     *
     * @param nombre Nombre del invitado a buscar.
     * @return Numero de veces que aparece el invitado
     */
    public int vecesInvitado(String nombre) {
        int contador = 0;
        for (Invitado invitado : listaInvitados) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Rastrea a un invitado donde a estado y cuando
     *
     * @param nombre Nombre del invitado a rastrear.
     */
    public void rastrearInvitado(String nombre) {
        int veces = vecesInvitado(nombre);
        System.out.println(nombre + " ha ido al programa " + veces + " veces.");
        if (veces > 0) {
            System.out.println("Detalles de las visitas:");
            for (Invitado invitado : listaInvitados) {
                if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("- Fecha: " + invitado.getFechaVisita() + ", Temporada: " + invitado.getTemporada());
                }
            }
        }
    }

    /**
     * Busca un invitado por nombre
     *
     * @param nombre Nombre del invitado a buscar.
     * @return true si existe y false si no
     */
    public boolean buscarInvitado(String nombre) {
        for (Invitado invitado : listaInvitados) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(nombre + " ha acudido al programa.");
                return true;
            }
        }
        System.out.println(nombre + " no ha acudido al programa.");
        return false;
    }

    /// Me queda la clase invitadoAntes y la verdad es que no he sabido hacerlo

    /**
     * Lo que se ve por consola
     *
     * @return Cadena con los datos principales del programa.
     */
    @Override
    public String toString() {
        return "Programa{" +
                "nombre='" + nombre + '\'' +
                ", cadena=" + cadena.getNombre() +
                ", temporadas=" + temporadas +
                ", listaEmpleados=" + listaEmpleados +
                ", listaInvitados=" + listaInvitados +
                ", director=" + director +
                '}';
    }
}
