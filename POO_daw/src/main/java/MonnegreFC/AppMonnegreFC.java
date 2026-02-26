package MonnegreFC;

public class AppMonnegreFC {
    static void main() {
        Jugador Ismael = new Jugador("Ismael", 20, Equipos.SENIOR, 11, Posiciones.DELANTERO);
        Jugador Izan = new Jugador("Izan", 20, Equipos.SENIOR, 8, Posiciones.CENTROCAMPISTA);
        Jugador Jose = new Jugador("Jose", 23, Equipos.SENIOR, 15, Posiciones.DEFENSA);
        Jugador Manuel = new Jugador("Manuel", 26, Equipos.SENIOR, 1, Posiciones.PORTERO);

        // Añadirlos a la lista
        Jugador.listaJugadores.add(Ismael);
        Jugador.listaJugadores.add(Izan);
        Jugador.listaJugadores.add(Jose);
        Jugador.listaJugadores.add(Manuel);

        Entrenador Juan = new Entrenador("Juan", 32, Equipos.SENIOR, "4-3-3");

        Masajista Enrique = new Masajista("Enrique", 26, "Fisioterapetuta", 4);

        Acompanyante Alex = new Acompanyante("Alex", 29, Ismael, "Padre");
        Acompanyante Valentin = new Acompanyante("Valentin", 17, Jose, "Hermano");
        Acompanyante Patri = new Acompanyante("Patri", 27, Izan, "Madre");
        Acompanyante Vicky = new Acompanyante("Vicky", 33, Manuel, "Tia");

        Ismael.concentrarse();
        Ismael.entrenar();
        Enrique.darMasaje(Ismael);
        Ismael.viajar("Madrid");
        Juan.planificarEntrenamiento();
        Ismael.descansar();
        Ismael.calentar();
        Ismael.jugarPartidos("Madrid");

        /// Animar
        Valentin.animarEquipo();
        Alex.animarEquipo();
        Patri.animarEquipo();
        Vicky.animarEquipo();

        Juan.hacerCambios();
        Izan.marcarGol();
        Manuel.celebrarGol();
        Enrique.darMasaje(Izan);
        Enrique.darMasaje(Manuel);
        Enrique.darMasaje(Jose);

        Juan.viajar("Mutxamel");
        Manuel.descansar();


    }
}
