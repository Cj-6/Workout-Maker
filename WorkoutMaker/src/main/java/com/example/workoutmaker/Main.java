package com.example.workoutmaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        WorkoutDatabase workoutDatabase = new WorkoutDatabase();
        workoutDatabase.LoadData();

        ArrayList<DailyRoutine> DailyRoutineList = getDailyRoutines();

        WorkoutSplit bigTest = new WorkoutSplit("push and push", DailyRoutineList);
        System.out.println(bigTest.getDailyRoutine().get(0).getDayOfWeek()
        );
        System.out.println(bigTest.getDailyRoutine().get(0).getMusclesWorked()
        );

        launch();
    }

    private static ArrayList<DailyRoutine> getDailyRoutines() {
        List<String> musclesForMonday = new ArrayList<>();
        musclesForMonday.add("chest");
        musclesForMonday.add("chest2");

        List<String> musclesForTuesday = new ArrayList<>();
        musclesForTuesday.add("lgssss");
        musclesForTuesday.add("lgs");

        DailyRoutine one = new DailyRoutine("monday", musclesForMonday);
        DailyRoutine two = new DailyRoutine("tuesday", musclesForTuesday);

        ArrayList<DailyRoutine> DailyRoutineList = new ArrayList<>();
        DailyRoutineList.add(one);
        DailyRoutineList.add(two);
        return DailyRoutineList;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
}