package org.example.demofx_estudiantes;

import java.time.LocalDate;

public class Estudiante {
    private Integer NIA;
    private String nombre;
    private LocalDate fecha_nacimiento;

    public Estudiante(Integer NIA, String nombre, LocalDate fecha_nacimiento) {
        this.NIA = NIA;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getNIA() {
        return NIA;
    }

    public void setNIA(int NIA) {
        this.NIA = NIA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "NIA=" + NIA +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                '}';
    }
}
