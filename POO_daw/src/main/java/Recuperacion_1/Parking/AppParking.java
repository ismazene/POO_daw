package Recuperacion_1.Parking;

public class AppParking {
    static Parking parking = new Parking ("Mutxamel Centro",1000, 0.0025);

    static void main() {

        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();
    }
}
