package org.example.Controlador;

import javax.swing.table.DefaultTableModel;

import org.example.AccesoDatos.DAOReserva;
import org.example.AccesoDatos.DAOUser;
import org.example.Modelo.Reserva;
import org.example.Modelo.User;

import java.util.ArrayList;

public class UserController {
    private static UserController instance;

    private UserController() {
    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public Boolean buscar(String codigo, String contraseña) {
        DAOUser daoUser = new DAOUser();
        return daoUser.buscar(codigo, contraseña);
    }

    public void mostrarTabla(DefaultTableModel model) {
        DAOReserva daoReserva = new DAOReserva();
        daoReserva.mostrarTablaUser(model);
    }

    public Boolean guardarReserva(String deporte, int horaI, int minutos, String turno, int duracion, DefaultTableModel model) {
        DAOReserva daoReserva = new DAOReserva();
        daoReserva.listarReserva();
        ArrayList<Reserva> reservas = daoReserva.listarReserva();

        // Verificar que la reserva esté dentro del rango
        if (horaI < 1 || horaI > 20 || (horaI == 20 && minutos > 0) || (horaI + duracion > 20)) {
            return false;  // Fuera del rango permitido
        }

        // Verificar duplicados y superposición
        for (Reserva reserva : reservas) {
            if (reserva.getDeporte().equals(deporte) && reserva.getTurno().equals(turno)) {
                if ((horaI >= reserva.getHoraI() && horaI < reserva.getHoraF(reserva.getHoraI(), reserva.getDuracion())) ||
                        (reserva.getHoraI() >= horaI && reserva.getHoraI() < horaI + duracion)) {
                    return false;  // Superposición detectada
                }
            }
        }

        User.getInstancia().crearReserva(deporte, horaI, minutos, turno, duracion);
        daoReserva.guardarReserva(Reserva.getInstancia(), User.getInstancia());
        daoReserva.agregarReservaTabla(model);
        return true;
    }






}
