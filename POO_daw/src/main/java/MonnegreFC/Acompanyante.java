package MonnegreFC;

import java.util.ArrayList;

public class Acompanyante extends MonnegreFC implements FuncionesIntegrantes{
    public static ArrayList<Acompanyante> listaAcompanyantes = new ArrayList<>();

    private Jugador integrante;
    private String parentesco;

    public Acompanyante(String nombre, int edad, Jugador integrante, String parentesco) {
        super(nombre, edad);
        this.integrante = integrante;
        this.parentesco = parentesco;
        this.listaAcompanyantes = new ArrayList<>();
    }

    public Jugador getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Jugador integrante) {
        this.integrante = integrante;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public void animarEquipo(){
        System.out.println("Como anima la grada por diossss");
    }

    @Override
    public void concentrarse() {
        System.out.println("El acompañante se esta concentrando");
    }

    @Override
    public void viajar(String ciudad) {
        System.out.println("El acompañante esta viajando");
    }
    @Override
    public void celebrarGol() {
        System.out.println("El acompañante celebra el golazooo");

    }

    @Override
    public String toString() {
        return "Acompanyante{" +
                "integrante=" + integrante +
                ", parentesco='" + parentesco + '\'' +
                '}';
    }
}
