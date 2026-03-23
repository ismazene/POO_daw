package MercaDAW;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MercaDaw {
    private static final Random aleatorio = new Random();
    private static final String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Scanner teclado = new Scanner(System.in);
    private List<Cliente> listaClientes;

    public MercaDaw() {
        listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void generarClientes() {
        int cantidadClientes = aleatorio.nextInt(15) + 1;

        for (int i = 0; i < cantidadClientes; i++) {
            String usuario = generarUsuario();
            String contrasenya = generarContrasenya();
            Cliente cliente = new Cliente(usuario, contrasenya, "Calle falsa, 123", null);
            listaClientes.add(cliente);
        }

        System.out.println(cantidadClientes + " clientes generados. " + listaClientes);
    }
    public String generarUsuario() {
        String usuario = "";

        for (int i = 0; i < 8; i++) {
            usuario += caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }

        return usuario;
    }

    public String generarContrasenya() {
        String contrasenya = "";

        for (int i = 0; i < 8; i++) {
            contrasenya += caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }

        return contrasenya;
    }

    /// autenticacion(List<Cliente> clientes). Imprimirá y pedirá por pantalla lo siguiente:
    public Cliente autenticacion(List<Cliente> clientes) {
        int intentos = 3;

        System.out.println("=== COMPRA ONLINE EN MERCADAW ===");

        while (intentos > 0) {
            System.out.println("usuario:");
            String usuario = teclado.next();

            System.out.println("contraseña:");
            String contrasenya = teclado.next();

            for (Cliente cliente : clientes) {
                if (cliente.getUsuario().equals(usuario) && cliente.getContrasenya().equals(contrasenya)) {
                    System.out.println("Bienvenido " + usuario);
                    return cliente;
                }
            }

            intentos--;
            System.out.println("Credenciales no válidas. Intentos: " + intentos);
        }

        System.out.println("ERROR DE AUTENTICACIÓN");
        return null;
    }


}
