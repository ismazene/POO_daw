package org.example;

public class PacienteAPP {
    public static void main(String[] args) {
        // Constructor por defecto
        Paciente patri = new Paciente();
        System.out.println("Paciente patri:" + patri.mostrarInfoPaciente());
        System.out.println("");

        // Constructor con todos los atributos
        Paciente ana = new Paciente("Ana", 25, 'M', 60, 165);
        System.out.println("Paciente Ana:" + ana.mostrarInfoPaciente());
    }
}
