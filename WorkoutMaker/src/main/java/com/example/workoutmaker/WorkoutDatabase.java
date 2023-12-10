package com.example.workoutmaker;

import java.io.*;
import java.util.*;


public class WorkoutDatabase {

    public ArrayList<String> muscleGroups = new ArrayList<>();
    private static String pathToMuscles;
    public static int dayOfWeek;
    public int lastSplitIndex;
    public int selectedSplitIndex;
    public ArrayList<WorkoutSplit> splits = new ArrayList<>();
    private final WorkoutSplit workoutSplit = new WorkoutSplit();


    public WorkoutDatabase() {
        try {
            readSplitsFromFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * LoadData loads the data kept in the various text files list
     */
    public void loadData() {
        System.out.println(splits.size());
        String pathToFiles = System.getProperty("user.dir");
        pathToMuscles = pathToFiles + "\\Muscles.txt";
        try {
            loadMuscles();
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
    private void loadMuscles() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(pathToMuscles));
        //Adds all the muscles to the muscleGroups ArrayList
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            muscleGroups.add(line);

        }
    }


    public WorkoutSplit createWorkoutSplit() {
        WorkoutSplit newSplit = new WorkoutSplit(); // Create a new instance of WorkoutSplit
        lastSplitIndex = splits.size();
        return newSplit; // Return the newly created split
    }

    public void cancelWorkoutSplit() {
        splits.remove(lastSplitIndex);
    }


    public ArrayList<String> listSplits() {
        ArrayList<String> splitNames = new ArrayList<>();
        for (WorkoutSplit split : splits) {
            splitNames.add(split.getSplitName());
        }
        return splitNames;
    }

//    public ArrayList<String> listMuscles(int dayOfWeek) {
//        ArrayList<String> Muscles = new ArrayList<>();
//        for (int i = 0; i < splits.get(selectedSplitIndex).getMusclesForDay(dayOfWeek).size(); i++) {
//            Muscles.add(splits.get(selectedSplitIndex).getMusclesForDay(dayOfWeek).get(i));
//        }
//        return splitNames;
//    }


    public void addMusclesToDay(List<String> selectedItems) {
        splits.get(lastSplitIndex).addMusclesForDay(dayOfWeek, selectedItems);
        System.out.println(workoutSplit.getMusclesForDay(0));
    }

    public void addSplitToList(WorkoutSplit workoutSplit) {
        splits.add(workoutSplit);
    }


    public void setSplitName(String splitName) {
        splits.get(lastSplitIndex).setSplitName(splitName);
    }


    public void writeSplitsToFile() throws IOException {
        File file = new File("Splits.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(splits);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    //make a method that reads splits from a file
    public void readSplitsFromFile() throws FileNotFoundException {
        File file = new File("Splits.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            splits = (ArrayList<WorkoutSplit>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error Finding this file: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    //test methods
    public void getSplits(int index) {
        System.out.println(splits.get(index).getSplitName() + " Is the Name");
        System.out.println(splits.get(index).getMusclesForDay(0) + " are the muscles for monday");
        System.out.println(splits.get(index).getMusclesForDay(1) + " are the muscles for tuesday");
        System.out.println(splits.get(index).getMusclesForDay(2) + " are the muscles for wednesday");
        System.out.println(splits.get(index).getMusclesForDay(3) + " are the muscles for thursday");
        System.out.println(splits.get(index).getMusclesForDay(4) + " are the muscles for friday");
        System.out.println(splits.get(index).getMusclesForDay(5) + " are the muscles for saturday");
        System.out.println(splits.get(index).getMusclesForDay(6) + " are the muscles for sunday");

    }


}
