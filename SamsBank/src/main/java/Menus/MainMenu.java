package Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import items.Account;
import items.ApprovedAccounts;
import items.PendingAccounts;

public class MainMenu {
	static Scanner sc = new Scanner(System.in);
	static String[] optionsArray = { "1. Customer", "2. Employee", "3. Admin", "4. Return to login menu." };
	private static Logger log = Logger.getLogger(MainMenu.class);

	public static void firstLoginMenu() {
		Account newAccount = null;
		System.out.println("1. Sign up.\n2. Sign in.\n3. Add test dummies.");
		try {
			int newUser = sc.nextInt();
			switch (newUser) {
			case 1:
				newAccount = PendingAccounts.createNewUser();
				// newAccount = ApprovedAccounts.createNewUser();
				break;
			case 2:
				MainMenu.mainMenu();
				break;
			case 3:
				ApprovedAccounts.addDummies();
			default:
				firstLoginMenu();
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
			log.warn(e);
		}
	}

	public static void mainMenu() {
		for (String s : optionsArray) {
			System.out.println(s);
		}
		System.out.println("Please select an option to continue");
		// int choice = sc.nextInt();
		//
		// loginHandler(choice);
		try {
			int choice = sc.nextInt();
			loginHandler(choice);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			log.warn(e);
		}
	}

	public static void loginHandler(int choice) {
		boolean flag = true;
		while (flag) {

			switch (choice) {
			case 1:
				CustomerMenu.loginMenu();
				flag = !flag;
				break;
			case 2:
				ApprovedAccounts.employeeLogin();
				flag = !flag;
				break;
			case 3:
				ApprovedAccounts.adminLogin();
				flag = !flag;
				break;
			case 4:
				firstLoginMenu();
			default:
				System.out.println("Select a choice.");
				MainMenu.mainMenu();
				flag = !flag;
				break;
			}
		}
	}
}
