import model.*;

class app {

	public static void main(String[] args) {
		System.out.println("test");

		DBManager db = new DBManager();
		UserDBManager userDBManager = new UserDBManager();
		userDBManager.createUser(new User(5, "Øivind ;^)"));
	}
}