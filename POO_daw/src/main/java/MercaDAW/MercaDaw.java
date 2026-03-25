package MercaDAW;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Gestiona los clientes de la aplicacion.
 */
public class MercaDaw {
    private static final Random aleatorio = new Random();
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Scanner teclado = new Scanner(System.in);
    private List<Cliente> listaClientes;

    /**
     * Inicializa la lista de clientes.
     */
    public MercaDaw() {
        listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Genera clientes aleatorios para probar la aplicacion.
     */
    public void generarClientes() {
        int cantidadClientes = aleatorio.nextInt(15) + 1;

        for (int i = 0; i < cantidadClientes; i++) {
            String usuario = generarUsuario();
            String contrasenya = generarContrasenya();
            Cliente cliente = new Cliente(usuario, contrasenya, "Calle falsa, 123", null);
            listaClientes.add(cliente);
        }

        System.out.println(cantidadClientes + " clientes generados:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Genera un usuario aleatorio
     *
     * @return usuario generado
     */
    public String generarUsuario() {
        String usuario = "";

        for (int i = 0; i < 8; i++) {
            usuario += CARACTERES.charAt(aleatorio.nextInt(CARACTERES.length()));
        }

        return usuario;
    }

    /**
     * Genera una contrasenya aleatoria
     *
     * @return contrasenya generada
     */
    public String generarContrasenya() {
        String contrasenya = "";

        for (int i = 0; i < 8; i++) {
            contrasenya += CARACTERES.charAt(aleatorio.nextInt(CARACTERES.length()));
        }

        return contrasenya;
    }

    /**
     * Solicita credenciales y válida al cliente.
     *
     * @param clientes lista de clientes registrados
     * @return cliente autenticado o null si falla
     */
    public Cliente autenticacion(List<Cliente> clientes) {
        int intentos = 3;

        System.out.println("=== COMPRA ONLINE EN MERCADAW ===");

        while (intentos > 0) {
            System.out.println("Usuario:");
            String usuario = teclado.next();

            System.out.println("Contrasenya:");
            String contrasenya = teclado.next();

            for (Cliente cliente : clientes) {
                if (cliente.getUsuario().equals(usuario) && cliente.getContrasenya().equals(contrasenya)) {
                    System.out.println("Bienvenido, " + usuario);
                    return cliente;
                }
            }

            intentos--;
            if (intentos > 0) {
                System.out.println("Credenciales no validas. Intentos: " + intentos);
            }
        }

        System.out.println("ERROR DE AUTENTICACION. Intentos:  " + intentos);
        return null;
    }
}
