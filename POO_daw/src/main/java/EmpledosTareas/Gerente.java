package EmpledosTareas;

public class Gerente extends Empleado{

    public Gerente(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void realizarTarea(){
        System.out.println("Supervisando el proyecto y organizando reuniones.");
    }
}
