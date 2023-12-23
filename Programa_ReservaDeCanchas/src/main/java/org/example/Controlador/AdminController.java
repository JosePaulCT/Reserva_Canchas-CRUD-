package org.example.Controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.example.AccesoDatos.DAOAdmin;
import org.example.AccesoDatos.DAOReserva;

public class AdminController {
    private static AdminController instance;

    private AdminController() {
    }

    public static AdminController getInstance() {
        if (instance == null) {
            instance = new AdminController();
        }
        return instance;
    }

    public Boolean buscar(String codigo, String contraseña) {
        DAOAdmin daoAdmin = new DAOAdmin();
        return daoAdmin.buscar(codigo, contraseña);
    }

    public void eliminarReserva(DefaultTableModel model, JTable jtxtTabla) {
        int filaSeleccionada = jtxtTabla.getSelectedRow();
        jtxtTabla.setEditingRow(0);
        String fechaReserva = jtxtTabla.getValueAt(filaSeleccionada, 4).toString();
        model.removeRow(filaSeleccionada);
        DAOReserva daoReserva = new DAOReserva();
        daoReserva.eliminarReserva(fechaReserva);
    }

    public void mostrarTabla(DefaultTableModel model) {
        DAOReserva daoReserva = new DAOReserva();
        daoReserva.mostrarTablaAdmin(model);
    }
}
