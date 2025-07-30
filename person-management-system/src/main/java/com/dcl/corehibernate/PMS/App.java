package com.dcl.corehibernate.PMS;

import java.util.Scanner;

import com.dcl.corehibernate.controller.PersonDao;

public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PersonDao pd = new PersonDao();
		System.out.println("---------------Person Data Management System---------------");
		while (true) {
			System.out.println();
			System.out.println("+++++++++++++++ Select your choice +++++++++++++++");
			System.out.println("1. Add Person");
			System.out.println("2. Display all persons");
			System.out.println("3. Find person by Id");
			System.out.println("4. Update person age by Id");
			System.out.println("5. Update person city by Id");
			System.out.println("6. Update person Email by Id");
			System.out.println("7. Update person Mobile by Id");
			System.out.println("8. Delete person by Id");
			System.out.println("9. Exit");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				pd.addPerson();
				break;
			case 2:
				pd.displayAllPerson();
				break;
			case 3:
				pd.findPersonById();
				break;
			case 4:
				pd.updatePersonAgeById();
				break;
			case 5:
				pd.updatePersonCityById();
				break;
			case 6:
				pd.updatePersonEmailById();
				break;
			case 7:
				pd.updatePersonMobileById();
				break;
			case 8:
				pd.deletePersonById();
				break;
			case 9:
				System.out.println("Exited from Person Data Management System");
				System.exit(0);
			default:
				System.out.println("Enter valid input");
			}
		}
	}
}
