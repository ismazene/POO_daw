package Recuperacion_1.TicketMutxa;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nombre_usuario;
    private String contrasena;
    private Map<Evento, Integer> mapa = new HashMap<>();

    public Usuario(String nombre_usuario, String contrasena) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Map<Evento, Integer> getMapa() {
        return mapa;
    }

    public void setMapa(Map<Evento, Integer> mapa) {
        this.mapa = mapa;
    }

    public void anyadirAlCarrito(Evento evento, int cantidad) {
        int actual = mapa.getOrDefault(evento, 0);
        int nuevaCantidad = actual + cantidad;

        if (cantidad <= 0 || nuevaCantidad > 7) {
            System.out.println("Error: no se pueden comprar mas de 7 entradas por persona.");
            return;
        }

        mapa.put(evento, nuevaCantidad);
    }

    public void setCarrito(Evento evento, int cantidad) {
        if (cantidad < 0 || cantidad > 7) {
            System.out.println("Error: la cantidad del carrito debe estar entre 0 y 7.");
            return;
        }

        if (cantidad == 0) {
            mapa.remove(evento);
            return;
        }

        mapa.put(evento, cantidad);
    }

    public void verCarrito() {
        if (mapa.isEmpty()) {
            System.out.println("El carrito esta vacio.");
            return;
        }

        System.out.println("Carrito actual:");
        for (Map.Entry<Evento, Integer> entrada : mapa.entrySet()) {
            Evento evento = entrada.getKey();
            Integer cantidad = entrada.getValue();
            System.out.println("- " + evento.getNombre() + " | Entradas: " + cantidad + " | Precio unitario: " + evento.getPrecio() + " EUR");
        }
    }
}
