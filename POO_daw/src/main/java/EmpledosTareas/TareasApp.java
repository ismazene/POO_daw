package EmpledosTareas;

import java.util.ArrayList;

public class TareasApp {

    static void main() {

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        Empleado ismael = new Gerente("Ismael", 20);
        listaEmpleados.add(ismael);

        Empleado izan = new Desarrollador("Izan", 20);
        listaEmpleados.add(izan);

        Empleado manuela = new Diseñador("Manuela", 19);
        listaEmpleados.add(manuela);

        System.out.println("=== USANDO EL ARRAY ===");
        for (Empleado empleado : listaEmpleados){
            empleado.realizarTarea();
        }

        System.out.println();

        for (Empleado empleado : listaEmpleados){
            asignarTarea(empleado);
        }

    }

    public static void asignarTarea(Empleado empleado){
        System.out.println("Asignando tarea al empleado ...");
        empleado.realizarTarea();
    }
}