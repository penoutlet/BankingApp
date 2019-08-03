package Menus;


import java.util.Scanner;

import items.ApprovedAccounts;
import items.UtilityMenus;


public class CustomerMenu  {
	static Scanner sc = new Scanner(System.in);
	private static String[] optionsArray = {"0. Apply for an account.", "1. Deposit", "2. Withdraw", "3. Transfer", "4. Cancel an Account","5. Return to previous menu"};
	
	public static void loginMenu() {
		ApprovedAccounts.customerLogin();
	}
	
	public static void actionMenu() {
		
		System.out.println("Welcome customer, what would you like to do?");
		
		for(int i =0; i<optionsArray.length;i++) {
			System.out.println(optionsArray[i]);
		}
		
		int choice = sc.nextInt();
		CustomerMenu.handleInput(choice);
		
	}
	
	public static void handleInput(int choice) {
		System.out.println("Choice was " + choice);
		boolean flag = true;
		while(flag) {
			
			switch(choice) {
			case 0: 
				
			case 1: 
				UtilityMenus.depositMenu();
				flag=!flag;
				break;
			case 2:
				UtilityMenus.withdrawMenu();
				flag=!flag;
				break;
			case 3:
				UtilityMenus.transferMenu();
				flag=!flag;
				break;
			case 4:
				UtilityMenus.cancelAccount();
				flag=!flag;
				break;
			case 5:
				MainMenu.mainMenu();;
				flag=!flag;
				break;
			default: 
				System.out.println("Enter 1, 2, or 3.");
				flag=!flag;
				break;
			}
		}
	}
	
	public static void depositMenu() {
		System.out.println("How much would you like to deposit? ");
		double depositAmt = sc.nextDouble();
		sc.next();
		System.out.println("Deposited " + depositAmt);
		CustomerMenu.actionMenu();
//		Customer.deposit();
	}
	
	
}
