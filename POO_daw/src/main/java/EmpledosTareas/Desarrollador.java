package EmpledosTareas;
public class Desarrollador extends Empleado{

    public Desarrollador(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void realizarTarea(){
        System.out.println("Escribiendo código y solucionando bugs.");
    }
}
