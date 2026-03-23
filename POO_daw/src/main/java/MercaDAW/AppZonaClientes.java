package MercaDAW;

import java.util.Scanner;

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
        System.out.println("Bienvenido " + clienteLogueado.getUsuario());
        System.out.println();
        System.out.println("Creando nuevo pedido...");
        clienteLogueado.crearPedido();
        System.out.println();
        imprimirProductos();
    }

    public static void imprimirProductos() {
        System.out.println("Creando nuevo pedido...");
        System.out.println();

        for (Producto producto : Producto.values()) {
            System.out.println(producto + " " + producto.getPrecio() + "€");
            System.out.println("================================================");
            System.out.println("Elige un producto: ");
            String productoSeleccionado = teclado.next();
        }
    }
}
