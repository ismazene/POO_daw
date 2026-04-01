package Recuperacion_1.Squash;

import java.util.List;

public class ResultadoPartido {
    private int setsA;
    private int setsB;
    private int puntosActualesA;
    private int puntosActualesB;
    private List<String> setsTerminados;

    public ResultadoPartido(int setsA, int setsB, int puntosActualesA, int puntosActualesB, List<String> setsTerminados) {
        this.setsA = setsA;
        this.setsB = setsB;
        this.puntosActualesA = puntosActualesA;
        this.puntosActualesB = puntosActualesB;
        this.setsTerminados = setsTerminados;
    }

    public void mostrarResumen() {
        System.out.println("Sets ganados A: " + setsA);
        System.out.println("Sets ganados B: " + setsB);
        System.out.println("Sets cerrados: " + setsTerminados);
        System.out.println("Set actual/parcial: " + puntosActualesA + "-" + puntosActualesB);
    }
}
