package MonnegreFC;

import java.util.ArrayList;


public class Jugador extends MonnegreFC implements AccionesDeportivas, FuncionesIntegrantes {
  public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private Equipos categoria;
    private int dorsal;
    private Posiciones Posicion;

    /**
     * Crea un jugador
     *
     * @param nombre nombre del jugador
     * @param edad edad del jugador
     * @param categoria categoria del jugador
     * @param dorsal numero de dorsal
     * @param posicion posicion del jugador
     */
    public Jugador(String nombre, int edad, Equipos categoria, int dorsal, Posiciones posicion) {
        super(nombre, edad);
        this.categoria = categoria;
        compararDorsal(dorsal);
        Posicion = posicion;
    }

    public Equipos getCategoria() {
        return categoria;
    }

    public void setCategoria(Equipos categoria) {
        this.categoria = categoria;
    }

    public int getDorsal() {
        return dorsal;
    }

    /**
     * Aqui es donde validamos el dorsal de los jugadores
     *
     * @param dorsal nuevo dorsal
     */
    public void setDorsal(int dorsal) {
        compararDorsal(dorsal);
    }

    public Posiciones getPosicion() {
        return Posicion;
    }

    public void setPosicion(Posiciones posicion) {
        Posicion = posicion;
    }

    /**
     * Simula el calentamiento
     */
    public void calentar(){
        System.out.println("El jugador esta calentando");
    }

    /**
     * Simula el descanso
     */
    public void descansar(){
        System.out.println("El jugador esta descansando");
    }

    /**
     * Simula que el jugador marca un gol.
     */
    public void marcarGol(){
        System.out.println("El jugador ha metido gol");
    }

    /**
     * Valida que el dorsal no este repetido en la misma categoria
     *
     * @param dorsal dorsal
     */
    public void compararDorsal(int dorsal){
        for (Jugador jugador: listaJugadores) {
            if (jugador.getDorsal() == dorsal && jugador.getCategoria().equals(categoria)){
                throw new ModificarJugador();
            }
        }
        this.dorsal = dorsal;
    }

    @Override
    public void concentrarse() {
        System.out.println("El jugador esta concentrando");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println("El jugador esta viajando con el equipo");
    }

    @Override
    public void celebrarGol() {
        System.out.println("CELEBRANDO EL GOL OLEEEEE");
    }

    @Override
    public void entrenar() {
        System.out.println("El jugador esta entrenando");

    }

    @Override
    public void jugarPartidos(String rival) {
        System.out.println("El jugador esta jugando partidos");
    }

    /**
     * El toString pa verlo todo bonito
     *
     * @return informacion del jugador
     */
    @Override
    public String toString() {
        return  "Nombre: " + getNombre() +
                ", Edad: " + getEdad() +
                ", Categoría " + categoria +
                ", Dorsal: " + dorsal +
                ", Posicion: " + Posicion;
    }
}
