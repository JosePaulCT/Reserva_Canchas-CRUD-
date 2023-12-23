package org.example.AccesoDatos;

import org.example.Modelo.User;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUser implements IDAOUser {
    @Override
    public Boolean buscar(String codigo, String contraseña) {
        try {
            Statement conexion = Conexion.getInstancia().getConexion().createStatement();
            ResultSet registros = conexion.executeQuery(
                    "SELECT * FROM estudiantes WHERE codigoEstudiante =" + "'" + codigo + "'"
                            + "AND contraseña =" + "'"
                            + contraseña + "'");
            if (registros.next()) {
                User.getInstancia().setCodigo(registros.getString("codigoEstudiante"));
                User.getInstancia().setNombre(registros.getString("Nombres"));
                User.getInstancia().setContraseña(registros.getString("contraseña"));
                User.getInstancia().setApellidos(registros.getString("apellidos"));
            }
            registros.close();
            return User.getInstancia().getCodigo() != null;

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }


}
