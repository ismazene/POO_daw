package Recuperacion_1.TicketMutxa;

import java.time.LocalDate;

public class Concierto extends Evento {
    private String artista;

    public Concierto(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
