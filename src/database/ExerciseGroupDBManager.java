package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ExerciseGroup;
import model.Exercise;

public class ExerciseGroupDBManager extends DBManager{

	public ExerciseGroupDBManager() throws Exception {
		super();
	}
	
	public void createExerciseGroup(ExerciseGroup exerciseGroup) throws SQLException {
		String query = "insert into ØvelseGruppe (ØvelsegruppeID, Navn)" +
				" values (:ØvelsegruppeID:, :Navn:);";

		NamedParameterStatement statement =
		new NamedParameterStatement(query, connection);
		statement.setString("ØvelsegruppeID", Integer.toString(exerciseGroup.getId()));
		statement.setString("Navn", exerciseGroup.getName());
		statement.getStatement().executeUpdate();
	}

	public void addExerciseToGroup(ExerciseGroup exerciseGroup, Exercise exercise) throws SQLException{
		String query = "insert into ØtilhørerG (ØvelsegruppeID, ØvelseID)" +
				" values (:ØvelsegruppeID:, :ØvelseID:);";

		NamedParameterStatement statement =
		new NamedParameterStatement(query, connection);
		statement.setString("ØvelsegruppeID", Integer.toString(exerciseGroup.getId()));
		statement.setString("ØvelseID", Integer.toString(exercise.getId()));
		statement.getStatement().executeUpdate();
	}
	
}
