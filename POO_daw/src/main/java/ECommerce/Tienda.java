package ECommerce;

import java.util.Scanner;

/**
 * Orquesta el flujo de pago de la tienda.
 */
public class Tienda {

    /**
     * Inicia el flujo completo del pago.
     *
     * @throws InterruptedException si se interrumpe una pausa de validacion
     */
    public static void iniciarPago() throws InterruptedException {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Que metodo de pago quieres usar? [Bizum, PayPal, Tarjeta]");
        MetodoPago metodoPago = crearMetodoPago(teclado.nextLine());

        if (metodoPago == null) {
            System.out.println("El metodo de pago no existe");
            return;
        }

        if (!metodoPago.validarDatos(teclado)) {
            return;
        }

        double importe = pedirImporte(teclado);
        if (importe <= 0) {
            System.out.println("El importe no es valido");
            return;
        }

        if (!metodoPago.puedePagar(importe)) {
            return;
        }

        realizarPago(metodoPago, importe);
    }

    /**
     * Procesa el pago una vez que todos los datos ya son validos.
     *
     * @param metodoPago metodo de pago validado
     * @param importe importe a pagar
     */
    private static void realizarPago(MetodoPago metodoPago, double importe) {
        metodoPago.procesarPago(importe);
    }

    private static MetodoPago crearMetodoPago(String metodoPago) {
        switch (metodoPago.trim().toLowerCase()) {
            case "bizum":
                return new Bizum("", 0);
            case "paypal":
                return new PayPal(23, "");
            case "tarjeta":
                return new TarjetaCredito("");
            default:
                return null;
        }
    }

    private static double pedirImporte(Scanner teclado) {
        System.out.println("Introduce el importe a pagar:");
        String textoImporte = teclado.nextLine().trim();

        try {
            return Double.parseDouble(textoImporte);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
