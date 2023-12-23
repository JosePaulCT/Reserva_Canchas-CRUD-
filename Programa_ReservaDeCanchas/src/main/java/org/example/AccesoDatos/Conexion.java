package org.example.AccesoDatos;

import java.sql.*;


public class Conexion {
    private static Conexion instancia = null;
    private static Connection conexion = null;


    public static  Connection getConexion() {
        return conexion;
    }

    private static String urlConexion = "jdbc:sqlite:C:\\Users\\Santiago\\Desktop\\TrabajoFinal\\Programa_ReservaDeCanchas\\src\\main\\java\\org\\example\\BaseDeDatos\\reserva.db";

    public Conexion(){
        try {
            conexion = DriverManager.getConnection(urlConexion);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Conexion getInstancia(){
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}

