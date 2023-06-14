module com.example.proyectojavafxpregunta {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.proyectojavafxpregunta to javafx.fxml;
    exports com.example.proyectojavafxpregunta;
}