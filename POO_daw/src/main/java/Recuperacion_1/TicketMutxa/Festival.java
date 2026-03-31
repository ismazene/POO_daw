package Recuperacion_1.TicketMutxa;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Festival extends Evento {
    private Set<String> listaArtistas;

    public Festival(String nombre, LocalDate fecha, double precio) {
        super(nombre, fecha, precio);
        this.listaArtistas = new LinkedHashSet<>();
    }

    public Set<String> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(Set<String> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
}
