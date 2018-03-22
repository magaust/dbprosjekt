package model;

public class Machine {
    private int id;
    private String name;
    private String userDescription;
    private ExerciseGroup excerciseGroup;

    public Machine(int id, String name, String userDescription) {
        this.id = id;
        this.name = name;
        this.userDescription = userDescription;
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

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }


    /**
     * Mangler konsistens imellom grupper
     * @param eg
     */
    public void setExcerciseGroup(ExerciseGroup eg) {
        this.excerciseGroup = eg;
    }
}
