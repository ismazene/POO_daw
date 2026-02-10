package EmpledosTareas;

public class Diseñador extends Empleado{
    public Diseñador(String nombre, int edad) {
        super(nombre, edad);
    }

    public void realizarTarea(){
        System.out.println("Creando diseños y prototipos");
    }

}
