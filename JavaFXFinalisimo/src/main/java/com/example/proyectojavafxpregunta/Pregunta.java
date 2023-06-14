package com.example.proyectojavafxpregunta;

public class Pregunta {

    private int id;
    private String pregunta;

    public Pregunta() {
    }

    Pregunta(int id, String pregunta) {
        this.id = id;
        this.pregunta = pregunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", pregunta='" + pregunta + '\'' +
                '}';
    }
}
