package com.example.workoutmaker;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;


import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Controller class that manages the UI and user interactions for workout maker application.
 */
public class Controller implements Initializable {
    private Scene scene;
    public Stage stage;
    private String splitName;
    private int dayOfWeek;

    @FXML
    private TextField splitNameInput;
    @FXML
    private Label splitNameLabel;
    @FXML
    private ListView<String> mondayListView = new ListView<>();

    @FXML
    private ListView<String> tuesdayListView = new ListView<>();

    @FXML
    private ListView<String> wednesdayListView = new ListView<>();

    @FXML
    private ListView<String> thursdayListView = new ListView<>();

    @FXML
    private ListView<String> fridayListView = new ListView<>();

    @FXML
    private ListView<String> saturdayListView = new ListView<>();

    @FXML
    private ListView<String> sundayListView = new ListView<>();

    @FXML
    private ListView<String> splitListView = new ListView<>();
    @FXML
    private ListView<String> musclesListView = new ListView<>();

    private static WorkoutDatabase workoutDatabase; // Declare WorkoutDatabase as static


    /**
     * Initializes the controller and sets up the initial state of the UI.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        if (workoutDatabase == null) {
            workoutDatabase = new WorkoutDatabase();
            workoutDatabase.loadData();
        }
        splitListView.getItems().addAll(workoutDatabase.listSplits());

        musclesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        musclesListView.getItems().addAll(workoutDatabase.muscleGroups);

        musclesListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            List<String> selectedItems = musclesListView.getSelectionModel().getSelectedItems();

        });
    }

    public void switchToMain(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToSplit(javafx.event.ActionEvent actionEvent) throws IOException {

        //workoutDatabase.splits.remove(workoutDatabase.splits.get(workoutDatabase.splits.size()));   //FIX =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("split.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToCreateSplit(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("createSplit.fxml"));
        Parent root = fxmlLoader.load();


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void createNewSplit(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            workoutDatabase.addSplitToList(workoutDatabase.createWorkoutSplit());
            System.out.println(workoutDatabase.splits.size()
                    + " is the current size of split list");
        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }

        // Clear the splitListView before adding the splits again to avoid duplicates
        splitListView.getItems().clear();
        splitListView.getItems().addAll(workoutDatabase.listSplits());


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("createSplit.fxml"));
        Parent root = fxmlLoader.load();


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void cancelCreateSplit(javafx.event.ActionEvent actionEvent) throws IOException {

        System.out.println(workoutDatabase.splits.size());
        workoutDatabase.cancelWorkoutSplit();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("split.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //method adding muscles and split name to each day
    public void switchToAddMuscles(javafx.event.ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addMuscles.fxml"));
        Parent root = fxmlLoader.load();

        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        // Handles what day button is clicked on
        Button clickedButton = (Button) actionEvent.getSource();
        String userDataString = (String) clickedButton.getUserData(); // Get the day from userData
        try {
            dayOfWeek = Integer.parseInt(userDataString); // Convert String to int
            WorkoutDatabase.dayOfWeek = dayOfWeek; // Assign the int value to dayOfWeek
        } catch (NumberFormatException e) {
            // Handle the case where the userDataString is not a valid integer
            System.err.println("Invalid userData format: " + e.getMessage());
        }
        // 'selectedDay' holds the day corresponding to the clicked button


    }


    public void switchToCalendar(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Calendar.fxml"));
        Parent root = fxmlLoader.load();


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void selectSplit(javafx.event.ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SelectSplit.fxml"));
        Parent root = fxmlLoader.load();


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void confirmSplit(javafx.event.ActionEvent actionEvent) throws IOException {
        workoutDatabase.selectedSplitIndex = splitListView.getSelectionModel().getSelectedIndex();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Calendar.fxml"));
        Parent root = fxmlLoader.load();


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void loadSelectedSplit(javafx.event.ActionEvent actionEvent) throws IOException {
        splitNameLabel.setText(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getSplitName());

        mondayListView.getItems().addAll(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getMusclesForDay(0));
        tuesdayListView.getItems().addAll(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getMusclesForDay(1));
        wednesdayListView.getItems().addAll(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getMusclesForDay(2));
        thursdayListView.getItems().addAll(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getMusclesForDay(3));
        fridayListView.getItems().addAll(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getMusclesForDay(4));
        saturdayListView.getItems().addAll(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getMusclesForDay(5));
        sundayListView.getItems().addAll(workoutDatabase.splits.get(workoutDatabase.selectedSplitIndex).getMusclesForDay(6));
    }


    public void addMuscles(javafx.event.ActionEvent actionEvent) throws IOException {
        workoutDatabase.addMusclesToDay(musclesListView.getSelectionModel().getSelectedItems());


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("createSplit.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void createSplit(javafx.event.ActionEvent actionEvent) throws IOException {
        if (!splitNameInput.getText().isEmpty()) {
            try {
                splitName = splitNameInput.getText();
                workoutDatabase.setSplitName(splitName);
            } catch (Exception ex) {
                System.out.println("An error occurred: " + ex.getMessage());
            }

            // Clear the splitListView before adding the splits again to avoid duplicates
            splitListView.getItems().clear();
            splitListView.getItems().addAll(workoutDatabase.listSplits());
            try {
                workoutDatabase.writeSplitsToFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("split.fxml"));
            Parent root = fxmlLoader.load();

            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("Please Enter a Split Name");
        }

    }

    public void checkObject() {
        workoutDatabase.getSplits(0);
        System.out.println(workoutDatabase.listSplits());
    }

    public void tester() throws IOException {
        workoutDatabase.readSplitsFromFile();
    }


    public void deleteSelectedSplit() {
        int selectedIndex = splitListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            workoutDatabase.splits.remove(selectedIndex);
            System.out.println("Removed item at index: " + selectedIndex);
            splitListView.getItems().clear();
            splitListView.getItems().addAll(workoutDatabase.listSplits());
            try {
                workoutDatabase.writeSplitsToFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void closeButton(javafx.event.ActionEvent actionEvent) {
        javafx.application.Platform.exit();
    }


}