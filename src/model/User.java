package model;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private ArrayList<Workout> workouts;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }
}
