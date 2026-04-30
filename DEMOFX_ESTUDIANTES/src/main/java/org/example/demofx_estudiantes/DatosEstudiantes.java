package org.example.demofx_estudiantes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class DatosEstudiantes {

    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3307/";
        String user = "root";
        String psw = "";
        String bd = "instituto";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectar(Connection conexion){

        System.out.println("Desconectando...");

        try {
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Estudiante> consulta (Connection conexion){

        ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

        String query = "SELECT * FROM estudiante";

        //necesitamos dos variables de tipo Statement y ResultSet para realizar la consulta y guardar la respuesta
        Statement stmt;
        ResultSet respuesta;

        try {
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()){ //recorremos todas las filas existentes en la tabla y las imprimimos
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                LocalDate fecha_nacimiento = respuesta.getDate("fecha_nacimiento").toLocalDate();
                listaEstudiantes.add(new Estudiante(nia,nombre,fecha_nacimiento));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return listaEstudiantes;
    }

    public static void guardar(Connection conexion, Estudiante estudiante){

        String query = "UPDATE estudiante set nia = '" + estudiante.getNia() + "', nombre = '" + estudiante.getNombre() + "'," +
                "fecha_nacimiento = '" + estudiante.getFecha_nacimiento() + "' WHERE nia = '" + estudiante.getNia() + "'";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static boolean insertar(Connection conexion, Estudiante estudiante){
        //INSERT INTO `estudiante` (`nia`, `nombre`, `fecha_nacimiento`) VALUES (1234, 'Patricia', '2026-04-20');

        String query = "INSERT INTO estudiante VALUES (" + estudiante.getNia() + ",'" + estudiante.getNombre()+ "','" +  estudiante.getFecha_nacimiento() + "')";
        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
            return  true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void borrar(Connection connection, Estudiante estudiante) {
        String query = "DELETE FROM estudiante WHERE nia = '" + estudiante.getNia() + "'";

        Statement stmt;

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
