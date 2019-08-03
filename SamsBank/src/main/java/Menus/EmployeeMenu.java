package Menus;

import java.util.Scanner;

import Users.Employee;
import items.Account;
import items.ApprovedAccounts;
import items.PendingAccounts;

public class EmployeeMenu {
	static Scanner sc = new Scanner(System.in);
	static String[] optionsArray = { "1. View an approved account", "2. Approve or deny a pending account.",
			"3. View all usernames of pending accounts.", "4.Return to previous menu (logout)." };

	public static void actionMenu() {
		System.out.println("Welcome employee, what would you like to do?");

		for (int i = 0; i < optionsArray.length; i++) {
			System.out.println(optionsArray[i]);
		}

		int choice = sc.nextInt();
		handleInput(choice);
	}

	public static void handleInput(int choice) throws NullPointerException {
		Account account = null;
		String username = "";
		boolean flag = true;
		while (flag) {

			switch (choice) {
			case 1:
				System.out.println("Enter a username");
				sc.nextLine();
				username += sc.nextLine();
				account = ApprovedAccounts.fetchOne(username);
				if (account != null) {
					actionMenu();
				} else {
					System.out.println("No user found. ");
					actionMenu();
				}
				flag = !flag;
				break;
			case 2:
				System.out.println("Enter a username");
				sc.nextLine();
				username += sc.nextLine();
				System.out.println("username: " + username);
				account = PendingAccounts.fetchOne(username);
				EmployeeMenu.approveOrDenyMenu(account);
				break;
			case 3:
				PendingAccounts.fetchAll();
				EmployeeMenu.actionMenu();
				flag = !flag;
				break;
			case 4:
				MainMenu.mainMenu();
				flag = !flag;
				break;
			case 5:
				MainMenu.mainMenu();
			default:
				System.out.println("Enter 1, 2, or 3.");
			}
		}
	}

	public static void approveOrDenyMenu(Account a) {
		System.out.println("1. Approve\n2. Deny\n3.Return to previous menu");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			Employee.approve(a);
			MainMenu.mainMenu();
			;
			break;
		case 2:
			Employee.deny(a);
		case 3:
			MainMenu.mainMenu();
			;
		}
	}
}
