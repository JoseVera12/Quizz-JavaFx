package com.example.proyectojavafxpregunta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Controlador2 {
    @FXML
    private RadioButton opcion1;

    @FXML
    private RadioButton opcion2;

    @FXML
    private RadioButton opcion3;

    @FXML
    private RadioButton opcion4;
    @FXML
    private Text pregunta;
    @FXML
    private Text textofin;
    @FXML
    private Button terminar;

    @FXML
    private Button botonprinc;
    private ArrayList<Integer> listaId = new ArrayList<>();
    private
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);

    private ArrayList<Persona> personasList = new ArrayList<>();

    @Override
    public String toString() {
        return "Controlador2{" +
                "listaPersonas=" + this.personasList +
                '}';
    }


    @FXML
    void empezar(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPreguntas.fxml"));
        Parent root = loader.load();
        stage.setTitle("Preguntasss");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    public boolean ningunSeleccionado(){
        boolean seleccionado=false;

        if(!opcion1.isSelected() && !opcion2.isSelected() && !opcion3.isSelected() && !opcion4.isSelected()){
            seleccionado=true;
        }else{
            seleccionado=false;
        }
        return seleccionado;
    }
    public boolean multipleSeleccion(){
        int contador=0;
        if(opcion1.isSelected()){
            contador++;
        }
        if(opcion2.isSelected()){
            contador++;
        }
        if(opcion3.isSelected()){
            contador++;
        }
        if(opcion4.isSelected()){
            contador++;
        }
        return contador>1;
    }
    public void sumarPuntaje(String nombre, ArrayList <Persona> listas, int puntos){

        int contador=0;
        boolean encontrado=false;
        while(contador<listas.size() && !encontrado){
            if (listas.get(contador).getNombre().equals(nombre)){
                encontrado=true;
                listas.get(contador).setPuntos(listas.get(contador).getPuntos()+ puntos);
            }else {
                contador++;
            }
        }
    }

    public void rellenarLista(ArrayList<Integer> listaId){
        for (int i = 2; i <= 12; i++) {
            listaId.add(i);
        }
        Collections.shuffle(listaId);
    }
    @FXML
    public void siguiente(){
        if(personasList.size()==0){
            personasList = BD.volcarInfoPersonas();
        }
        if(listaId.size()==0){
            rellenarLista(listaId);
        }
        int idPregunta=listaId.get(0);
        listaId.remove(0);

        if(ningunSeleccionado()){
            alerta.setContentText("Ninguna opcion seleccionada");
            alerta.show();
        }else{
            if(!multipleSeleccion()) {

                pregunta.setText(BD.cogerPregunta(idPregunta).getPregunta());


                opcion1.setText(BD.cogerRespuestas(idPregunta).get(0).getRespuesta());
                opcion2.setText(BD.cogerRespuestas(idPregunta).get(1).getRespuesta());
                opcion3.setText(BD.cogerRespuestas(idPregunta).get(2).getRespuesta());
                opcion4.setText(BD.cogerRespuestas(idPregunta).get(3).getRespuesta());

                if (listaId.size() == 0) {
                    terminar.setDisable(false);
                    botonprinc.setDisable(true);
                }

                sumaPorRespuesta(idPregunta, personasList);


                if (opcion1.isSelected() || opcion2.isSelected() || opcion3.isSelected() || opcion4.isSelected()) {
                    opcion1.setSelected(false);
                    opcion2.setSelected(false);
                    opcion3.setSelected(false);
                    opcion4.setSelected(false);
                }
            }else{
                alerta.setContentText("Solo se puede seleccionar una opción");
                alerta.show();
            }
        }
    }

    public void sumaPorRespuesta(int numero, ArrayList<Persona> listaPersonas){
        //Jose David Robayo
        //Miguel Javi
        //Inma Carlos Antonio Sergio David(profe)
        //System.out.println(listaPersonas.toString());
        switch (numero) {
            case 1:
                if(opcion1.isSelected()){
                    //Jose David Robayo Sergio

                    sumarPuntaje("Jose",listaPersonas, 5);
                    sumarPuntaje("David",listaPersonas, 5);
                    sumarPuntaje("Robayo",listaPersonas, 5);
                    sumarPuntaje("Sergio",listaPersonas,5);
                }else if(opcion2.isSelected()){
                    //Carlos Javi Sergio
                    sumarPuntaje("Carlos",listaPersonas,10);
                    sumarPuntaje("Javi",listaPersonas,5);
                    sumarPuntaje("Sergio",listaPersonas,10);
                }else if(opcion3.isSelected()){
                    //Inma Miguel David(profe)
                    sumarPuntaje("Inma",listaPersonas,15);
                    sumarPuntaje("Miguel",listaPersonas,10);
                    sumarPuntaje("David Joaquin",listaPersonas,5);
                }else if(opcion4.isSelected()){
                    //Carlos Jose Miguel David Antonio
                    sumarPuntaje("Carlos",listaPersonas,10);
                    sumarPuntaje("Jose",listaPersonas,10);
                    sumarPuntaje("Miguel",listaPersonas,10);
                    sumarPuntaje("David",listaPersonas,5);
                    sumarPuntaje("Antonio",listaPersonas,5);
                }
                break;
            case 2:
                if(opcion1.isSelected()){
                    //Jose Inma
                    sumarPuntaje("Jose",listaPersonas,15);
                    sumarPuntaje("Inma",listaPersonas,5);
                    sumarPuntaje("Sergio",listaPersonas,10);
                }else if(opcion2.isSelected()){
                    //Jose David Robayo Antonio
                    sumarPuntaje("Jose",listaPersonas,10);
                    sumarPuntaje("David",listaPersonas,10);
                    sumarPuntaje("Robayo",listaPersonas,20);
                    sumarPuntaje("Antonio",listaPersonas,5);
                }else if(opcion3.isSelected()){
                    //Javi Miguel Sergio
                    sumarPuntaje("Javi",listaPersonas,5);
                    sumarPuntaje("Miguel",listaPersonas,5);
                    sumarPuntaje("Antonio",listaPersonas,5);
                }else if(opcion4.isSelected()){
                    //Carlos Miguel David(profe)
                    sumarPuntaje("Carlos",listaPersonas,20);
                    sumarPuntaje("Miguel",listaPersonas,5);
                    sumarPuntaje("David Joaquin",listaPersonas,10);
                }
                break;
            case 3:
                if(opcion1.isSelected()){
                    //Inma Carlos David(profe)
                    sumarPuntaje("Inma",listaPersonas,15);
                    sumarPuntaje("Carlos",listaPersonas,10);
                    sumarPuntaje("David Joaquin",listaPersonas,5);
                    sumarPuntaje("Miguel",listaPersonas,5);
                }else if(opcion2.isSelected()){
                    //David Carlos Sergio
                    sumarPuntaje("David",listaPersonas,30);
                    sumarPuntaje("Carlos",listaPersonas,10);
                    sumarPuntaje("Sergio",listaPersonas,10);
                }else if(opcion3.isSelected()){
                    //Robayo Jose Antonio
                    sumarPuntaje("Robayo",listaPersonas,25);
                    sumarPuntaje("Jose",listaPersonas,5);
                    sumarPuntaje("Antonio",listaPersonas,5);
                }else if(opcion4.isSelected()){
                    //David Javi Sergio
                    sumarPuntaje("David",listaPersonas,10);
                    sumarPuntaje("Javi",listaPersonas,10);
                    sumarPuntaje("Sergio",listaPersonas,10);
                }
                break;
            case 4:
                if(opcion1.isSelected()){
                    //Javi Inma
                    sumarPuntaje("Javi",listaPersonas,25);
                    sumarPuntaje("Inma",listaPersonas,5);
                }else if(opcion2.isSelected()){
                    //Jose David Robayo Antonio
                    sumarPuntaje("Jose",listaPersonas,10);
                    sumarPuntaje("David",listaPersonas,15);
                    sumarPuntaje("Robayo",listaPersonas,15);
                    sumarPuntaje("Antonio",listaPersonas,5);
                }else if(opcion3.isSelected()){
                    //David(profe) Carlos Sergio
                    sumarPuntaje("David Joaquin",listaPersonas,10);
                    sumarPuntaje("Carlos",listaPersonas,20);
                    sumarPuntaje("Sergio",listaPersonas,20);
                }else if(opcion4.isSelected()){
                    //Inma Miguel
                    sumarPuntaje("Inma",listaPersonas,40);
                    sumarPuntaje("Miguel",listaPersonas,10);
                }
                break;
            case 5:
                if(opcion1.isSelected()){
                    //Sergio Jose
                    sumarPuntaje("Sergio",listaPersonas,25);
                    sumarPuntaje("Jose",listaPersonas,10);
                }else if(opcion2.isSelected()){
                    //Miguel Javi Inma
                    sumarPuntaje("Miguel",listaPersonas,5);
                    sumarPuntaje("Javi",listaPersonas,10);
                    sumarPuntaje("Inma",listaPersonas,5);
                    sumarPuntaje("David Joaquin",listaPersonas,10);
                    sumarPuntaje("Carlos",listaPersonas,20);
                }else if(opcion3.isSelected()){
                    //David Robayo Jose
                    sumarPuntaje("David",listaPersonas,30);
                    sumarPuntaje("Robayo",listaPersonas,30);
                    sumarPuntaje("Jose",listaPersonas,15);
                }else if(opcion4.isSelected()){
                    //Antonio
                    sumarPuntaje("Antonio",listaPersonas,55);
                }
                break;
            case 6:
                if(opcion1.isSelected()){
                    //Robayo David Miguel
                    sumarPuntaje("Robayo",listaPersonas,25);
                    sumarPuntaje("David",listaPersonas,5);
                    sumarPuntaje("Miguel",listaPersonas,15);
                }else if(opcion2.isSelected()){
                    //David(profe) Inma Carlos
                    sumarPuntaje("David Joaquin",listaPersonas,25);
                    sumarPuntaje("Inma",listaPersonas,20);
                    sumarPuntaje("Carlos",listaPersonas,15);
                }else if(opcion3.isSelected()){
                    //Antonio
                    sumarPuntaje("Antonio",listaPersonas,100);
                }else if(opcion4.isSelected()){
                    //Javi
                    sumarPuntaje("Javi",listaPersonas,50);
                    sumarPuntaje("Jose",listaPersonas,15);
                }
                break;
            case 7:
                if(opcion1.isSelected()){
                    //Javi Miguel David(profe) Sergio
                    sumarPuntaje("Javi",listaPersonas,20);
                    sumarPuntaje("Miguel",listaPersonas,20);
                    sumarPuntaje("David Joaquin",listaPersonas,20);
                    sumarPuntaje("Sergio",listaPersonas,20);
                }else if(opcion2.isSelected()){
                    //Carlos Inma Antonio
                    sumarPuntaje("Carlos",listaPersonas,20);
                    sumarPuntaje("Inma",listaPersonas,20);
                    sumarPuntaje("Antonio",listaPersonas,20);
                }else if(opcion3.isSelected()){
                    //Sergio Jose David
                    sumarPuntaje("Jose",listaPersonas,20);
                    sumarPuntaje("Sergio",listaPersonas,20);
                    sumarPuntaje("David",listaPersonas,20);
                }else if(opcion4.isSelected()){
                    //Robayo David
                    sumarPuntaje("Robayo",listaPersonas,50);
                    sumarPuntaje("David",listaPersonas,25);
                }
                break;
            case 8:
                if(opcion1.isSelected()){
                    //Carlos David Javi
                    sumarPuntaje("Carlos",listaPersonas,20);
                    sumarPuntaje("David",listaPersonas,20);
                    sumarPuntaje("Javi",listaPersonas,20);
                }else if(opcion2.isSelected()){
                    //Jose Sergio
                    sumarPuntaje("Jose",listaPersonas,10);
                    sumarPuntaje("Sergio",listaPersonas,20);
                }else if(opcion3.isSelected()){
                    //Inma Robayo
                    sumarPuntaje("Inma",listaPersonas,50);
                    sumarPuntaje("Robayo",listaPersonas,10);
                }else if(opcion4.isSelected()){
                    //Robayo Miguel David(profe)
                    sumarPuntaje("Robayo",listaPersonas,5);
                    sumarPuntaje("Miguel",listaPersonas,5);
                    sumarPuntaje("David Joaquin",listaPersonas,40);
                }
                break;
            case 9:
                if(opcion1.isSelected()){
                    //Carlos Inma David
                    sumarPuntaje("Carlos",listaPersonas,20);
                    sumarPuntaje("Inma",listaPersonas,20);
                    sumarPuntaje("David",listaPersonas,20);
                }else if(opcion2.isSelected()){
                    //Jose David Miguel Inma
                    sumarPuntaje("Jose",listaPersonas,20);
                    sumarPuntaje("David",listaPersonas,20);
                    sumarPuntaje("Miguel",listaPersonas,35);
                    sumarPuntaje("Inma",listaPersonas,20);
                }else if(opcion3.isSelected()){
                    //Robayo Antonio Javi
                    sumarPuntaje("Robayo",listaPersonas,10);
                    sumarPuntaje("Antonio",listaPersonas,10);
                    sumarPuntaje("Javi",listaPersonas,25);
                }else if(opcion4.isSelected()){
                    //David Miguel David(profe)
                    sumarPuntaje("David",listaPersonas,10);
                    sumarPuntaje("Miguel",listaPersonas,25);
                    sumarPuntaje("David Joaquin",listaPersonas,10);
                }
                break;
            case 10:
                if(opcion1.isSelected()){
                    //Inma
                    sumarPuntaje("Inma",listaPersonas,50);
                }else if(opcion2.isSelected()){
                    //Javi Carlos David
                    sumarPuntaje("Javi",listaPersonas,10);
                    sumarPuntaje("Carlos",listaPersonas,30);
                    sumarPuntaje("David",listaPersonas,10);
                    sumarPuntaje("David Joaquin",listaPersonas,10);
                }else if(opcion3.isSelected()){
                    //Robayo Jose Antonio
                    sumarPuntaje("Jose",listaPersonas,20);
                    sumarPuntaje("Robayo",listaPersonas,40);
                    sumarPuntaje("Antonio",listaPersonas,20);
                    sumarPuntaje("Miguel",listaPersonas,10);
                }else if(opcion4.isSelected()){
                    //David Antonio Jose Robayo
                    sumarPuntaje("Jose",listaPersonas,20);
                    sumarPuntaje("Robayo",listaPersonas,10);
                    sumarPuntaje("Antonio",listaPersonas,20);
                    sumarPuntaje("David",listaPersonas,20);
                }
                break;
            case 11:
                if(opcion1.isSelected()){
                    //Antonio Inma
                    sumarPuntaje("Inma",listaPersonas,30);
                    sumarPuntaje("Antonio",listaPersonas,100);
                }else if(opcion2.isSelected()){
                    //Robayo David(profe) Miguel
                    sumarPuntaje("Robayo",listaPersonas,100);
                    sumarPuntaje("David Joaquin",listaPersonas,20);
                    sumarPuntaje("Miguel",listaPersonas,20);
                }else if(opcion3.isSelected()){
                    //Javi Jose Carlos
                    sumarPuntaje("Jose",listaPersonas,20);
                    sumarPuntaje("Javi",listaPersonas,100);
                    sumarPuntaje("Carlos",listaPersonas,10);
                }else if(opcion4.isSelected()){
                    //David Sergio
                    sumarPuntaje("David",listaPersonas,20);
                    sumarPuntaje("Sergio",listaPersonas,20);
                }
                break;
                case 12:
                if(opcion1.isSelected()){
                    //Inma
                    sumarPuntaje("Inma",listaPersonas,50);
                }else if(opcion2.isSelected()){
                    //Robayo David(profe) Miguel
                    sumarPuntaje("Antonio",listaPersonas,50);
                }else if(opcion3.isSelected()){
                    sumarPuntaje("David Joaquin",listaPersonas,50);
                }else if(opcion4.isSelected()){
                    sumarPuntaje("Jose",listaPersonas,20);
                    sumarPuntaje("Javi",listaPersonas,50);
                    sumarPuntaje("Carlos",listaPersonas,10);
                    sumarPuntaje("David",listaPersonas,20);
                    sumarPuntaje("Sergio",listaPersonas,20);
                }
                break;
            default:
                System.out.println("Número inválido");
        }
    }
    public String MaxPuntos(ArrayList<Persona> lista) {
        String personaConMasPuntos = "";
        int maxPuntos = 0;

        for (Persona persona : lista) {
            if (persona.getPuntos() > maxPuntos) {
                maxPuntos = persona.getPuntos();
                personaConMasPuntos = persona.getNombre();
            }
        }

        return personaConMasPuntos;
    }
    @FXML
    void accionar(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaFinal.fxml"));
            Parent root = loader.load();
            stage.setTitle("Finaaal");
            Controlador2 controladorFinal = loader.getController();  // Obtener el controlador de la vista final
            controladorFinal.setTextoFin(MaxPuntos(personasList));  // Establecer el texto del ganador en el controlador de la vista final

            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (NullPointerException e) {
            System.out.println("Lista vacía");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error inesperadísimo");
        }
    }

    public void setTextoFin(String texto) {
        textofin.setText(texto);
    }

}
