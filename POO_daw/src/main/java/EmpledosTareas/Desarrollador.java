package EmpledosTareas;

public class Desarrollador extends Empleado{

    public Desarrollador(String nombre, int edad) {
        super(nombre, edad);
    }

    public void realizarTarea(){
        System.out.println("Escribiendo codigo y resolviendo bugs");
    }

}
