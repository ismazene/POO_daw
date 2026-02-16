package ECommerce;

import java.util.Scanner;

/**
 * Clase pago mediante PayPal.
 * Validar el correo electrónico, comprobar saldo
 */
public class PayPal extends MetodoPago {

    static Scanner teclado = new Scanner(System.in);

    private static final String CORREO_FORMAT = "^[A-Za-z0-9+_.-]+@gmail.com$";
    private String cuenta;
    private double saldo = 23;

    /**
     * Constructor
     *
     * @param saldo saldo
     * @param cuenta correo
     */
    public PayPal(double saldo, String cuenta) {
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Validar el pago
     *
     * 1. Pedir el correo del usuario y comprobar su formato
     * 2. Si es valido pide el importe
     * 3. Comprobar si hay saldo suficiente
     * 4. Si todo esta bien procesamos el pago
     *
     */
    public void validarPago() throws InterruptedException {
        System.out.println("Dame tu correo:");
        String correo = teclado.nextLine();

        if (correo.matches(CORREO_FORMAT)) {
            System.out.println("Validando correo...");
            Thread.sleep(5000);
            System.out.println("Correo válido");
            this.cuenta = correo;
            System.out.println("Introduce el importe a pagar: ");
            double importe = teclado.nextDouble();

            if (importe < getSaldo()) {
                procesarPago(importe);
            } else {
                System.out.println("Has pinchado, no tienes fondos suficientes, solo te quedan: " + getSaldo() + " €");
            }
        } else {
            System.out.println("Lo siento, el correo es incorrecto");
        }
    }

    /**
     * Procesar el pago
     *
     * @param importe Importe a pagar
     */
    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con " + "PayPal");
    }
}
