package com.example.workoutmaker;

import java.util.List;

/**
 * @author Cj Carrier
 */
public class DailyRoutine {

    private String dayOfWeek; // Add a field to represent the day of the week
    private List<String> musclesWorked;
    private String splitName;


    public DailyRoutine() {
    }

    public DailyRoutine(String dayOfWeek, List<String> musclesWorked) {
        this.dayOfWeek = dayOfWeek;
        this.musclesWorked = musclesWorked;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<String> getMusclesWorked() {
        return musclesWorked;
    }

    public void setMusclesWorked(List<String> musclesWorked) {
        this.musclesWorked = musclesWorked;
    }

}
