package org.example;

public class TelevisorAPP {
    private int canal;
    private int volumen;

    private final int DEF_CANAL = 1;
    private final int DEF_VOLUMEN = 5;

    public TelevisorAPP(int canal, int volumen) {
        this.canal = canal;
        this.volumen = volumen;
    }
    public TelevisorAPP(){
        //Estos son las variables iniciales
        volumen = DEF_VOLUMEN;
        canal = DEF_CANAL;
    }

    public int getVolumen() {
        return volumen;
    }
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getCanal() {
        return canal;
    }
    public void setCanal(int canal) {
        this.canal = canal;
    }

    public void subirCanal(){
        if (canal == 100){
            canal = 1;
        }else{
          canal = canal + 1;
        }
    }
    public void bajarCanal(){
        if (canal == 0){
            canal = 100;
        } else {
            canal = canal - 1;
        }
    }

    public void subirVolumen(){
        if (volumen == 100){
            volumen = 100;
        }else{
            volumen = volumen + 1;
            System.out.println("El volumen es: " + volumen );

        }

    }
    public void bajarVolumen(){
        if (volumen == 0) {
            volumen = 0;
        } else {
            volumen = volumen - 1;
            System.out.println("El volumen es: " + volumen );


        }
    }

    public void cambiarCambiar (int canal){
        this.canal = canal;
    }
}
