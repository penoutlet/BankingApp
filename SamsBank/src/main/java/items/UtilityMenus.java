package items;

import java.util.Scanner;

import Menus.CustomerMenu;

public class UtilityMenus {
	static Scanner sc = new Scanner(System.in);
	
	public static void depositMenu() {
		System.out.println("How much would you like to deposit? ");
		double depositAmt = sc.nextDouble();
		sc.next();
		System.out.println("Deposited " + depositAmt);
		CustomerMenu.actionMenu();
//		Customer.deposit();
	}
	
	public static void withdrawMenu() {
		System.out.println("How much to withdraw?");
		double withdrawalAmt = sc.nextDouble();
		sc.next();
		System.out.println("Withdrawing " + withdrawalAmt);
		CustomerMenu.actionMenu();
	}
	
	public static void transferMenu() {
		System.out.println("How much to transfer?");
		double transferAmt = sc.nextDouble();
		sc.next();
		System.out.println("Transfer to who? Enter a username.");
		String username = sc.nextLine();
		sc.next();
		Account account = ApprovedAccounts.fetchFromApprovedAccounts(username);
		if(account!= null) {
			System.out.println("Transfer success");
			System.out.println("Transferring " + transferAmt);
		}
		else {
			System.out.println("Cannot transfer to that user; user not found.");
		}
	}
	
	public static void cancelAccount() {
		System.out.println("Cancel whom? Enter a username.");
		String cancelled = sc.nextLine();
		sc.next();
		Account fetched = ApprovedAccounts.fetchFromApprovedAccounts(cancelled);
		if(fetched!=null) {
			System.out.println("Cancelled.");
//			ApprovedAccounts.remove(account) 
			ApprovedAccounts.removeFromApprovedAccounts(fetched.getUsername());
		}
	}
}
