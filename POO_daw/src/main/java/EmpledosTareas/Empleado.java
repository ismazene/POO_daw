package EmpledosTareas;

public class Empleado {

    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;

    }

    public void realizarTarea(){
        System.out.println("Empleado realizando una tarea genérica.");
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

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}