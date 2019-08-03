package Menus;


import java.util.Scanner;

import Users.Admin;
import items.Account;
import items.ApprovedAccounts;

public class AdminMenu {
	static Scanner sc = new Scanner(System.in);
	private static String[] optionsArray1 = {"1. Find an account and perform an action on it", "2. Return to prior menu (logout)."};
	private static String[] optionsArray2 = {"1. Deposit", "2. Withdraw", "3. Transfer", "4. Cancel an Account","5. Return to admin menu."};
	private AdminMenu() {};
	
	public static void mainMenu() {
		System.out.println("Welcome, what would you like to do?");
		
		for(int i =0; i<optionsArray1.length;i++) {
			System.out.println(optionsArray1[i]);
		}
		int choice = sc.nextInt();
		firstInputHandler(choice);
	}
	
	public static void actionMenu() {
		for(int i =0; i<optionsArray2.length;i++) {
			System.out.println(optionsArray2[i]);
		}
		int choice = sc.nextInt();
		secondInputHandler(choice);
	}
	
	public static void firstInputHandler(int choice)  {
		boolean flag = true;
		while(flag) {
			
			switch(choice) {
			case 1: 
				System.out.println("Enter a username");
				sc.nextLine();
				String username = sc.nextLine();
				try { 
					ApprovedAccounts.fetchOne(username);
					actionMenu();
				} catch(NullPointerException e) {
					e.printStackTrace();
					System.out.println("Woops account not found.");
				}
				
				flag=!flag;
				break;
			
			case 2:
				MainMenu.mainMenu();
				flag=!flag;
				break;
			}
	}
	}
	public static void secondInputHandler(int choice) {
		boolean flag = true;
		while(flag) {
			
			switch(choice) {
			case 1: 
				System.out.println("Deposit");
				Admin.deposit();
				flag=!flag;
				break;
			case 2:
				System.out.println("Withdraw");
				Admin.withdraw();
				flag=!flag;
				break;
			case 3:
				System.out.println("Transfer");
				flag=!flag;
				break;
			case 4:
				System.out.println("Cancel");
				flag=!flag;
				break;
			case 5:
				MainMenu.mainMenu();
			default: 
				System.out.println("Select an option.");
				flag=!flag;
				break;
			}
		}
	}
}
