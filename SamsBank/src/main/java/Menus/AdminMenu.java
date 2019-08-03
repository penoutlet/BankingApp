package Menus;


import java.util.Scanner;

import items.Account;
import items.ApprovedAccounts;
import items.UtilityMenus;

public class AdminMenu {
	static Scanner sc = new Scanner(System.in);
	private static String[] optionsArray1 = {"0. View an account.","1. Find an account and perform an action on it", "2. Return to prior menu (logout)."};
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
	
	public static void actionMenu(Account a) {
		for(int i =0; i<optionsArray2.length;i++) {
			System.out.println(optionsArray2[i]);
		}
		int choice = sc.nextInt();
		secondInputHandler(choice, a);
	}
	
	public static void firstInputHandler(int choice)  {
		boolean flag = true;
		while(flag) {
			
			switch(choice) {
			case 1: 
				System.out.println("Enter a username");
				sc.nextLine();
				String username = sc.nextLine();
				Account a = ApprovedAccounts.fetchOne(username);
				if(a==null) {
					System.out.println("No such user exists.");
					AdminMenu.mainMenu();
				} 
				actionMenu(a);
//				try { 
//					Account a = ApprovedAccounts.fetchOne(username);
//					actionMenu(a);
//				} catch(NullPointerException e) {
//					e.printStackTrace();
//					System.out.println("Woops account not found.");
//				}
				
				flag=!flag;
				break;
			
			case 2:
				MainMenu.mainMenu();
				flag=!flag;
				break;
			}
	}
	}
	public static void secondInputHandler(int choice, Account a) {
		boolean flag = true;
		while(flag) {
			
			switch(choice) {
			case 0:
				System.out.println(a.toString());
				break;
			case 1: 
				UtilityMenus.adminDepositMenu(a);
				flag=!flag;
				break;
			case 2:
				UtilityMenus.adminWithdrawMenu(a);
				flag=!flag;
				break;
			case 3:
				UtilityMenus.adminTransferMenu(a);
				flag=!flag;
				break;
			case 4:
				UtilityMenus.adminCancelMenu(a);
				flag=!flag;
				break;
			case 5:
				AdminMenu.mainMenu();
				flag=!flag;
				break;
			default: 
				System.out.println("Select an option.");
				flag=!flag;
				break;
			}
		}
	}
}
