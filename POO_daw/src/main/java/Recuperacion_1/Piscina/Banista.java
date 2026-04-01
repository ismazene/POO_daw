package Recuperacion_1.Piscina;

public abstract class Banista {
    private int numero;
    private String nombre;
    private int edad;
    private TipoUsuario tipoUsuario;

    public Banista(int numero, String nombre, int edad, TipoUsuario tipoUsuario) {
        this.numero = numero;
        this.nombre = nombre;
        setEdad(edad);
        this.tipoUsuario = tipoUsuario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public abstract void pagar();

    @Override
    public String toString() {
        return "Banista{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
