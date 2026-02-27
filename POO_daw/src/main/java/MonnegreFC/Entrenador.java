package MonnegreFC;

import java.util.ArrayList;

public class Entrenador extends MonnegreFC implements AccionesDeportivas, FuncionesIntegrantes {
    public static ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();

    private Equipos equipo;
    private String formacionPreferida;

    /**
     * Crea un entrenador con su equipo y formacion.
     *
     * @param nombre nombre del entrenador
     * @param edad edad del entrenador
     * @param equipo equipo del mister
     * @param formacionPreferida pues la formacion que mas le gusta
     */
    public Entrenador(String nombre, int edad, Equipos equipo, String formacionPreferida) {
        super(nombre, edad);
        this.equipo = equipo;
        formatoFormacion(formacionPreferida);
    }


    public Equipos getEquipo() {
        return equipo;
    }


    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }


    public String getFormacionPreferida() {
        return formacionPreferida;
    }

    /**
     * Aqui se valida el formato del la formacion
     *
     * @param formacionPreferida nueva formacion
     */
    public void setFormacionPreferida(String formacionPreferida) {
        formatoFormacion(formacionPreferida);
    }

    /**
     * Simula la planificacion de un entrenamiento.
     */
    public void planificarEntrenamiento(){
        System.out.println("El entrenador esta planiicando el entrenamiento");
    }

    /**
     * Simula cambios en un partido.
     */
    public void hacerCambios(){
        System.out.println("El entrenador esta haciendo cambios");
    }

    /**
     * Valida el formato de formacion.
     *
     * @param formacionPreferida formacion a validar
     */
    public void formatoFormacion(String formacionPreferida){

        if (formacionPreferida.matches("\\d-\\d-\\d")){
            this.formacionPreferida = formacionPreferida;

        } else {
            throw new FormatoFormacion();
        }
    }

    @Override
    public void concentrarse() {
        System.out.println("El mister se concentra");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println("El mister viaja");
    }

    @Override
    public void celebrarGol() {
        System.out.println("Golzado dice el mister");
    }

    @Override
    public void entrenar() {
        System.out.println("El entrenador entrena al equipo :)");
    }

    @Override
    public void jugarPartidos(String rival) {
        System.out.println("El entrenador quiere salir a jugar el...");
    }
}
