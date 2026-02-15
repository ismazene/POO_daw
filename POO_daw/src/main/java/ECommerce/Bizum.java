package ECommerce;

import java.util.Random;
import java.util.Scanner;

public class Bizum extends MetodoPago{
    static Scanner teclado = new Scanner(System.in);


    private String telefono;
    private int pin;
    private Random random = new Random();
    final static int NUMERO_MAX = 9;



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

    public void validarPago() throws InterruptedException {

        // Genera PIN de 6 cifras
        pin = random.nextInt(900000) + 100000;

        System.out.println("Introduce el número de teléfono vinculado a tu Bizum:");
        String numero = teclado.nextLine();

        // Chivato solo para pruebas (como en tu ejemplo)
        System.out.println("[Chivato PIN] " + pin);

        System.out.println("Introduce tu PIN:");
        int pinIntroducido = Integer.parseInt(teclado.nextLine());

        System.out.println("Validando Bizum...");
        Thread.sleep(1500);

        if (numero.length() != NUMERO_MAX) {
            System.out.println("El número debe tener 9 cifras");
            return;
        }

        if (pinIntroducido != pin) {
            System.out.println("PIN incorrecto");
            return;
        }

        this.telefono = numero;

        System.out.println("Introduce el importe a pagar:");
        double importe = Double.parseDouble(teclado.nextLine());

        procesarPago(importe);
    }

    @Override
    void procesarPago(double importe) {

    }
}
