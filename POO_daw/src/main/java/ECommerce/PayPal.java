package ECommerce;

import java.util.Scanner;

public class PayPal extends MetodoPago{
    static Scanner teclado = new Scanner(System.in);

    private static final String CORREO_FORMAT = "^[A-Za-z0-9+_.-]+@gmail.com$";
    private String cuenta;
    private double saldo = 23;

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

    /// METODOS

    public void validarPayPal() throws InterruptedException {
        System.out.println("Dame tu correo:");
        String correo = teclado.nextLine();

        if (correo.matches(CORREO_FORMAT)) {
            System.out.println("Validando correo...");
            Thread.sleep(3000);
            System.out.println("Correo válido");
            this.cuenta = correo;
            System.out.println("Introduce el importe a pagar: ");
            double importe = teclado.nextDouble();

            if (importe < getSaldo()){
                System.out.println("Perfecto, efectuando pago de: " + importe);
            } else {
                System.out.println("Has pinchado, no tienes fondos suficientes, solo te quedan: " + getSaldo() + " €");
            }
        } else {
            System.out.println("Lo siento, el correo es incorrecto");
        }
    }
    public void validarSaldo() throws InterruptedException {
        System.out.println("El saldo actual es de: " + getSaldo());
    }


    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de [importe] € con PayPal");
    }
}
