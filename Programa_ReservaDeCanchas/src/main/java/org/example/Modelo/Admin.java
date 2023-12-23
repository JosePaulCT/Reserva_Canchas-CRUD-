package org.example.Modelo;

public class Admin extends Person {
    private static Admin instancia = null;

    public static Admin getInstancia() {
        if (instancia == null) {
            instancia = new Admin();
        }
        return instancia;
    }

    public Admin() {
        super();
    }

    public Admin(String codigo, String nombre, String contraseña) {
        super(codigo, nombre, contraseña);
    }

    @Override
    public String getCodigo() {

        return super.getCodigo();
    }

    @Override
    public String getContraseña() {

        return super.getContraseña();
    }

    @Override
    public String getNombre() {

        return super.getNombre();
    }

    @Override
    public void setCodigo(String codigo) {
        super.setCodigo(codigo);
    }

    @Override
    public void setContraseña(String contraseña) {

        super.setContraseña(contraseña);
    }

    @Override
    public void setNombre(String nombre) {

        super.setNombre(nombre);
    }

    @Override
    public String toString() {

        return super.toString();
    }

}
