package Recuperacion_1.Parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Parking {
    private String ciudad;
    private int plazas_totales;
    private double precio_minuto;
    private List<Ticket> clientesActuales = new ArrayList<>();

    static Random random = new Random();
    private static String letras = "BCDFGHJKLMNPQRSTVWXYZ";
    private static String numeros = "0123456789";

    public Parking(String ciudad, int plazas_totales, double precio_minuto) {
        this.ciudad = ciudad;
        this.plazas_totales = plazas_totales;
        this.precio_minuto = precio_minuto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getPlazas_totales() {
        return plazas_totales;
    }

    public void setPlazas_totales(int plazas_totales) {
        this.plazas_totales = plazas_totales;
    }

    public double getPrecio_minuto() {
        return precio_minuto;
    }

    public void setPrecio_minuto(double precio_minuto) {
        this.precio_minuto = precio_minuto;
    }

    public List<Ticket> getClientesActuales() {
        return clientesActuales;
    }

    public void setClientesActuales(List<Ticket> clientesActuales) {
        this.clientesActuales = clientesActuales;
    }

    public void generarClientesAleatorios() {
        int cantidad = random.nextInt(10) + 1;

        while (clientesActuales.size() < cantidad) {
            String matricula = "";
            boolean repetida = false;

            for (int i = 0; i < 4; i++) {
                matricula += numeros.charAt(random.nextInt(numeros.length()));
            }

            for (int i = 0; i < 3; i++) {
                matricula += letras.charAt(random.nextInt(letras.length()));
            }

            for (Ticket ticket : clientesActuales) {
                if (ticket.getMatricula().equals(matricula)) {
                    repetida = true;
                    break;
                }
            }

            if (!repetida) {
                int minutos = random.nextInt(300) + 1;
                clientesActuales.add(new Ticket(matricula, minutos, Estado.RECOGIDO));
            }
        }
    }

    public void mostrarClientesActuales() {
        System.out.println("*** PARKING " + ciudad.toUpperCase() + " ***");
        for (Ticket ticket : clientesActuales) {
            System.out.println("Matricula: " + ticket.getMatricula() + " | Minutos: " + ticket.getMinutos() + " | Estado: " + ticket.getEstado());
        }
    }

    public void anyadirCliente(Ticket ticket) {
        clientesActuales.add(ticket);
    }

    public void comprobarPlazas() {
        int ocupadas = clientesActuales.size();
        int libres = plazas_totales - ocupadas;

        if (libres <= 0) {
            System.out.println("COMPLETO");
        } else {
            System.out.println("LIBRE (" + libres + " plazas libres)");
        }
    }

    public Ticket validarTicket(String matricula) {
        for (Ticket ticket : clientesActuales) {
            if (ticket.getMatricula().equalsIgnoreCase(matricula)) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> getClientesOrdenadosPorMinutos() {
        List<Ticket> listaOrdenada = new ArrayList<>(clientesActuales);
        listaOrdenada.sort(Comparator.comparing(Ticket::getMinutos));
        return listaOrdenada;
    }
}
