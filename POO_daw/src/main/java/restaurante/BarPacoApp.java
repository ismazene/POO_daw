package restaurante;

import java.util.ArrayList;

public class BarPacoApp {
    static void main() {
         Camarero pepe = new Camarero("Pepe", "12345678A", 1234.89);
         pepe.mostrarInfoPersona();

         Cliente Ismael = new Cliente("Ismael", "12345678B", 5, 3);
         Ismael.mostrarInfoPersona();

         Encargado izan = new Encargado("Izan", "8765321A", 1234.89);
         izan.mostrarInfoPersona();

         Persona patri = new Encargado("Patricia", "32165487A", 49034);

        ArrayList<Persona> listaPersonal = new ArrayList<>();

        listaPersonal.add(patri);
        listaPersonal.add(izan);
        System.out.println(listaPersonal);
    }

    public static void entrarBar(Persona persona){
        System.out.println("Holaa a todos");
    }
}
