package DispositivosInteligentes;

public abstract class Dispositivo {
    private String nombre;
    private boolean estado;

    public Dispositivo(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void apagar(){
        System.out.println(nombre + " apagado");

        if (estado == estado){
            System.out.println("El " + nombre + " esta apagado");
        }
    }
    public void mostrarEstado(){
        System.out.println("El estado actual es: " + estado);
    }

    /// Cada una de las clases la implementa de forma diferente
    abstract void encender();

}
