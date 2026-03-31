package Recuperacion_1.TicketMutxa;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class AppCompraEntradas implements Acciones {
    static Usuario comprador;
    static Evento eventoCompra;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        AppCompraEntradas app = new AppCompraEntradas();

        TicketMutxa.insertarEvento("Paellas", LocalDate.of(2025, 4, 16), 20, "festival");
        TicketMutxa.insertarEvento("Concierto Estopa", LocalDate.of(2025, 4, 21), 40, "concierto");
        TicketMutxa.generarUsuarios(4);

        while (!app.autentificarse(TicketMutxa.getUsuariosRegistrados())) {
        }

        TicketMutxa.verEventos(comprador);
        eventoCompra = app.seleccionarEvento();
        app.simularColaVirtual();
        app.gestionarCompra();
    }

    @Override
    public boolean autentificarse(Set<Usuario> usuariosRegistrados) {
        System.out.println("*** BIENVENIDO A TICKETMUTXA ***");
        System.out.println();
        System.out.println("Inicia sesion");
        System.out.println("Usuario");
        System.out.print("> ");
        String nombreUsuario = teclado.nextLine();
        System.out.println("Contrasena");
        System.out.print("> ");
        String contrasena = teclado.nextLine();

        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNombre_usuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                comprador = usuario;
                System.out.println("BIENVENIDO!!!");
                return true;
            }
        }

        System.out.println("Credenciales no validas. Intentalo de nuevo...");
        return false;
    }

    private Evento seleccionarEvento() {
        Evento eventoSeleccionado = null;

        while (eventoSeleccionado == null) {
            int opcion = leerEntero("Elige un evento por numero:");
            eventoSeleccionado = TicketMutxa.getEvento(opcion);

            if (eventoSeleccionado == null) {
                System.out.println("Error: la opcion elegida no existe.");
            }
        }

        System.out.println("Evento seleccionado: " + eventoSeleccionado.getNombre());
        return eventoSeleccionado;
    }

    private void simularColaVirtual() {
        Queue<Usuario> cola = new LinkedList<>();

        for (Usuario usuario : TicketMutxa.getUsuariosRegistrados()) {
            if (usuario != comprador) {
                cola.offer(usuario);
            }
        }
        cola.offer(comprador);

        int posicion = cola.size();
        while (posicion > 1) {
            System.out.println("Cola virtual: tu posicion actual es " + posicion);
            cola.poll();
            posicion--;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Cola virtual: tu posicion actual es 1. Es tu turno.");
    }

    private void gestionarCompra() {
        int cantidadInicial = leerEntero("Cuantas entradas quieres comprar?");
        while (cantidadInicial < 1 || cantidadInicial > 7) {
            System.out.println("Error: no se pueden comprar mas de 7 entradas por persona.");
            cantidadInicial = leerEntero("Introduce una cantidad valida:");
        }

        comprador.anyadirAlCarrito(eventoCompra, cantidadInicial);
        comprador.verCarrito();

        boolean finalizarCompra = false;
        while (!finalizarCompra) {
            imprimirMenu();
            int opcion = leerEntero("Elige una opcion:");

            switch (opcion) {
                case 1:
                    modificarCarrito(true);
                    break;
                case 2:
                    modificarCarrito(false);
                    break;
                case 3:
                    if (comprador.getMapa().getOrDefault(eventoCompra, 0) == 0) {
                        System.out.println("Error: no puedes pagar con 0 entradas en el carrito.");
                    } else {
                        pagar();
                        finalizarCompra = true;
                    }
                    break;
                default:
                    System.out.println("Error: opcion no contemplada.");
            }
        }
    }

    private void modificarCarrito(boolean sumar) {
        int cantidadActual = comprador.getMapa().getOrDefault(eventoCompra, 0);
        int cambio = leerEntero(sumar ? "Cuantas entradas quieres anadir?" : "Cuantas entradas quieres eliminar?");
        int nuevaCantidad = sumar ? cantidadActual + cambio : cantidadActual - cambio;

        if (nuevaCantidad > 7) {
            System.out.println("Error: no se pueden comprar mas de 7 entradas por persona.");
            return;
        }

        if (nuevaCantidad < 0) {
            System.out.println("Error: no puede haber menos de 0 entradas.");
            return;
        }

        comprador.setCarrito(eventoCompra, nuevaCantidad);
        comprador.verCarrito();
    }

    private void imprimirMenu() {
        System.out.println("Menu:");
        System.out.println("[1] Anadir entradas");
        System.out.println("[2] Eliminar entradas");
        System.out.println("[3] Pagar y finalizar");
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            System.out.print("> ");
            String texto = teclado.nextLine();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: debes introducir un numero entero.");
            }
        }
    }

    @Override
    public void pagar() {
        MetodoPago metodoSeleccionado = null;

        while (metodoSeleccionado == null) {
            System.out.println("Selecciona metodo de pago:");
            System.out.println("[1] Bizum");
            System.out.println("[2] Paypal");
            System.out.println("[3] Tarjeta");
            System.out.println("[4] ApplePay");

            int opcion = leerEntero("Elige una opcion:");
            switch (opcion) {
                case 1:
                    metodoSeleccionado = MetodoPago.BIZUM;
                    break;
                case 2:
                    metodoSeleccionado = MetodoPago.PAYPAL;
                    break;
                case 3:
                    metodoSeleccionado = MetodoPago.TARJETA;
                    break;
                case 4:
                    metodoSeleccionado = MetodoPago.APPLEPAY;
                    break;
                default:
                    System.out.println("Error: metodo de pago no permitido.");
            }
        }

        int cantidad = comprador.getMapa().getOrDefault(eventoCompra, 0);
        double subtotal = cantidad * eventoCompra.getPrecio();
        double gastosGestion = metodoSeleccionado.getPrecio();
        double total = subtotal + gastosGestion;

        System.out.println("Resumen de compra:");
        System.out.println("Evento: " + eventoCompra.getNombre());
        System.out.println("Entradas: " + cantidad);
        System.out.println("Subtotal: " + subtotal + " EUR");
        System.out.println("Gastos de gestion: " + gastosGestion + " EUR");
        System.out.println("Metodo de pago: " + metodoSeleccionado);
        System.out.println("Total: " + total + " EUR");
        System.out.println("Compra finalizada correctamente.");
    }
}
