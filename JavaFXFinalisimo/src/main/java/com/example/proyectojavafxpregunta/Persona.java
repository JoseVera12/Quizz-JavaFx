package com.example.proyectojavafxpregunta;

public class Persona {
    private String nombre;
    private int puntos;

    public Persona() {
    }

    public Persona(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", puntos=" + puntos +
                '}';
    }

    public static void sumarPuntos(Persona p1) {
        p1.puntos += 30;
    }
}
