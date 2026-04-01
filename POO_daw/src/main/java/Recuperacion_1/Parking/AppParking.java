package Recuperacion_1.Parking;

import java.util.List;
import java.util.Scanner;

public class AppParking {
    static Parking parking = new Parking("Mutxamel Centro", 1000, 0.025);
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();

        app1();
        app2();
        app3();
    }

    public static void app1() {
        System.out.println("=== APP 1: ENTRADA AL PARKING ===");
        parking.comprobarPlazas();

        Ticket ticket = new Ticket("", 1, Estado.PENDIENTE);
        ticket.generar();
        parking.anyadirCliente(ticket);
        ticket.recoger();

        System.out.println("Lista despues de la entrada:");
        parking.mostrarClientesActuales();
    }

    public static void app2() {
        System.out.println("=== APP 2: PAGAR CON TICKET ===");
        System.out.print("Introduce la matricula: ");
        String matricula = teclado.nextLine();

        Ticket ticket = parking.validarTicket(matricula);
        if (ticket == null) {
            System.out.println("Matricula no encontrada.");
            return;
        }

        double importe = ticket.getMinutos() * parking.getPrecio_minuto();
        System.out.println("Importe a pagar: " + importe);

        ticket.pagar();
        System.out.println("Buen viaje!");
        parking.mostrarClientesActuales();
    }

    public static void app3() {
        System.out.println("=== APP 3: PAGAR SIN TICKET ===");
        List<Ticket> listaOrdenada = parking.getClientesOrdenadosPorMinutos();

        for (Ticket t : listaOrdenada) {
            System.out.println("Matricula: " + t.getMatricula() + " | Minutos: " + t.getMinutos() + " | Estado: " + t.getEstado());
        }

        System.out.print("Introduce la matricula del cliente: ");
        String matricula = teclado.nextLine();

        Ticket ticket = parking.validarTicket(matricula);
        if (ticket == null) {
            System.out.println("Matricula no encontrada.");
            return;
        }

        Acciones trabajador = new Acciones() {
            @Override
            public void generar() {
            }

            @Override
            public void recoger() {
            }

            @Override
            public void pagar() {
                System.out.print("Introduce los minutos a cobrar: ");
                int minutosACobrar = Integer.parseInt(teclado.nextLine());
                double importe = minutosACobrar * parking.getPrecio_minuto();

                System.out.println("Matricula: " + ticket.getMatricula());
                System.out.println("Minutos a cobrar: " + minutosACobrar);
                System.out.println("Importe a pagar: " + importe);
                System.out.println("Procesando pago...");
                System.out.println("Pago realizado correctamente.");

                ticket.setMinutos(minutosACobrar);
                ticket.setEstado(Estado.PAGADO);
            }
        };

        trabajador.pagar();
        parking.mostrarClientesActuales();
    }
}
