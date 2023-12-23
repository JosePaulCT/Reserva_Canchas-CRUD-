package org.example.AccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.example.Modelo.Reserva;
import org.example.Modelo.User;

public class DAOReserva {

    public ArrayList<Reserva> listarReserva() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String query = "SELECT * FROM reserva";

        try (PreparedStatement pstmt = Conexion.getInstancia().getConexion().prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String deporte = rs.getString("deporte");
                int horaI = rs.getInt("horaI");
                int minutos = rs.getInt("minutos");
                String turno = rs.getString("turno");
                int duracion = rs.getInt("duracion");
                Reserva reserva = new Reserva(deporte, horaI, minutos, turno, duracion);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public Object guardarReserva(Reserva reserva, User usuario) {

        try {
            Calendar calendario = Calendar.getInstance();
            PreparedStatement comando = Conexion.getInstancia().getConexion()
                    .prepareStatement("INSERT INTO reserva VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?);");
            comando.setString(2, usuario.getCodigo());
            comando.setString(3, usuario.getNombre());
            comando.setString(4, usuario.getApellidos());
            comando.setString(5, reserva.getDeporte());
            comando.setInt(6, reserva.getHoraI());
            comando.setInt(7, reserva.getMinutos());
            comando.setString(8, reserva.getTurno());
            comando.setInt(9, reserva.getDuracion());
            comando.setInt(10, reserva.getHoraF(reserva.getHoraI(), reserva.getDuracion() ));
            comando.setString(11, calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE) + ":"
                    + calendario.get(Calendar.SECOND));
            comando.setString(12, reserva.getTurnoF(reserva.getHoraF(reserva.getHoraI(), reserva.getDuracion()),reserva.getDuracion()));
            comando.executeUpdate();
            comando.closeOnCompletion();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void eliminarReserva(String fechaReserva) {
        try {
            PreparedStatement eliminarReserva = Conexion.getInstancia().getConexion().prepareStatement(
                    "DELETE FROM reserva WHERE HoraReserva = ?");
            eliminarReserva.setString(1, fechaReserva);
            eliminarReserva.executeUpdate();
            eliminarReserva.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void agregarReservaTabla(DefaultTableModel model) {
        String codigo;
        String deporte;
        String reserva;

        try {
            // Modifico la consulta para obtener el último registro sin tener en cuenta la fecha de reserva.
            String query = "SELECT Codigo, deporte, horaI || ' : ' || minutos || ' ' || turno || ' - ' || horaF || ' : ' || minutos || ' ' || turnoF as Reserva  FROM reserva ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = Conexion.getInstancia().getConexion().prepareStatement(query);

            ResultSet registros = statement.executeQuery();

            while (registros.next()) {
                codigo = registros.getString(1);
                deporte = registros.getString(2);
                reserva = registros.getString(3);
                model.addRow(new Object[]{codigo, deporte, reserva});
            }

            registros.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void mostrarTablaAdmin(DefaultTableModel model) {
        String codigo;
        String nombres;
        String deporte;
        String reserva;
        String horaReserva;
        String facultad;

        try {
            ResultSet registros = Conexion.getInstancia().getConexion().createStatement().executeQuery(
                    "SELECT r.Codigo, r.nombre || ' ' || r.apellido as Nombre_Completos, r.deporte, r.horaI || ' : ' || r.minutos || ' ' || r.turno || ' - ' || r.horaF || ' : ' || r.minutos || ' ' || r.turnoF as Reserva, HoraReserva, e.facultad from reserva r INNER JOIN estudiantes e ON (e.codigoEstudiante == r.Codigo) ORDER by Nombre_Completos");
            while (registros.next()) {
                codigo = registros.getString(1);
                nombres = registros.getString(2);
                deporte = registros.getString(3);
                reserva = registros.getString(4);
                horaReserva = registros.getString(5);
                facultad = registros.getString(6);
                model.addRow(new Object[] { codigo, nombres, deporte, reserva, horaReserva, facultad });
            }
            registros.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarTablaUser(DefaultTableModel model) {
        String codigo;
        String deporte;
        String reserva;

        try {
            ResultSet registros = Conexion.getInstancia().getConexion().createStatement().executeQuery(
                    "SELECT Codigo, deporte, horaI || ' : ' || minutos || ' ' || turno || ' - ' || horaF || ' : ' || minutos || ' ' || turnoF as Reserva FROM reserva");
            while (registros.next()) {
                codigo = registros.getString(1);
                deporte = registros.getString(2);
                reserva = registros.getString(3);
                model.addRow(new Object[] { codigo, deporte, reserva });
            }
            registros.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}