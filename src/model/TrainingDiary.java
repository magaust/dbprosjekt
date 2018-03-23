package model;

import database.ExerciseDBManager;
import database.ExerciseGroupDBManager;
import database.MachineDBManager;
import database.WorkoutDBManager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainingDiary {
    User user;
    Scanner s;

    public TrainingDiary(User user){
        this.user = user;
    }

    public void run(){
        s = new Scanner(System.in);
        while (true) {
            System.out.println("" +
                    "1: Registrate a machine, exercise, exercise group or workout \n" +
                    "2: Get information about the n last completed workouts \n" +
                    "3: See a log of result for a specific exercise \n" +
                    "4: Find exercises in an exercise group \n" +
                    "5: Get information about how many exercises a machine are being used\n");
            System.out.print(">>>");
            int choice = s.nextInt();
            if (choice > 0 && choice < 6) {
                if (choice == 1) {
                    register();
                }
                if (choice == 2) {
                    getWorkoutInfo();
                }
                if (choice == 3) {
                    seeExerciseLog();
                }
                if (choice == 4) {
                    findExerciseInGroup();
                }
                if (choice == 5) {
                    seeNumOfExercise();
                }
            }

        }
    }

    private void seeNumOfExercise() {
        System.out.print("\n Which machine do you want to see (name of machine): ");
        String name = s.next();
        //TODO: Query to find the number of exercises for the chosen machine
    }

    private void getWorkoutInfo() {
        System.out.print("\n How many of the last workout do you want to see: ");
        int numOfWorkout = s.nextInt();
        try {
            WorkoutDBManager wDBM = new WorkoutDBManager();
            List<Workout> workouts = wDBM.getLastNWorkouts(user.getID(), numOfWorkout);
            for (Workout workout:
                 workouts) {
                System.out.println("Notat: " + workout.getNote());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void seeExerciseLog() {
        System.out.print("\n Write the id of a workout to see the log: ");
        int workoutId = s.nextInt();
        // TODO: fill in query and print result in console
    }

    private void findExerciseInGroup() {
        System.out.print("\n Which exercise group do you want to see: ");
        int choice = s.nextInt();
        // TODO: add query to get all excercise group and print them with an IDnumber.
        System.out.println(">>>");
        int ch = s.nextInt();
        try {
            ExerciseDBManager edbm = new ExerciseDBManager();
            List<String> exercises = edbm.getExerciseByGroupId(ch);
            System.out.println("Exercises in group nr " + ch + ": ");
            for(String e : exercises) {
                System.out.println(e);
            };

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void register() {
        System.out.println("" +
                "1: Machine \n" +
                "2: Exercise \n" +
                "3: Exercise group \n" +
                "4: Workout \n");
        System.out.print(">>>");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        if(choice > 0 && choice < 6) {
            if(choice == 1) {
                createMachine();
            }
            if (choice == 2) {
                createExercise();
            }
            if(choice == 3) {
                createExerciseGroup();
            }
            if(choice == 4) {
                createWorkOut();
            }
        }
    }

    private void createExerciseGroup() {
        System.out.println("Insert Id(int): ");
        int id = s.nextInt();
        System.out.println("Insert group name: ");
        String name = s.next();
        ExerciseGroup eg = new ExerciseGroup(id, name);

        try{
            ExerciseGroupDBManager egm = new ExerciseGroupDBManager();
            egm.createExerciseGroup(eg);
            System.out.println("ExerciseGroup created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createExercise() {
        System.out.println("Insert exercise id: ");
        int id = s.nextInt();
        System.out.println("Insert exercise name ");
        String name = s.next();
        System.out.println("Insert exercise description: ");
        String description = s.next();
        System.out.println("Is this a machine? (0/1) ");
        Boolean isMachine = s.nextBoolean();
        Exercise ex = new Exercise(id, name, description, isMachine);

        try {
            ExerciseDBManager eDBM = new ExerciseDBManager();
            eDBM.createExercise(ex);
            System.out.println("Exercise created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createMachine() {
        // id name userDesc,
        System.out.println("Insert machine id: ");
        int id = s.nextInt();
        System.out.println("Insert machine name: ");
        String name = s.next();
        System.out.println("Insert machine description: ");
        String description = s.next();
        Machine machine = new Machine(id, name, description);

        try {
            MachineDBManager mDBM = new MachineDBManager();
            mDBM.createMachine(machine);
            System.out.println("Created machine");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createWorkOut() {
        System.out.print("Insert Id(int): ");
        int id = s.nextInt();
        System.out.println("Insert duration(double): ");
        double duration = s.nextDouble();
        System.out.println("Insert fitnesslevel (int): ");
        int fitnessLevel = s.nextInt();
        System.out.println("Insert performance (int) ");
        int performance = s.nextInt();
        System.out.println("Insert note: ");
        String note = s.next();
        System.out.println("Insert date: (String(YYYY.MM.DD) ");
        String date = s.next();
        Workout workout = new Workout(id, 1, duration, fitnessLevel, performance, note, Date.valueOf(date));
        try {
            WorkoutDBManager workoutDBManager = new WorkoutDBManager();
            workoutDBManager.createWorkout(workout);
            System.out.println("Workout created");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
