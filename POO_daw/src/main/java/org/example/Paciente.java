package org.example;

import java.util.Random;

public class Paciente {

    private static final char DEF_SEXO = 'X';
    private static final int INFRAPESO = -1;
    private static final int PESO_IDEAL = 0;
    private static final int SOBREPESO = 1;
    private static final int MAYOR_EDAD = 18;

    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private int altura;

    private Random aleatorio = new Random();

    public Paciente(String nombre, int edad, char sexo, double peso, int altura) {
        this.nombre = (nombre != null) ? nombre : "";
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.dni = generarDNI();
    }

    public Paciente() {
        this("", 0, DEF_SEXO, 0, 0);
    }

    public Paciente(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getDni() {
        return dni;
    }

    private String generarDNI() {
        String dniNum = "";
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        for (int i = 0; i < 8; i++) {
            dniNum += aleatorio.nextInt(10);
        }

        int resto = Integer.parseInt(dniNum) % 23;
        return dniNum + letras[resto];
    }

    private char comprobarSexo(char sexo) {
        if (sexo == 'H' || sexo == 'M') {
            return sexo;
        } else {
            return DEF_SEXO;
        }
    }


    public int calcularIMC() {
        if (altura <= 0) return PESO_IDEAL;
        double resultado = peso / Math.pow(altura / 100.0, 2);
        if (resultado < 20) return INFRAPESO;
        else if (resultado > 25) return SOBREPESO;
        else return PESO_IDEAL;
    }

    public boolean esMayorEdad() {
        return edad >= MAYOR_EDAD;
    }

    public String mostrarInfoPaciente() {
        return "Nombre: " + nombre + "" + "Edad: " + edad + "" + "Sexo: " + sexo + "DNI: " + dni + "Peso: " + peso + " kg" + "Altura: " + altura + " cm" + "IMC: " + calcularIMC() + "Mayor de edad: " + esMayorEdad();
    }
}
