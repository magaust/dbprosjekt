import model.*;
import database.*;

import java.util.Date;


class app {

	public static void main(String[] args){

		UserDBManager userDBManager;
		try {
			//create a new userDBManager
			userDBManager = new UserDBManager();
			//try to create a new user on the db
			int userID = (int)(Math.random()*100000); //a 'random' userID to avoid collisions when testing
			User newUser = new User(userID, "Øivind ;^)");
			userDBManager.createUser(newUser);

			//get that same user back from the db
			User userFetchedFromDB = userDBManager.getUser(userID);
			System.out.println(userFetchedFromDB);

			//create a workout
			int workoutID = (int)(Math.random()*100000);
			Workout workout = new Workout(workoutID, 74517, 10.0, 1, 1, "Test workout", new java.sql.Date(new Date().getTime()));
			WorkoutDBManager workoutDBManager = new WorkoutDBManager();
			workoutDBManager.createWorkout(workout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}