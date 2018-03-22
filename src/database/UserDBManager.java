package database;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDBManager extends DBManager {

	public UserDBManager() throws Exception{
		super();
	}

	//creates a new row in the user table
	public void createUser(User user) throws SQLException {
		String query = "insert into bruker (brukerId, navn)" +
				" values (:brukerId:, :navn:);";

		NamedParameterStatement statement =
		new NamedParameterStatement(query, connection);
		statement.setString("brukerId", Integer.toString(user.getID()));
		statement.setString("navn", user.getName());
		statement.getStatement().executeUpdate();
	}

	//get a user by its id
	public User getUser(int brukerID) throws Exception{
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
}