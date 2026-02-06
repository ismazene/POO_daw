package ElFormiguero;

public class Empleado {

    private static int contador = 1;

    private String id;
    private String nombre;
    private String cargo;
    private Empleado director;

    // Constructor
    public Empleado(String nombre, String cargo, Empleado director) {
        this.id = generarId();
        this.nombre = nombre;
        setCargo(cargo);
        setDirector(director);
    }

    // Generar ID tipo EP1
    private String generarId() {
        return String.format("EP", contador++);
    }

    // Validar cargo
    public void setCargo(String cargo) {
        if (cargo.equalsIgnoreCase("director") ||
                cargo.equalsIgnoreCase("técnico") ||
                cargo.equalsIgnoreCase("presentador") ||
                cargo.equalsIgnoreCase("colaborador")) {

            this.cargo = cargo.toLowerCase();
        } else {
            this.cargo = "pte";
        }
    }

    // Asignar director
    public void setDirector(Empleado director) {
        if (this.cargo.equals("director")) {
            this.director = null;
        } else {
            this.director = director;
        }
    }

    /// Getter Setter
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
}
