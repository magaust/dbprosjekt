package utilities;

import model.*;
import database.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DataGenerator {

    public User user;

    public void generateAllData() throws Exception{
        //create a user object with random userI
        int userId = (int) (Math.random()*100000);
        try {
            System.out.println("###CREATING A USER###");
            UserDBManager uDBM = new UserDBManager();
            User newUser = new User(userId, "Vår test bruker");
            this.user = newUser;
            uDBM.createUser(newUser);
            System.out.println("User created with id " + userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //add workouts to the user
        int workoutId = (int) (Math.random()*1000000);
        int exerciseId = (int) (Math.random()*1000000);
        int exerciseGroupId = (int) (Math.random()*1000000);
        try {
            WorkoutDBManager wDBM = new WorkoutDBManager();
            ExerciseDBManager eDBM = new ExerciseDBManager();
            ExerciseGroupDBManager egDBM = new ExerciseGroupDBManager();

            System.out.println("Creating exercises with ID: " + exerciseId + " and " + (exerciseId + 1));
            eDBM.createExercise(new Exercise(exerciseId, "Benkpress", "Ta en benk å press", false));
            eDBM.createExercise(new Exercise(exerciseId + 1, "Bøy", "Knebøy", false));


            System.out.println("###CREATING WORKOUTS###");
            Date date = new java.sql.Date(System.currentTimeMillis());
            for(int i = 0; i < 10; i++) {
                Workout newWorkout = new Workout(
                        workoutId + i,
                        userId,
                        10.0,
                        0,
                        0,
                        "Dette er et notat om hvordan workouten (" + i + ") gikk.",
                        date
                );
                wDBM.createWorkout(newWorkout);
                System.out.println("Workout created with id: " + workoutId + " for the userId " + userId);

                wDBM.addExerciseToWorkout(exerciseId, workoutId + i, 100+(10*i), 10);
                System.out.println("Added exercise " + exerciseId + " to workout " + workoutId);
                if(i < 5) {
                    wDBM.addExerciseToWorkout(exerciseId + 1, workoutId + i, 10+(10*i), 10);
                    System.out.println("Added exercise " + (exerciseId + 1) + " to workout " + (workoutId + i));
                }
            }

            System.out.println("###CREATING EXERCISEGROUP###");
            egDBM.createExerciseGroup(new ExerciseGroup(exerciseGroupId, "Compound movements"));
            System.out.println("Created exerciseGroupe with id: " + exerciseGroupId);
            egDBM.addExerciseToGroup(exerciseGroupId, exerciseId );
            egDBM.addExerciseToGroup(exerciseGroupId, exerciseId +1);
            System.out.println("Added " + exerciseId + " to exerciseGroup " + exerciseGroupId);
            System.out.println("Added " + (exerciseId + 1) + " to exerciseGroup " + exerciseGroupId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
