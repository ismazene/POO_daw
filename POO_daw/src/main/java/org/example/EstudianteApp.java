package org.example;

public class EstudianteApp {

    public static void main(String[] args) {

        Estudiante jorge = new Estudiante("jorge","1DAM","jorge@iesmutxamel.com");

        System.out.println(jorge.getNia());
        System.out.println(jorge);

        Estudiante raul = new Estudiante("raul");

        System.out.println(raul.getNia());
        System.out.println(raul);

        Estudiante adrian = new Estudiante("adrian");

        System.out.println("Hay " + Estudiante.obtenerTotalEstudiantes() + " estudiantes.");

        System.out.println(Estudiante.validarCorreo("patri@mutxamel.com"));
        System.out.println(Estudiante.validarCorreo("patri@alu.edu.gva.es"));

        Libro divina_comedia = new Libro("divina comedia","dante ali");

        System.out.println(divina_comedia);

        divina_comedia.prestar(jorge);


        System.out.println(divina_comedia.estaDisponible());

        System.out.println(divina_comedia);

        System.out.println("Libros disponibles: " + Libro.getLibrosDisponibles());
        System.out.println("Libros creados: " + Libro.getTotalLibros());

        divina_comedia.devolver();
        divina_comedia.devolver();

        System.out.println(divina_comedia.estaDisponible());

        System.out.println(divina_comedia);








    }

}