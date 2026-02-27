package PracticoModeloB;

public abstract class MutxaAwards {
    private int anyo;

    public MutxaAwards(int anyo) {
        this.anyo = anyo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public abstract void obtenerDetalles();
}
