package database;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;
import model.Exercise;
import model.User;
import model.Workout;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class WorkoutDBManager extends DBManager{

    public WorkoutDBManager() throws Exception{
        super();
    }

    public void createWorkout(Workout workout) throws Exception{
        String query = "insert into workout (NumberID, BrukerID, varighet, PersonligForm, prestasjon, notat, dato)" +
                " values (:NumberID:, :BrukerID:, :varighet:, :PersonligForm:, :prestasjon:, :notat:, :dato:);";

        NamedParameterStatement statement =
                new NamedParameterStatement(query, connection);
        statement.setInt("NumberID", workout.getId());
        statement.setInt("BrukerID", workout.getUser());
        statement.setDouble("varighet", workout.getDuration());
        statement.setInt("PersonligForm", workout.getFitnessLevel());
        statement.setInt("prestasjon", workout.getPerformance());
        statement.setString("notat", workout.getNote());
        statement.setDate("dato", workout.getDate());
        statement.getStatement().executeUpdate();
    }

    public List<Workout> getWorkoutsByUserId(int userID) throws Exception{
        String query = "select NumberID, BrukerID, varighet, PersonligForm, prestasjon, notat, dato from workout" +
                " where brukerId = :brukerId: ;";

        NamedParameterStatement statement = new NamedParameterStatement(query, connection);
        statement.setInt("brukerId", userID);
        ResultSet result = statement.getStatement().executeQuery();

        List<Workout> workouts = new ArrayList<Workout>();
        while(result.next()) {
            workouts.add(new Workout(
                    result.getInt("NumberID"),
                    result.getInt("BrukerID"),
                    result.getDouble("varighet"),
                    result.getInt("PersonligForm"),
                    result.getInt("prestasjon"),
                    result.getString("notat"),
                    result.getDate("dato")
            ));
        }
        return workouts;
    }

    public List<Workout> getLastNWorkouts(int userID, int n) throws Exception{
        String query = "select NumberID, BrukerID, varighet, PersonligForm, prestasjon, notat, dato from workout" +
                " where brukerId = :brukerId: ;";

        NamedParameterStatement statement = new NamedParameterStatement(query, connection);
        statement.setInt("brukerId", userID);
        ResultSet result = statement.getStatement().executeQuery();

        List<Workout> workouts = new ArrayList<Workout>();
        while(result.next() && workouts.size() < n) {
            workouts.add(new Workout(
                    result.getInt("NumberID"),
                    result.getInt("BrukerID"),
                    result.getDouble("varighet"),
                    result.getInt("PersonligForm"),
                    result.getInt("prestasjon"),
                    result.getString("notat"),
                    result.getDate("dato")
            ));
        }
        System.out.println("Got " + workouts.size() + " workouts. Wanted the last " + n);
        return workouts;
    }

    public void addExerciseToWorkout(int exerciseID, int workoutID, int Kilo, int Reps) throws Exception{
        String query = "insert into ØtilhørerW (ØvelseID, WorkoutID, Kilo, Reps)" +
                " values (:ØvelseID:, :WorkoutID:, :Kilo:, :Reps:);";

        NamedParameterStatement statement =
                new NamedParameterStatement(query, connection);
        statement.setInt("ØvelseID", exerciseID);
        statement.setInt("WorkoutID", workoutID);
        statement.setInt("Kilo", Kilo);
        statement.setInt("Reps", Reps);
        statement.getStatement().executeUpdate();
    }

    public List<Integer> getWorkoutFromDates(String from, String to, int userid) throws Exception {
        String query = "select NumberID from Workout where BrukerID ="+userid+" and dato >'"+from+"' and dato<'"+to+"';";
        Statement stmt = connection.createStatement();
        System.out.println(query);
        ResultSet resultSet = stmt.executeQuery(query);

        List<Integer> workouts = new ArrayList<>();
        while (resultSet.next()) {
            workouts.add(resultSet.getInt("NumberID"));
        }
        return workouts;
    }

}
