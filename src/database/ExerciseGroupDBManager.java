package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public void addExerciseToGroup(int exerciseGroupId, int exerciseId) throws SQLException{
		String query = "insert into ØtilhørerG (ØvelsegruppeID, ØvelseID)" +
				" values (:ØvelsegruppeID:, :ØvelseID:);";

		NamedParameterStatement statement =
		new NamedParameterStatement(query, connection);
		statement.setInt("ØvelsegruppeID", exerciseGroupId);
		statement.setInt("ØvelseID", exerciseId);
		statement.getStatement().executeUpdate();
	}

	public List<String> getAllExerciseGroups() throws SQLException {
		String query = "select navn, ØvelsegruppeID from ØvelseGruppe";

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<String> ExerciseGroups = new ArrayList<>();
		while (rs.next()) {
			String name = rs.getString("navn");
			String id = Integer.toString(rs.getInt("ØvelsegruppeID"));
			ExerciseGroups.add(name +" : "+id);
		}
		return ExerciseGroups;
	}
	
}
