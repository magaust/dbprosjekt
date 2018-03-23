package database;

import model.Exercise;
import model.Workout;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * private int id;
 private String name;
 private String description;
 *
 */

public class ExerciseDBManager extends DBManager {

    public ExerciseDBManager() throws Exception{
        super();
    }

    public void createExercise(Exercise exercise) throws Exception{
        String query = "insert into Øvelse (ØvelseID, Navn, Beskrivelse, ApparatØvelse)" +
                " values (:ØvelseID:, :Navn:, :Beskrivelse:, :ApparatØvelse:);";

        NamedParameterStatement statement = new NamedParameterStatement(query, connection);
        statement.setInt("ØvelseID", exercise.getId());
        statement.setString("Navn", exercise.getName());
        statement.setString("Beskrivelse", exercise.getDescription());
        if(exercise.getIsMachine()){
            statement.setInt("ApparatØvelse", 1);
        }
        else{
            statement.setInt("ApparatØvelse", 0);
        }

        statement.getStatement().executeUpdate();
    }


    public void getResultLog() throws Exception {

    }

    public List<String> getExerciseByGroupId(int ExerciseGroupId) throws Exception{
        String query = "select E.Navn from øvelseGruppe as EG  inner join ØtilhørerG as EBG on EG.ØvelsegruppeID = EBG.ØvelsegruppeID" +
                " inner join Øvelse as E on E.ØvelseID = EBG.ØvelseID" +
                " where EG.ØvelsegruppeID = :ØvelsegruppeID:;";

        NamedParameterStatement statement = new NamedParameterStatement(query, connection);
        statement.setInt("ØvelsegruppeID", ExerciseGroupId);
        ResultSet result = statement.getStatement().executeQuery();

        List<String> exercises = new ArrayList<>();
        while(result.next()) {
            exercises.add(result.getString("Navn"));
        }
        return exercises;
    }

    public void addMachineToExercise(int machineId, int exerciseId) throws Exception {
        String query = "insert into ØbrukerA (ApparatID, ØvelseID)" +
                " values (:ApparatID:, :ØvelseID:);";

        NamedParameterStatement statement = new NamedParameterStatement(query, connection);
        statement.setInt("ApparatID", machineId);
        statement.setInt("ØvelseID", exerciseId);

        statement.getStatement().executeUpdate();
    }
  
    public int getNumberOfExercisesWithMachine(int id) throws Exception{
        String query = "select count(ØvelseID) as NumberOfExercies from ØbrukerA as EUM where EUM.ApparatID ="+id+";";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int n=0;
        if(rs.next()){
            n = rs.getInt("NumberOfExercies");
        }
        return n;
    }


}
