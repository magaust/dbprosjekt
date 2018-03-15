import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBManager {

	public DBManager() {
		try {
			//opprett en connection til mySQL serveren
			Connection connection = DriverManager.getConnection(
				//lager en connection til en server på localhost på port 3306
				//med en database som heter sys, med brukernavn root og passord root
				"jdbc:mysql://localhost:3306/sys", "root", "root");


			//lag et sql statement
			Statement SQLStatement = connection.createStatement();
			String select = "select LastName, FirstName from persons";

			//kjør statement
			ResultSet resultSet = SQLStatement.executeQuery(select);

			System.out.println("The results are: ");
			//loop over alle resultatene
			while(resultSet.next()) {
				String fName = resultSet.getString("FirstName");
				String lName = resultSet.getString("LastName");

				System.out.println(fName + "  " + lName);
			}

			//close ut alle ressurser
			ResultSet.close();
			SQLStatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Errer connecting");
			e.printStackTrace();
		}
	}
}