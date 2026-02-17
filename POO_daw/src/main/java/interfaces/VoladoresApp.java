package interfaces;

import java.util.ArrayList;

public class VoladoresApp {
    static void main() {
        Superman clark_kent = new Superman();
        Avion boing = new Avion();

        clark_kent.volar();
        boing.volar();

        clark_kent.ojos_laser();
        clark_kent.saltar();
        clark_kent.hielo();

        ArrayList<Superheroe> listaHeroes = new ArrayList<>();
        listaHeroes.add(clark_kent);
        listaHeroes.add(new Spiderman());

        for (Superheroe superheroe: listaHeroes) {
            if (superheroe instanceof Superman){
                ((Superman) superheroe).ojos_laser();
            }
        }
    }
}
