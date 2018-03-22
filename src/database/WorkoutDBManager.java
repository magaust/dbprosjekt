package database;

import model.User;
import model.Workout;

import java.sql.ResultSet;

public class WorkoutDBManager extends DBManager{

    public WorkoutDBManager() throws Exception{
        super();
    }

    public void createWorkout(Workout workout) throws Exception{
        String query = "insert into workout (NumberID, BrukerID, varighet, PersonligForm, prestasjon, notat, dato)" +
                " values (:NumberID:, :BrukerID:, :varighet:, :PersonligForm:, :prestasjon:, :notat:, :dato:);";

        NamedParameterStatement statement =
                new NamedParameterStatement(query, connection);
        statement.setString("NumberID", Integer.toString(workout.getId()));
        statement.setString("BrukerID", Integer.toString(workout.getUser().getID()));
        statement.setDouble("varighet", workout.getDuration());
        statement.setInt("PersonligForm", workout.getFitnessLevel());
        statement.setInt("prestasjon", workout.getPerformance());
        statement.setString("notat", workout.getNote());
        statement.setDate("varighet", workout.getDate());
        statement.getStatement().executeUpdate();
    }

    //ikke implementert enda
    /*
    public Workout getWorkout(int workoutID) throws Exception{
        String query = "select navn from bruker" +
                " where brukerId = :brukerId: ;";

        NamedParameterStatement statement = new NamedParameterStatement(query, connection);
        statement.setString("brukerId", Integer.toString(brukerID));
        ResultSet result = statement.getStatement().executeQuery();
        if(!result.first()) { //no User in the result set
            return null;
        } else { //found a User
            return new User(brukerID, result.getString("navn"));
        }
    }
    */
}
