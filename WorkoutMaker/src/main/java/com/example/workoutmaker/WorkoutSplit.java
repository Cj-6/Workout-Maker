package com.example.workoutmaker;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Cj Carrier
 */
public class WorkoutSplit {

    private String splitName; // Add a field to represent the day of the week
    private List<DailyRoutine> DailyRoutine;

    public WorkoutSplit() {
    }

    public WorkoutSplit(String splitName, List<DailyRoutine> DailyRoutine) {
        this.splitName = splitName;
        this.DailyRoutine = DailyRoutine;
    }

    public String getSplitName() {
        return splitName;
    }

    public void setSplitName(String splitName) {
        this.splitName = splitName;
    }

    public List<DailyRoutine> getDailyRoutine() {
        return DailyRoutine;
    }

    public void setDailyRoutine(List<DailyRoutine> DailyRoutine) {
        this.DailyRoutine = DailyRoutine;
    }

}
