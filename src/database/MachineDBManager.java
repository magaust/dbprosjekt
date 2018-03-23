package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Machine;

public class MachineDBManager extends DBManager{

	public MachineDBManager() throws Exception{
		super();
	}
	
	public void createMachine(Machine machine) throws SQLException {
		String query = "insert into apparat (ApparatID, navn, brukerBeskrivelse)" +
				" values (:ApparatID:, :navn:, :brukerBeskrivelse:);";

		NamedParameterStatement statement =
		new NamedParameterStatement(query, connection);
		statement.setString("ApparatID", Integer.toString(machine.getId()));
		statement.setString("navn", machine.getName());
		statement.setString("brukerBeskrivelse", machine.getUserDescription());
		statement.getStatement().executeUpdate();
	}

	public List<Machine> getAllMachines() throws Exception{
		String query = "select ApparatID, navn, brukerBeskrivelse from apparat";

		Statement stmnt = connection.createStatement();
		ResultSet results = stmnt.executeQuery(query);

		ArrayList<Machine> machines = new ArrayList<>();

		while(results.next()) {
			machines.add(new Machine(
					results.getInt("ApparatID"),
					results.getString("navn"),
					results.getString("BrukerBeskrivelse")
			));
		}

		return machines;
	}
}
