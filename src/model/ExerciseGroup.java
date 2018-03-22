package model;

import java.util.ArrayList;


public class ExerciseGroup {
    private int id;
    private String name;
    private ArrayList<Exercise> group;

    public ExerciseGroup(int id, String name) {
        this.id = id;
        this.name = name;
        group = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mangler konsistens imellom grupper
     * @param ex
     */
    public void addExcercise(Exercise ex) {
        group.add(ex);
    }

}
