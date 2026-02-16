package ECommerce;

import java.util.Scanner;

/**
 * Permite al usuario elegir un metodo de pago y hacer el pago
 */
public class Tienda {

    /**
     * Iniciar el pago en la tienda
     */
    public static void iniciarPago() throws InterruptedException {
        realizarPago();
    }

    /**
     * Realizar el pago dependiendo de lo que diga el usuario
     */
    private static void realizarPago() throws InterruptedException {
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Qué método de pago quieres usar? [Bizum, PayPal, Tarjeta]");
        String metodoPago = teclado.nextLine().toLowerCase();

        switch (metodoPago) {
            case "bizum":
                Bizum prueba3 = new Bizum("123456789", 123456);
                prueba3.validarPago();
                break;

            case "paypal":
                PayPal prueba2 = new PayPal(23, "La mia");
                prueba2.validarPago();
                break;

            case "tarjeta":
                TarjetaCredito prueba = new TarjetaCredito("1234567890123456");
                prueba.validarPago();
                break;

            default:
                System.out.println("El metodo de pago no existe");
        }
    }
}
