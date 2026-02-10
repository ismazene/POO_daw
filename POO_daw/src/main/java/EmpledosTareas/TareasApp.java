package EmpledosTareas;


import java.util.ArrayList;

public class TareasApp {


    static void main() {


        Empleado Ismael = new Desarrollador("Ismael", 20);
        Empleado Izan = new Diseñador("Izan", 20);
        Empleado Patricia = new Gerente("Patricia", 25);

        ArrayList<Empleado> listaPersonal = new ArrayList<>();

        listaPersonal.add(Ismael);
        listaPersonal.add(Izan);
        listaPersonal.add(Patricia);

        System.out.println("== Usando el array polimórfico ===");
        for (Empleado empleado : listaPersonal) {
            realizarTarea();
        }

    }


    public static void realizarTarea() {
        System.out.println("Empleado realizando una tarea generica");
    }

    public static void asignarTarea(Empleado empleado) {
        System.out.println("Asignando tarea al empleado...");
        realizarTarea();
    }
}
