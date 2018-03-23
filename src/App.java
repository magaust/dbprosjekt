import model.*;
import database.*;
import model.TrainingDiary;
import utilities.DataGenerator;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		UserDBManager userDBManager;
		Scanner s;
		User user;
		TrainingDiary diary;
		try {
			DataGenerator gen = new DataGenerator();
			//gen.generateAllData();
			diary = new TrainingDiary(gen.user);
			diary.run();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}