package ECommerce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Metodo de pago con tarjeta de credito.
 */
public class TarjetaCredito extends MetodoPago {

    private static final int LONGITUD_TARJETA = 16;
    private static final String[] TIPOS_TARJETA = {"VISA", "MAESTRO", "MASTERCARD"};

    private String numeroTarjeta;
    private String tipoSeleccionado;

    /**
     * Crea un metodo de pago con tarjeta.
     *
     * @param numeroTarjeta numero de la tarjeta
     */
    public TarjetaCredito(String numeroTarjeta) {
        super("Tarjeta");
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public boolean validarDatos(Scanner teclado) throws InterruptedException {
        System.out.println("Dame el numero de la tarjeta, recuerda que solo se permiten 16 numeros:");
        String numero = teclado.nextLine().trim();

        if (!numero.matches("{" + LONGITUD_TARJETA + "}")) {
            System.out.println("Numero de tarjeta no valido");
            return false;
        }

        System.out.println("Selecciona el tipo de tarjeta [VISA, MASTERCARD, MAESTRO]:");
        String tipoTarjeta = teclado.nextLine().trim().toUpperCase();

        if (!Arrays.asList(TIPOS_TARJETA).contains(tipoTarjeta)) {
            System.out.println("Tipo de tarjeta no valido");
            return false;
        }

        numeroTarjeta = numero;
        tipoSeleccionado = tipoTarjeta;

        System.out.println("Validando tarjeta...");
        Thread.sleep(1000);
        return true;
    }

    @Override
    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " EUR con tarjeta " + tipoSeleccionado);
        System.out.println("Pago aceptado. Muchas gracias.");
    }
}
