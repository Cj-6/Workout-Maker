package com.example.workoutmaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Parent root = fxmlLoader.load();

        String css = this.getClass().getResource("application.css").toExternalForm();

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(css);


        stage.setTitle("Workout Maker");
        stage.setScene(scene);
        stage.show();

    }


}