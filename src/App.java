import model.ExcerciseGroup;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("test");
		//DBManager db = new DBManager();
		while(true){
			homeScreen();
		}
	}
	public static void homeScreen(){
		Scanner s = new Scanner(System.in);
		try{
			System.out.println("Choose one alt:");
			System.out.println("1: Create machine, excercise, Excercise Group or workout");
			System.out.println("2: Get information of n number of last completed excercises");
			System.out.println("3: See a resultlog for one specified excercise");
			System.out.println("4: Find excercises in a excercise group");
			System.out.println("5: Use case");
			System.out.print(">>>");
			int choice = s.nextInt();
			if(choice < 1 && choice > 5){
				System.out.println("Du må velge mellom 1 og 5, prøv på nytt");
				homeScreen();
			}
			if(choice == 1) {
				method1();
			}
			else if (choice == 2) {
				method2();
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

	public static void method1(){
		Scanner s = new Scanner(System.in);
		System.out.println("Choose 1 for machine");
		System.out.println("Choose 2 for excercise");
		System.out.println("Choose 3 for excercise group");
		System.out.println("Choose 4 for workout");
		System.out.print(">>>");
		int choice = s.nextInt();
		if(choice < 1 && choice > 4) {
			System.out.println("Between 1 and 4 only");
		}
		if(choice == 1) {
			method1();
		}
		else if (choice == 2) {
			method2();
		}
	}

	public static void method2(){
		System.out.println("This is method 2, returning home");
	};

}