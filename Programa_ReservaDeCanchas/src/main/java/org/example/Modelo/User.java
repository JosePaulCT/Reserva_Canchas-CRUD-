package org.example.Modelo;

public class User extends Person {
    private static User instancia = null;

    public static User getInstancia() {
        if (instancia == null) {
            instancia = new User();
        }
        return instancia;
    }

    public User() {
        super();
    }

    String apellidos;

    public User(String codigo, String nombre, String apellidos, String contraseña) {
        super(nombre, codigo, contraseña);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String getCodigo() {
        // TODO Auto-generated method stub
        return super.getCodigo();
    }

    @Override
    public String getContraseña() {
        // TODO Auto-generated method stub
        return super.getContraseña();
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        return super.getNombre();
    }

    @Override
    public void setCodigo(String codigo) {
        // TODO Auto-generated method stub
        super.setCodigo(codigo);
    }

    @Override
    public void setContraseña(String contraseña) {
        // TODO Auto-generated method stub
        super.setContraseña(contraseña);
    }

    @Override
    public void setNombre(String nombre) {
        // TODO Auto-generated method stub
        super.setNombre(nombre);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public Reserva crearReserva(String deporte, int horaI, int minutos, String turno, int duracion) {
        Reserva.getInstancia().setDeporte(deporte);
        Reserva.getInstancia().setHoraI(horaI);
        Reserva.getInstancia().setMinutos(minutos);
        Reserva.getInstancia().setTurno(turno);
        Reserva.getInstancia().setDuracion(duracion);
        return Reserva.getInstancia();
    }

}
