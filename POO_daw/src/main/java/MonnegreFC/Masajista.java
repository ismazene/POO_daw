package MonnegreFC;

public class Masajista extends MonnegreFC implements FuncionesIntegrantes{
    private String titulacion;
    private int anosExperiencia;

    /**
     * Crea un masajista con su titulacion y experiencia.
     *
     * @param nombre nombre del masajista
     * @param edad edad del masajista
     * @param titulacion titulacion profesional
     * @param anosExperiencia años de experiencia
     */
    public Masajista(String nombre, int edad, String titulacion, int anosExperiencia) {
        super(nombre, edad);
        this.titulacion = titulacion;
        this.anosExperiencia = anosExperiencia;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public void darMasaje(Jugador jugador){
        System.out.println("El masajista le esta haciendo un masaje al jugador");
    }

    @Override
    public void concentrarse() {
        System.out.println("El masajista se esta concentrando");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println("El masajista esta viajando con el equipo");

    }

    @Override
    public void celebrarGol() {
        System.out.println("El jugador esta celebrando el golazo");

    }
}
