package Recuperacion_1.TicketMutxa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TicketMutxa {
    static Set<Usuario> UsuariosRegistrados = new LinkedHashSet<>();
    static Set<Evento> listaEvento = new LinkedHashSet<>();
    static String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static Random aleatorio = new Random();

    public TicketMutxa() {
        UsuariosRegistrados = new LinkedHashSet<>();
        listaEvento = new LinkedHashSet<>();
    }

    public static Set<Usuario> getUsuariosRegistrados() {
        return Collections.unmodifiableSet(UsuariosRegistrados);
    }

    public static void setUsuariosRegistrados(Set<Usuario> usuariosRegistrados) {
        UsuariosRegistrados = usuariosRegistrados;
    }

    public static Set<Evento> getListaEvento() {
        return listaEvento;
    }

    public static void setListaEvento(Set<Evento> listaEvento) {
        TicketMutxa.listaEvento = listaEvento;
    }

    public static void insertarEvento(String nombre, LocalDate fecha, double precio, String tipo) {
        Evento nuevoEvento;

        if (tipo.equalsIgnoreCase("festival")) {
            nuevoEvento = new Festival(nombre, fecha, precio);
        } else if (tipo.equalsIgnoreCase("concierto")) {
            nuevoEvento = new Concierto(nombre, fecha, precio);
        } else {
            System.out.println("No existe el tipo de evento.");
            return;
        }

        listaEvento.add(nuevoEvento);
    }

    public static void generarUsuarios(int i) {
        while (UsuariosRegistrados.size() < i) {
            String usuario = "";
            String contrasena = "";

            for (int o = 0; o < 8; o++) {
                usuario += caracteres.charAt(aleatorio.nextInt(caracteres.length()));
                contrasena += caracteres.charAt(aleatorio.nextInt(caracteres.length()));
            }

            boolean repetido = false;
            for (Usuario usua : UsuariosRegistrados) {
                if (usua.getNombre_usuario().equals(usuario)) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                Usuario nuevo = new Usuario(usuario, contrasena);
                UsuariosRegistrados.add(nuevo);
                System.out.println("Chivato de usuarios generados -- " + usuario + " - " + contrasena);
            }
        }
    }

    private static List<Evento> getEventosOrdenados() {
        List<Evento> eventosOrdenados = new ArrayList<>(listaEvento);
        Collections.sort(eventosOrdenados, new Comparator<Evento>() {
            @Override
            public int compare(Evento e1, Evento e2) {
                return e1.getFecha().compareTo(e2.getFecha());
            }
        });
        return eventosOrdenados;
    }

    public static void verEventos(Usuario comprador) {
        List<Evento> eventosOrdenados = getEventosOrdenados();
        System.out.println("-----------");
        System.out.println("Hola " + comprador.getNombre_usuario() + ". Elige un evento para iniciar la compra:");
        for (int i = 0; i < eventosOrdenados.size(); i++) {
            Evento evento = eventosOrdenados.get(i);
            System.out.println("[" + (i + 1) + "]. " + evento.getNombre() + " - " + evento.getFecha() + " - " + evento.getPrecio() + " EUR");
        }
        System.out.println("------------------");
    }

    public static Evento getEvento(int opcion) {
        List<Evento> eventosOrdenados = getEventosOrdenados();

        if (opcion < 1 || opcion > eventosOrdenados.size()) {
            return null;
        }

        return eventosOrdenados.get(opcion - 1);
    }
}
