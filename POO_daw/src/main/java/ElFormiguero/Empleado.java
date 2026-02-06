package ElFormiguero;

public class Empleado {

    private static int contador = 1;

    private String id;
    private String nombre;
    private String cargo;
    private Empleado director;

    /**
     * Crea un empleado con id generado automaticamente.
     *
     * @param nombre Nombre del empleado.
     * @param cargo Cargo del empleado.
     * @param director Director asociado (si aplica).
     */
    public Empleado(String nombre, String cargo, Empleado director) {
        this.id = generarId();
        this.nombre = nombre;
        setCargo(cargo);
        setDirector(director);
    }

    /**
     * Genera un identificador unico del empleado.
     *
     * @return Id con prefijo EP y contador.
     */
    private String generarId() {
        return String.format("EP%03d", contador++);
    }

    /**
     * Establece el cargo si es valido y si no lo es pone "pte"
     *
     * @param cargo Cargo del empleado.
     */
    public void setCargo(String cargo) {
        if (cargo.equalsIgnoreCase("director") || cargo.equalsIgnoreCase("tecnico") || cargo.equalsIgnoreCase("presentador") || cargo.equalsIgnoreCase("colaborador")) {
            this.cargo = cargo.toLowerCase();
        } else {
            this.cargo = "pte";
        }
    }

    /**
     * Si el cargo es director, se deja en null.
     *
     * @param director Director asignado.
     */
    public void setDirector(Empleado director) {
        if (this.cargo.equals("director")) {
            this.director = null;
        } else {
            this.director = director;
        }
    }


    public static int getContador() {
        return contador;
    }
    public static void setContador(int contador) {
        Empleado.contador = contador;
    }
    public String getId() {
        return id;
    }
    public String getNombre() {

        return nombre;
    }
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
    public String getCargo() {

        return cargo;
    }
    public Empleado getDirector() {
        return director;
    }

    @Override
    /**
     * Esto es lo que se muestra por consola
     *
     * @return Cadena con los datos del empleado.
     */
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", director=" + director +
                '}';
    }
}
