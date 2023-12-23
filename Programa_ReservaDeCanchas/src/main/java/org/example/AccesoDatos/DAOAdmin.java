package org.example.AccesoDatos;

import org.example.Modelo.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOAdmin implements IDAOAdmin {
    @Override
    public Boolean buscar(String codigo, String contraseña) {
        try {
            Statement conexion = Conexion.getInstancia().getConexion().createStatement();
            ResultSet registros = conexion.executeQuery(
                    "SELECT * FROM Administrador WHERE Codigo =" + "'" + codigo + "'"
                            + "AND contrasenia =" + "'"
                            + contraseña + "'");
            if (registros.next()) {
                Admin.getInstancia().setCodigo(registros.getString("Codigo"));
                Admin.getInstancia().setNombre(registros.getString("Nombres"));
                Admin.getInstancia().setContraseña(registros.getString("contrasenia"));
            }
            registros.close();
            return Admin.getInstancia().getCodigo() != null;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

}