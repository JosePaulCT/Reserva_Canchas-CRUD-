package org.example.Modelo;

public class Reserva {
    private static Reserva instancia = null;

    public static Reserva getInstancia() {
        if (instancia == null) {
            instancia = new Reserva();
        }
        return instancia;
    }

    private String deporte;
    private int horaI;
    private int minutos;
    private String turno;
    private int duracion;

    public Reserva() {
    }

    public Reserva(String deporte, int horaI, int minutos, String turno, int duracion) {
        this.deporte = deporte;
        this.horaI = horaI;
        this.minutos = minutos;
        this.turno = turno;
        this.duracion = duracion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getHoraI() {
        return horaI;
    }

    public void setHoraI(int horaI) {
        this.horaI = horaI;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getHoraF(int horaI, int duracion) {
        return horaI + duracion;
    }

    public String getTurnoF(int horaF,int duracion) {
        if ( horaF >= 10 && duracion > 0) {
            return "pm";
        } else {
            return "am";
        }
    }

}
