package PracticoModeloB;

import java.util.ArrayList;
import java.util.List;

public class Artista extends MutxaAwards implements AccionesAsistentes {
    private String nombre;
    private final List<Premio> listaPremios = new ArrayList<>();
    private final List<Categoria> listaCategorias = new ArrayList<>();

    public Artista(int anyo, String nombre) {
        super(anyo);
        this.nombre = nombre;
    }

    public void esNominado(Categoria categoria){
        if (!listaCategorias.contains(categoria)) {
            listaCategorias.add(categoria);
        }
        System.out.println("El artista " + nombre + " es nominado a " + categoria);
    }
    public void ganarPremio(Premio premio){
        listaPremios.add(premio);
        System.out.println("El artista nominado " + nombre + " ha ganado el premio a " + premio.getCategoria());
    }
    public void recogerPremio(Premio premio){
        if (premio.getGanador() != this) {
            // Aqui salta el error de la excepcion si quiere recoger algo que no ha ganado
            throw new PremioNoGanado();
        }
        System.out.println("El artista " + nombre + " recoge el premio " + premio.getCategoria());
    }

    public void mostrarDetalles() {
        System.out.println("Artista: " + nombre + " | Edicion: " + getAnyo());
        System.out.println("Categorias nominadas: " + listaCategorias);
        if (listaPremios.isEmpty()) {
            System.out.println("Premios ganados: ninguno");
        } else {
            System.out.println("Premios ganados:");

            //Mostrar premios y aur
            for (Premio premio : listaPremios) {
                System.out.println("- " + premio.getCategoria());
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void obtenerDetalles() {
        mostrarDetalles();
    }

    @Override
    public void aplaudir() {
        System.out.println(nombre + " aplaude");
    }

    @Override
    public void alfombraRoja() {
        System.out.println(nombre + " desfila por la alfombra roja");
    }

    @Override
    public void darDiscurso(String tematica) {
        System.out.println(nombre + " da un discurso: " + tematica);
    }

    @Override
    public void celebrarPremio(String premio) {
        System.out.println(nombre + " celebra el premio " + premio);
    }
}
