package PracticoModeloB;

public class Premio extends MutxaAwards{
    private Categoria categoria;
    private Artista ganador;

    public Premio(int anyo, Categoria categoria) {
        super(anyo);
        this.categoria = categoria;
    }

    public Premio(int anyo, Categoria categoria, Artista ganador) {
        super(anyo);
        this.categoria = categoria;
        this.ganador = ganador;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Artista getGanador() {
        return ganador;
    }

    public void setGanador(Artista ganador) {
        this.ganador = ganador;
    }

    @Override
    public void obtenerDetalles() {
        String nombreGanador = ganador != null ? ganador.getNombre() : "pendiente";
        System.out.println("Premio: " + categoria + " | Edicion: " + getAnyo() + " | Ganador: " + nombreGanador);
    }
}
