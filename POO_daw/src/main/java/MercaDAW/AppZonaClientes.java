package MercaDAW;

import java.util.*;

public class AppZonaClientes {
    static Cliente clienteLogueado;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        MercaDaw mercado = new MercaDaw();
        mercado.generarClientes();

        autenticarCliente(mercado);
    }

    public static void autenticarCliente(MercaDaw mercado) {
        clienteLogueado = mercado.autenticacion(mercado.getListaClientes());

        if (clienteLogueado != null) {
            iniciarCompra();
        }
    }

    public static void iniciarCompra() {
        System.out.println("Creando nuevo pedido...");
        clienteLogueado.crearPedido();

        boolean seguir = true;

        while (seguir) {
            imprimirProductos();

            System.out.println("¿Quieres añadir más productos? (S/N)");
            String respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("N")) {
                seguir = false;
            }
        }

        imprimirResumen();
        promociones();
    }

    public static void imprimirProductos() {
        System.out.println("=== PRODUCTOS DISPONIBLES ===");

        for (Producto producto : Producto.values()) {
            System.out.println(producto + " - " + producto.getPrecio() + "€");
        }

        System.out.println("================================================");
        System.out.println("Elige un producto: ");

        String productoSeleccionado = teclado.next();

        try {
            Producto producto = Producto.valueOf(productoSeleccionado.toUpperCase());

            clienteLogueado.getPedido().insertarProducto(producto);

            System.out.println("Producto añadido correctamente");

            double total = clienteLogueado.getPedido().importePedido();
            System.out.println("Importe actual: " + total + "€");

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: producto no válido");
            imprimirProductos();
        }
    }

    public static void imprimirResumen() {
        System.out.println("=== RESUMEN DEL PEDIDO ===");

        Pedido pedido = clienteLogueado.getPedido();

        for (Producto producto : pedido.getMapa().keySet()) {
            int cantidad = pedido.getMapa().get(producto);
            System.out.println(producto + " x" + cantidad);
        }

        System.out.println("----------------------------------");
        System.out.println("IMPORTE TOTAL: " + pedido.getImporte_total() + "€");
        System.out.println();
    }

    public static void promociones() {
        System.out.println("===================");
        System.out.println("¿Qué desea hacer?");
        System.out.println("[1] Aplicar Promos");
        System.out.println("[2] Mostrar resumen ordenado por uds");
        System.out.println("[3] Terminar pedido");

        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1:
                aplicarPromos();
                break;
            case 2:
                mostrarOrdenado();
                break;
            case 3:
                despedida();
                break;
            default:
                System.out.println("Opción no válida");
                promociones();
        }
    }

    public static void aplicarPromos() {
        if (clienteLogueado.getPromociones()) {
            System.out.println("Ya has aplicado promociones.");
            promociones();
            return;
        }

        Pedido pedido = clienteLogueado.getPedido();

        pedido.aplicarPromo3x2();
        pedido.aplicarPromo10();

        clienteLogueado.setPromociones(true);

        System.out.println("Promociones aplicadas.");

        imprimirResumen();
        promociones();
    }

    public static void mostrarOrdenado() {
        Pedido pedido = clienteLogueado.getPedido();
        Map<Producto, Integer> mapa = pedido.getMapa();

        System.out.println("=== PEDIDO ORDENADO ===");

        int maxCantidad = 0;
        for (int cantidad : mapa.values()) {
            if (cantidad > maxCantidad) {
                maxCantidad = cantidad;
            }
        }

        for (int cantidad = maxCantidad; cantidad > 0; cantidad--) {
            for (Producto producto : mapa.keySet()) {
                if (mapa.get(producto) == cantidad) {
                    System.out.println(producto + " x" + cantidad);
                }
            }
        }

        promociones();
    }
    public static void despedida() {
        System.out.println("Gracias por tu compra");
        System.out.println("Envío a: " + clienteLogueado.getDireccion());
    }
}