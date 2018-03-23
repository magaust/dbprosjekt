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
        int machineId = (int) (Math.random()*1000000);
        try {
            WorkoutDBManager wDBM = new WorkoutDBManager();
            ExerciseDBManager eDBM = new ExerciseDBManager();
            ExerciseGroupDBManager egDBM = new ExerciseGroupDBManager();
            MachineDBManager mDBM = new MachineDBManager();

            System.out.println("Creating exercises with ID: " + exerciseId + " and " + (exerciseId + 1));
            eDBM.createExercise(new Exercise(exerciseId, "Benkpress", "Ta en benk å press", false));
            eDBM.createExercise(new Exercise(exerciseId + 1, "Bøy", "Knebøy", false));
            eDBM.createExercise(new Exercise(exerciseId + 2, "Jogging", "Jogge på tredemølle", false));
            eDBM.createExercise(new Exercise(exerciseId + 3, "Markløft", "Standard mark", false));
            eDBM.createExercise(new Exercise(exerciseId + 4, "Sumo-mark", "Markløft sumo variant", false));
            eDBM.createExercise(new Exercise(exerciseId + 5, "BicepCurls", "For the pretty girls", false));
            eDBM.createExercise(new Exercise(exerciseId + 6, "Rows", "For the hoes", false));



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

                if(i < 5) {
                    for(int j = 0; j < 7; j++) {
                        wDBM.addExerciseToWorkout(exerciseId + j, workoutId + i, 10+(10*i), 10);
                        System.out.println("Added exercise " + (exerciseId + j) + " to workout " + (workoutId + i));
                    }
                } else {
                    wDBM.addExerciseToWorkout(exerciseId, workoutId + i, 100+(10*i), 10);
                    System.out.println("Added exercise " + exerciseId + " to workout " + workoutId);
                }
            }

            System.out.println("###CREATING EXERCISEGROUP###");
            egDBM.createExerciseGroup(new ExerciseGroup(exerciseGroupId, "Compound movements"));
            System.out.println("Created exerciseGroupe with id: " + exerciseGroupId);
            egDBM.addExerciseToGroup(exerciseGroupId, exerciseId );
            egDBM.addExerciseToGroup(exerciseGroupId, exerciseId +1);
            System.out.println("Added " + exerciseId + " to exerciseGroup " + exerciseGroupId);
            System.out.println("Added " + (exerciseId + 1) + " to exerciseGroup " + exerciseGroupId);


            System.out.println("###CREATING MACHINES###");
            System.out.println("Created machines with id: " + machineId + " - " + (machineId+4));
            mDBM.createMachine(new Machine(machineId, "Maskin 1", "Dette er maskin nr1"));
            mDBM.createMachine(new Machine(machineId+1, "Maskin 2", "Dette er maskin nr2"));
            mDBM.createMachine(new Machine(machineId+2, "MeanMachine", "Dette er maskin nr3"));
            mDBM.createMachine(new Machine(machineId+3, "RoMaskin", "Dette er maskin nr4"));
            mDBM.createMachine(new Machine(machineId+4, "Tredemølle", "Dette er maskin nr5"));

            System.out.println("Added machines " + machineId + " - " + (machineId+4) + " to exercise " + exerciseId);
            eDBM.addMachineToExercise(machineId, exerciseId);
            eDBM.addMachineToExercise(machineId + 1, exerciseId);
            eDBM.addMachineToExercise(machineId+2, exerciseId);
            eDBM.addMachineToExercise(machineId+3, exerciseId);
            eDBM.addMachineToExercise(machineId+4, exerciseId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
