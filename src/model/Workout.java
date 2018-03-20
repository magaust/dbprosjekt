package model;

import java.sql.Date;

public class Workout {
    private int id;
    private User user;
    private double duration;
    private int fitnessLevel;
    private int performance;
    private String note;
    private Date date;

    public Workout(int id, User user, double duration, int fitnessLevel, int performance, String note, Date date) {
        this.id = id;
        this.user = user;
        this.duration = duration;
        this.fitnessLevel = fitnessLevel;
        this.performance = performance;
        this.note = note;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(int fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public double getDuration() {
        return duration;
    }
}
