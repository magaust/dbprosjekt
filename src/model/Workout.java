package model;

public class Workout {
    private int id;
    private User user;
    private String fitnessLevel;
    private String performance;
    private String note;

    public Workout(int id, User user, String fitnessLevel, String performance, String note) {
        this.id = id;
        this.user = user;
        this.fitnessLevel = fitnessLevel;
        this.performance = performance;
        this.note = note;

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

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
