package com.example.proyectojavafxpregunta;

public class Respuesta {

    private int id;
    private String respuesta;
    private int id_pregunta;

    Respuesta(int id, String respuesta, int id_pregunta) {
        this.id = id;
        this.respuesta = respuesta;
        this.id_pregunta = id_pregunta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getId() {
        return id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "id=" + id +
                ", respuesta='" + respuesta + '\'' +
                ", id_pregunta=" + id_pregunta +
                '}';
    }
}
