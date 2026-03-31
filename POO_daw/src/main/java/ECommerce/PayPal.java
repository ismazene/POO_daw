package ECommerce;

import java.util.Scanner;

/**
 * Metodo de pago mediante PayPal.
 */
public class PayPal extends MetodoPago {

    private static final String CORREO_FORMAT = "^[A-Za-z0-9+_.-]+@gmailcom$";

    private String cuenta;
    private double saldo;

    /**
     * Crea un metodo de pago PayPal.
     *
     * @param saldo saldo disponible
     * @param cuenta correo asociado a la cuenta
     */
    public PayPal(double saldo, String cuenta) {
        super("PayPal");
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean validarDatos(Scanner teclado) throws InterruptedException {
        System.out.println("Dame tu correo:");
        String correo = teclado.nextLine().trim();

        if (!correo.matches(CORREO_FORMAT)) {
            System.out.println("Lo siento, el correo es incorrecto");
            return false;
        }

        System.out.println("Validando correo...");
        Thread.sleep(1000);
        System.out.println("Correo valido");
        cuenta = correo;
        return true;
    }

    @Override
    public boolean puedePagar(double importe) {
        if (importe > saldo) {
            System.out.println("No tienes fondos suficientes. Saldo disponible: " + saldo + " EUR");
            return false;
        }
        return true;
    }

    @Override
    public void procesarPago(double importe) {
        saldo -= importe;
        System.out.println("Procesando pago de " + importe + " EUR con PayPal");
        System.out.println("Pago aceptado. Saldo restante: " + saldo + " EUR");
    }
}
