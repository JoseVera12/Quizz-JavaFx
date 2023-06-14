package com.example.proyectojavafxpregunta;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    private ArrayList<Persona> listaPersonas = new ArrayList<>();

    public BD() {
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "BD{" +
                "listaPersonas=" + listaPersonas +
                '}';
    }

    public static ArrayList<Respuesta> cogerRespuestas(int numPregunta){
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";
        ArrayList<Respuesta> aux = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/testPersonalidad", "root", "");

            sentenciaSQL = conexion.createStatement();

            sql ="SELECT * FROM Respuestas WHERE idPregunta= " + numPregunta;
            rs = sentenciaSQL.executeQuery(sql);
            while (rs.next()) {
                aux.add(new Respuesta(rs.getInt("id"), rs.getString("descripcion"), rs.getInt("idpregunta")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return aux;
    }
    public static Pregunta cogerPregunta(int numero){
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";
        Pregunta p1= new Pregunta();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/testPersonalidad", "root", "");

            sentenciaSQL = conexion.createStatement();

            sql ="SELECT * FROM Preguntas WHERE id= " + numero;
            rs = sentenciaSQL.executeQuery(sql);
            while (rs.next()) {
                p1.setPregunta(rs.getString("descripcion"));
                p1.setId(rs.getInt("id"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // System.out.println("Error");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return p1;
    }
    public static ArrayList<Persona> volcarInfoPersonas(){
        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/testPersonalidad", "root", "");

            sentenciaSQL = conexion.createStatement();

            sql ="SELECT * FROM Personajes";
            rs = sentenciaSQL.executeQuery(sql);
            while (rs.next()) {
                listaPersonas.add(new Persona(rs.getString("nombre"),0));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return listaPersonas;
    }

}
