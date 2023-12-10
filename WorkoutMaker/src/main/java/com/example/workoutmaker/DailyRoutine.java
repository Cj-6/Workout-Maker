package com.example.workoutmaker;

import java.util.List;

/**
 * @author Cj Carrier
 */
public class DailyRoutine {

    private int dayOfWeek; // Add a field to represent the day of the week
    private List<String> musclesWorked;


    public DailyRoutine() {
    }

    public DailyRoutine(int dayOfWeek, List<String> musclesWorked) {
        this.dayOfWeek = dayOfWeek;
        this.musclesWorked = musclesWorked;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<String> getMusclesWorked() {
        return musclesWorked;
    }

    public void setMusclesWorked(List<String> musclesWorked) {
        this.musclesWorked = musclesWorked;
    }

}
