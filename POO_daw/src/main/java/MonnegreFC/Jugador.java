package MonnegreFC;

import java.util.ArrayList;

public class Jugador extends MonnegreFC implements AccionesDeportvas{
  public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private Equipos categoria;
    private int dorsal;
    private Posiciones Posicion;

    public Jugador(String nombre, int edad, Equipos categoria, int dorsal, Posiciones posicion) {
        super(nombre, edad);
        this.categoria = categoria;
        this.dorsal = dorsal;
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

//    public void setDorsal(int dorsal) {
//        if (this.dorsal == dorsal){
//            System.err.println("");
//        }
//    }

    public Posiciones getPosicion() {
        return Posicion;
    }

    public void setPosicion(Posiciones posicion) {
        Posicion = posicion;
    }

    public void calentar(){
        System.out.println("El jugador esta calentando");
    }
    public void descansar(){
        System.out.println("El jugador esta descansando");
    }
    public void marcarGol(){
        System.out.println("El jugador ha metido gol");
    }

//    public void compararDorsal(int dorsal){
//        for (Jugador jugador: ) {
//
//        }
//    }
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

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre=" + getNombre() +
                "edad=" + getEdad() +
                "categoria=" + categoria +
                ", dorsal=" + dorsal +
                ", Posicion=" + Posicion +
                '}';
    }
}
