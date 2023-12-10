package com.example.workoutmaker;

import java.io.Serializable;
import java.util.*;

/**
 * @author Cj Carrier
 */
public class WorkoutSplit implements Serializable {

    private String splitName;


    private final Map<String, List<String>> musclesForDay;


    public WorkoutSplit() {
        this.splitName = "splitName";
        this.musclesForDay = new HashMap<>();
        initializeMusclesForDay();
    }


    private void initializeMusclesForDay() {
        // Initialize the muscles for each day with empty lists
        musclesForDay.put("0", new ArrayList<>());
        musclesForDay.put("1", new ArrayList<>());
        musclesForDay.put("2", new ArrayList<>());
        musclesForDay.put("3", new ArrayList<>());
        musclesForDay.put("4", new ArrayList<>());
        musclesForDay.put("5", new ArrayList<>());
        musclesForDay.put("6", new ArrayList<>());
    }


    // Method to add muscles worked on a specific day


    public void addMusclesForDay(int dayIndex, List<String> muscles) {
        // Add muscles to the specified day
        if (musclesForDay.containsKey(Integer.toString(dayIndex))) {
            List<String> routines = musclesForDay.get(Integer.toString(dayIndex));
            routines.addAll(muscles);
            musclesForDay.put(Integer.toString(dayIndex), routines);
        } else {
            System.out.println("Invalid day provided");
        }
    }


    public List<String> getMusclesForDay(int dayIndex) {
        if (musclesForDay.containsKey(Integer.toString(dayIndex))) {
            return musclesForDay.get(Integer.toString(dayIndex));
        } else {
            System.out.println("Invalid day specified.");
            return null;
        }
    }

    public void displayWorkoutSchedule() {
        // Display the muscles for each day
        for (Map.Entry<String, List<String>> entry : musclesForDay.entrySet()) {
            String day = entry.getKey();
            List<String> muscles = entry.getValue();

            System.out.println(day + ": " + muscles);
        }
    }


    public String getSplitName() {
        return splitName;
    }

    public void setSplitName(String splitName) {
        this.splitName = splitName;
    }

    @Override
    public String toString() {
        return "WorkoutSplit{" +
                "splitName='" + splitName + '\'' +
                ", musclesForDay=" + musclesForDay +
                '}';
    }
}


