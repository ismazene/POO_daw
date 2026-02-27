package PracticoModeloA;

import java.util.Scanner;

public class AppPizzaExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Empleado empleado1 = new Empleado("Ana");
        Empleado empleado2 = new Empleado("Luis");
        empleado1.obtenerDetalles();
        empleado2.obtenerDetalles();

        System.out.print("Nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nombreCliente);
        Pedido pedido = new Pedido(cliente, Estado.CREANDO);

        boolean seguir = true;
        while (seguir) {
            cliente.pedir();
            pedido.mostrarCarta();
            System.out.print("Elige pizza (ej: BBQ): ");
            String pizzaElegida = scanner.nextLine();

            try {
                pedido.agregarPizzaPorNombre(pizzaElegida);
                System.out.println("Pizza anadida.");
            } catch (IllegalArgumentException e) {
                System.out.println("Pizza invalida. No esta en la carta.");
            }

            System.out.printf("Precio acumulado: %.2f EUR%n", pedido.calcularTotalSinDescuento());
            System.out.print("Quieres anadir otra pizza? (S/N): ");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            seguir = "S".equals(respuesta);
        }

        pedido.setEstadoPedido(Estado.RECIBIDO);
        System.out.printf(
                "Pedido %s. Total pedido: %.2f EUR. Descuento a aplicar: %d%% (%.2f EUR). Total a pagar: %.2f EUR%n",
                pedido.getEstadoPedido(),
                pedido.calcularTotalSinDescuento(),
                cliente.getDescuento(),
                pedido.calcularDescuentoAplicado(),
                pedido.calcularTotalConDescuento()
        );
        System.out.println("Pasa por caja para pagar y recoger tu pedido cuando este LISTO. Muchas gracias " + cliente.getNombre());

        empleado1.siguienteEstado(pedido); // MONTANDO_PIZZA
        empleado1.siguienteEstado(pedido); // HORNEANDO

        try {
            empleado2.entregarPedido(pedido);
        } catch (PedidoNoListoException e) {
            System.out.println("Error de entrega: " + e.getMessage());
        }

        empleado1.siguienteEstado(pedido); // PREPARANDO_PEDIDO
        empleado1.siguienteEstado(pedido); // LISTO

        cliente.pagar(pedido);
        try {
            empleado2.entregarPedido(pedido);
        } catch (PedidoNoListoException e) {
            System.out.println("Error de entrega: " + e.getMessage());
        }
        cliente.recoger();

        scanner.close();
    }
}
