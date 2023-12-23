package org.example.Modelo;

public class Person {
    private String nombre;
    private String codigo;
    private String contraseña;

    public Person() {
    }

    public Person(String nombre, String codigo, String contraseña) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Person [nombre=" + nombre + ", codigo=" + codigo + ", contraseña=" + contraseña + "]";
    }

}