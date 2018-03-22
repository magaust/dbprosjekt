package utilities;

import model.*;
import database.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DataGenerator {

    public void generateAllData() throws Exception{
        //create a user object with random userI
        int userID = (int) (Math.random()*100000);
        try {
            System.out.println("Creating a user");
            UserDBManager uDBM = new UserDBManager();
            User newUser = new User(userID, "Vår test bruker");
            uDBM.createUser(newUser);
            System.out.println("User created with id " + userID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //add workouts to the user
        int workoutId = (int) (Math.random()*100000);
        try {
            System.out.println("Creating workout");
            WorkoutDBManager wDBM = new WorkoutDBManager();
            Date date = new java.sql.Date(System.currentTimeMillis());
            for(int i = 0; i < 10; i++) {
                Workout newWorkout = new Workout(
                        workoutId + i,
                        userID,
                        10.0,
                        0,
                        0,
                        "Dette er et notat om hvordan workouten gikk.",
                        date
                );
                wDBM.createWorkout(newWorkout);
                System.out.println("Workout created with id: " + workoutId + " for the userId " + userID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
