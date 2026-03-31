package ECommerce;

import java.util.Random;
import java.util.Scanner;

/**
 * Metodo de pago con Bizum.
 */
public class Bizum extends MetodoPago {

    private static final int LONGITUD_TELEFONO = 9;
    private static final int PIN_MIN = 100000;
    private static final int PIN_MAX = 999999;

    private final Random random;
    private String telefono;
    private int pin;

    /**
     * Crea un metodo de pago Bizum.
     *
     * @param telefono telefono vinculado a Bizum
     * @param pin pin actual
     */
    public Bizum(String telefono, int pin) {
        super("Bizum");
        this.telefono = telefono;
        this.pin = pin;
        this.random = new Random();
    }

    @Override
    public boolean validarDatos(Scanner teclado) throws InterruptedException {
        System.out.println("Introduce el numero de telefono vinculado a tu Bizum:");
        String numero = teclado.nextLine().trim();

        if (!numero.matches("{" + LONGITUD_TELEFONO + "}")) {
            System.out.println("Los datos de tu Bizum no son correctos");
            return false;
        }

        pin = random.nextInt(PIN_MAX - PIN_MIN + 1) + PIN_MIN;
        System.out.println("[Chivato PIN] " + pin);
        System.out.println("Introduce tu PIN:");
        String pinTexto = teclado.nextLine().trim();

        if (!pinTexto.matches("{6}")) {
            System.out.println("Los datos de tu Bizum no son correctos");
            return false;
        }

        System.out.println("Validando Bizum...");
        Thread.sleep(1000);

        if (Integer.parseInt(pinTexto) != pin) {
            System.out.println("Los datos de tu Bizum no son correctos");
            return false;
        }

        telefono = numero;
        return true;
    }

    @Override
    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " EUR con Bizum");
        System.out.println("Pago aceptado. Muchas gracias.");
    }
}
