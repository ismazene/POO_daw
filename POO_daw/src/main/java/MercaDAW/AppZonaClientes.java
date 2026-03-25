package MercaDAW;

import java.util.Map;
import java.util.Scanner;

/**
 * Aplicacion principal para la zona de clientes.
 */
public class AppZonaClientes {
    static Cliente clienteLogueado;
    static Scanner teclado = new Scanner(System.in);

    /**
     * Punto de entrada
     */
    public static void main(String[] args) {
        MercaDaw mercado = new MercaDaw();
        mercado.generarClientes();
        autenticarCliente(mercado);
    }

    /**
     * Autentica al cliente e inicia la compra si el login es correcto.
     *
     */
    public static void autenticarCliente(MercaDaw mercado) {
        clienteLogueado = mercado.autenticacion(mercado.getListaClientes());

        if (clienteLogueado != null) {
            iniciarCompra();
        }
    }

    /**
     * Inicia un nuevo pedido y permite anadir productos.
     */
    public static void iniciarCompra() {
        System.out.println();
        System.out.println("Creando nuevo pedido...");
        clienteLogueado.crearPedido();

        boolean seguir = true;

        while (seguir) {
            imprimirProductos();

            System.out.println("Quieres anadir mas productos? (S/N)");
            String respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("N")) {
                seguir = false;
            }
        }

        imprimirResumen();
        promociones();
    }

    /**
     * Muestra los productos del enum de Productos y puedes insertar uno en el pedido.
     */
    public static void imprimirProductos() {
        System.out.println("Elige un produto de la lista...");
        System.out.println("=== PRODUCTOS DISPONIBLES ===");

        for (Producto producto : Producto.values()) {
            System.out.println(producto + ": " + producto.getPrecio() + " EUR");
        }

        System.out.println("================================");
        System.out.println("Elige un producto:");

        String productoSeleccionado = teclado.next();

        try {
            Producto producto = Producto.valueOf(productoSeleccionado.toUpperCase());
            clienteLogueado.getPedido().insertarProducto(producto);

            System.out.println("Producto anadido correctamente.");

            double total = clienteLogueado.importePedido();
            System.out.println("Importe actual: " + total + " EUR");
        } catch (IllegalArgumentException e) {
            System.out.println("Producto no reconocido. Elige otro...");
            imprimirProductos();
        }
    }

    /**
     * Imprime el resumen del pedido.
     */
    public static void imprimirResumen() {
        System.out.println("=== RESUMEN DEL PEDIDO ===");

        Pedido pedido = clienteLogueado.getPedido();

        if (pedido.getMapa().isEmpty()) {
            System.out.println("El carrito esta vacio.");
        } else {
            for (Producto producto : pedido.getMapa().keySet()) {
                int cantidad = pedido.getMapa().get(producto);
                System.out.println(producto + " x" + cantidad);
            }
        }

        System.out.println("----------------------------------");
        System.out.println("IMPORTE TOTAL: " + pedido.getImporte_total() + " EUR");
        System.out.println();
    }

    /**
     * Muestra el menu de cosas que puedes hacer antes de finalizar
     */
    public static void promociones() {
        System.out.println("===================");
        System.out.println("Que desea hacer?");
        System.out.println("[1] Aplicar promos");
        System.out.println("[2] Mostrar resumen ordenado por uds");
        System.out.println("[3] Terminar pedido");
        System.out.println("[4] Eliminar producto del carrito");

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
            case 4:
                eliminarProducto();
                break;
            default:
                System.out.println("Opcion no valida.");
                promociones();
        }
    }

    /**
     * Aplica las promociones del pedido.
     */
    public static void aplicarPromos() {
        if (clienteLogueado.getPromociones()) {
            System.out.println("Ya has aplicado tus promociones.");
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

    /**
     * Muestra el resumen del pedido ordenado descendiente.
     */
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

    /**
     * Elimina un producto del carrito.
     */
    public static void eliminarProducto() {
        Pedido pedido = clienteLogueado.getPedido();

        if (pedido.getMapa().isEmpty()) {
            System.out.println("No hay productos en el carrito.");
            promociones();
            return;
        }

        System.out.println("Que producto quieres eliminar?");
        for (Producto producto : pedido.getMapa().keySet()) {
            System.out.println(producto + " x" + pedido.getMapa().get(producto));
        }

        String productoSeleccionado = teclado.next();

        try {
            Producto producto = Producto.valueOf(productoSeleccionado.toUpperCase());
            boolean eliminado = pedido.eliminarProducto(producto);

            if (eliminado) {
                clienteLogueado.setPromociones(false);
                System.out.println("Producto eliminado correctamente.");
                imprimirResumen();
            } else {
                System.out.println("Ese producto no estaba en el carrito.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: producto no valido.");
        }

        promociones();
    }

    /**
     * Muestra el mensaje final de despedida.
     */
    public static void despedida() {
        System.out.println("Gracias por tu compra.");
        System.out.println("Envio a: " + clienteLogueado.getDireccion());
    }
}
