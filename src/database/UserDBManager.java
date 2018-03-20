import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDBManager extends DBManager {

	public UserDBManager() throws Exception{
		super();
	}

	public void createUser(User user) {
		String query = "insert into bruker (brukerId, navn)" +
				" values (:brukerId:, :navn:);";

		NamedParameterStatement statement = 
		new NamedParameterStatement(query, connection);
		statement.setString("brukerId", user.getID.toString());
		statement.setString("navn", user.getName());
		statement.getStatement().executeUpdate();
	}
}