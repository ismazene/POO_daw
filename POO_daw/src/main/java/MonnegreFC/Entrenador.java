package MonnegreFC;

import java.util.ArrayList;

public class Entrenador extends MonnegreFC implements AccionesDeportivas, FuncionesIntegrantes {
    public static ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();

    private Equipos equipo;
    private String formacionPreferida;

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

    public void setFormacionPreferida(String formacionPreferida) {
        formatoFormacion(formacionPreferida);
    }

    public void planificarEntrenamiento(){
        System.out.println("El entrenador esta planiicando el entrenamiento");
    }

    public void hacerCambios(){
        System.out.println("El entrenador esta haciendo cambios");
    }

    public void formatoFormacion(String formacionPreferida){

        if (formacionPreferida.matches("\\d-\\d-\\d")){
            this.formacionPreferida = formacionPreferida;

        } else {
            throw new FormatoFormacion();
        }
    }

    @Override
    public void concentrarse() {

    }

    @Override
    public void viajar(String ciudad) {

    }

    @Override
    public void celebrarGol() {

    }

    @Override
    public void entrenar() {

    }

    @Override
    public void jugarPartidos(String rival) {

    }
}
