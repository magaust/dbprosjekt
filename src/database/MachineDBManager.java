package database;

import java.sql.SQLException;
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

	public List<String> getAllMachines() throws SQLException {
		String query = "select navn, ApparatID";
	}



}
