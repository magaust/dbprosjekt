package model;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    //override of the toString method so we can log the object
    public String toString() {
        return "User, ID: " + id + ", Name: " + name;
    }
}
