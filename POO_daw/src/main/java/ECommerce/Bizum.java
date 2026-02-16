package ECommerce;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase pago Bizum.
 * Valida telefono y bizum
 * Procesar pago si esta todo bien
 */
public class Bizum extends MetodoPago {

    /** Scanner */
    static Scanner teclado = new Scanner(System.in);

    private String telefono;
    private int pin;
    private Random random = new Random();
    final static int NUMERO_MAX = 9;

    /**
     * Constructor
     * @param telefono numero de telefono del usuario
     * @param pin el pin
     */
    public Bizum(String telefono, int pin) {
        this.telefono = telefono;
        this.pin = pin;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * Valida el pago con Bizum.
     * 1. Generar un PIN
     * 2. Solicitar el teléfono
     * 3. Compruebacion del telefono
     * 4. Pedir el PIN.
     * 5. Si todo esta bien llamamos a procesarPago
     */
    public void validarPago() throws InterruptedException {

        // Genera PIN de 6 cifras
        pin = random.nextInt(900000) + 100000;

        System.out.println("Introduce el número de teléfono vinculado a tu Bizum:");
        String numero = teclado.nextLine();

        if (numero.length() != NUMERO_MAX) {
            System.out.println("Los datos de tu Bizum no son correctos");
            return;
        }

        System.out.println("[Chivato PIN] " + pin);

        System.out.println("Introduce tu PIN:");
        int pinIntroducido = Integer.parseInt(teclado.nextLine());

        System.out.println("Validando Bizum...");
        Thread.sleep(5000);

        if (pinIntroducido != pin) {
            System.out.println("Los datos de tu Bizum no son correctos");
            return;
        }

        this.telefono = numero;

        System.out.println("Introduce el importe a pagar:");
        double importe = teclado.nextDouble();
        System.out.println();

        procesarPago(importe);
    }

    /**
     * Procesar pago
     * @param importe cantidad a pagar
     */
    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con Bizum");
        System.out.println("Pago aceptado. Muchas gracias");
    }
}
