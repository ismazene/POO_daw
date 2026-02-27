package MonnegreFC;

/**
 * Clase base abstracta para cualquier persona del club
 */
public abstract class MonnegreFC implements FuncionesIntegrantes{
    private String nombre;
    private int edad;

    /**
     * Crea una base de cualquier persona del club.
     *
     * @param nombre nombre del integrante
     * @param edad edad del integrante
     */
    public MonnegreFC(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
