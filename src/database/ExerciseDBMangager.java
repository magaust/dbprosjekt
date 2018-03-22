package database;

import model.Exercise;
import model.Workout;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * private int id;
 private String name;
 private String description;
 *
 */

public class ExerciseDBMangager extends DBManager {

    public ExerciseDBMangager () throws Exception{
        super();
    }

    public void createExercise(Exercise exercise) throws Exception{
        String query = "insert into Øvelse (ØvelseID, Navn, Beskrivelse, ApparatØvelse)" +
                " values (:ØvelseID:, :Navn:, :Beskrivelse:, ApparatØvelse:);";

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
        String query = "select Øvelse.Navn from øvelseGruppe as EG  inner join ØtilhørerG as EBG on EG.ØvelsegruppeID = EBG.ØvelsegruppeID" +
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


}
