package chalet;

public class ChaletApp {
    static void main() {
        Casa pisito = new Casa("Calle falsa 123");

        pisito.crearHabitacion("Cocina", 15.5);
        pisito.crearHabitacion("Terracita", 35.3);


        pisito.mostrarHabitaciones();
        System.out.println();
        System.out.println("La habitacion mas grande es: " + pisito.getHabitacionMasGrande().getNombre());

    }
}
