package org.example;

public class Persona {
    private String nombre;
    private String DNI;
    private int edad;
    private String ciudad;
    private String profesion;



    public Persona(String nombre, String DNI, int edad, String ciudad, String profesion) {

        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;

    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        nombre = this.nombre;
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProfesion() {
        return profesion;
    }
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}

