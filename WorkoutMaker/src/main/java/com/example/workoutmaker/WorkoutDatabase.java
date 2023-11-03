package com.example.workoutmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class WorkoutDatabase extends WorkoutSplit {

    public static ArrayList<String> muscleGroups = new ArrayList<>();
    private static String pathToMuscles;

    /**
     * LoadData loads the data kept in the various text files list
     */
    public void LoadData() {
        String pathToFiles = System.getProperty("user.dir");
        pathToMuscles = pathToFiles + "\\Muscles.txt";
        try {
            LoadMuscles();
        } catch (FileNotFoundException ex) {
            System.out.println("-------------> " + ex);
        }

    }

    /**
     * this method scans the muscles.txt file and adds them to the muscleGroups
     * array
     *
     * @throws FileNotFoundException
     */
    private static void LoadMuscles() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(pathToMuscles));

        //Adds all the muscles to the muscleGroups ArrayList
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            muscleGroups.add(line);
        }
    }

    public WorkoutSplit CreateSplit() {
        WorkoutSplit curSplit = new WorkoutSplit();
        DailyRoutine curRoutine = new DailyRoutine();
        ArrayList<DailyRoutine> DailyRoutineList = new ArrayList<>();

        /*
         * setDayOfWeek also add a way to add the muscles to the list
         */
        //this would be the code for monday
        curRoutine.setDayOfWeek("MONDAY");
        curRoutine.setMusclesWorked(muscleGroups);
        DailyRoutineList.add(curRoutine); //Adding to list

        curSplit.setSplitName("temp");
        curSplit.setDailyRoutine(DailyRoutineList); //finalizing the curSplit

        return curSplit;

        //TODO add a thing that sets the day of the week clicked to

    }


}
