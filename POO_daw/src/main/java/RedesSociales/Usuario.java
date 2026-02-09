package RedesSociales;

public class Usuario {
    private String nombre;
    private int edad;
    private String nombreUsuario;
    private int seguidores;

    public Usuario(String nombre, int edad, int seguidores, String nombreUsuario) {
        this.nombre = nombre;
        this.edad = edad;
        this.seguidores = seguidores;
        this.nombreUsuario = nombreUsuario;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public void mostrarInformacionUsuario(){
        System.out.println("Informacion del Usuario: " +
                " Nombre: " + nombre +
                " Edad: " + edad +
                " Nombre de usuario: " + nombreUsuario +
                " Seguidoes: " + seguidores);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", seguidores=" + seguidores +
                '}';
    }
}
