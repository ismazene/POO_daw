package org.example;

public class PersonaApp {
    static void main() {
        Persona profe = new Persona("Patricia", "10000000A", 50, "Ciudad","Profesion" );
        System.out.println(profe.getEdad());

        Persona alum = new Persona();
        System.out.println(alum.getDNI());
        alum.setDNI("10000000X");
        System.out.println(alum.getDNI());

    }
}
