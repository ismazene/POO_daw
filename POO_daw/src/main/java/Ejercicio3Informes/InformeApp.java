package Ejercicio3Informes;

public class InformeApp {

    static void main(String[] args) {

        GestorInformes gestor = new GestorInformes();

        // Ponemos 5 informes
        gestor.añadirInforme(new Informe(1,"ADMINISTRATIVO"));
        gestor.añadirInforme(new Informe(2,"EMPRESARIAL"));
        gestor.añadirInforme(new Informe(3,"PERSONAL"));
        gestor.añadirInforme(new Informe(4,"ADMINISTRATIVO"));
        gestor.añadirInforme(new Informe(5,"EMPRESARIAL"));

        System.out.println("Mostrando informes:");
        gestor.mostrarYDespachar();

        // Añadimos 3 nuevos
        gestor.añadirInforme(new Informe(1,"PERSONAL"));
        gestor.añadirInforme(new Informe(2,"ADMINISTRATIVO"));
        gestor.añadirInforme(new Informe(3,"EMPRESARIAL"));

        System.out.println("Tipos de tareas pendientes:");
        System.out.println(gestor.contarTiposTareas());

        System.out.println("Orden de salida:");
        gestor.mostrarYDespachar();
    }
}