package items;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import Menus.AdminMenu;
import Menus.CustomerMenu;
import Menus.EmployeeMenu;
import Menus.MainMenu;
import Users.Admin;
import Users.Employee;

public class ApprovedAccounts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5878601051619539591L;
	static HashMap<String, Account> pendingAccounts = new HashMap<String, Account>();
	static HashMap<String, Account> approvedAccounts = new HashMap<String, Account>();
	private static Scanner sc = new Scanner(System.in);
	private static final Admin admin = new Admin();
	private static final Employee emp = new Employee();
	private static Logger log = Logger.getLogger(ApprovedAccounts.class);
	
	// add test peoples
	public static void addDummies() {
		approvedAccounts.put("test", new Account("testa","testa",10000,"testa","testa"));
		pendingAccounts.put("test", new Account("testp","testp",10000,"testp","testp"));
	}
	// methods for pending accounts hashmap
//	public static void addToPendingAccounts(String username, Account account) {
//		pendingAccounts.put(username,account);
//		System.out.println("User added.");
//		log.info(account.toString() + " added to pending accounts.");
//	}
//	
//	public static void fetchAllPending(){
//		Set<String> keys = pendingAccounts.keySet();
//		for(String u: keys) {
//			System.out.println("All Users");
//			System.out.println("Username: " + u);
//		}
//	}
//	public static Account fetchFromPendingAccounts(String username) {
//		System.out.println(username);
//		Set<String> keys = pendingAccounts.keySet();
//		Account account = null;
//		for (String u: keys) {
//			if(username.equals(u)) {
//				System.out.println("Account found");
//				account = pendingAccounts.get(u);
//				 System.out.println(account.toString());
//				 log.info(account.toString() + " fetched from pending accounts.");
//			}
//			else {
//				System.out.println("Account not found.1");
//				MainMenu.mainMenu();
//			}
//			}
//		return account;
//		
//	}
//	
//	public static void removeFromPendingAccounts(String username) {
//		Set<String> keys = pendingAccounts.keySet();
//		
//		for (String u: keys) {
//			if(username.equals(u)) {
//				System.out.println("Removing account");
//				pendingAccounts.remove(u);
//				log.info(username + " removed from pending accounts.");
//			}
//			else {
//				System.out.println("Account not found.");
//				MainMenu.mainMenu();
//			}
//		}
//	}
	
	// methods for approved accounts hashmap
	public static void addOne(String username, Account account) {
		approvedAccounts.put(username, account);
		System.out.println("Put into approved accounts.");
		log.info(account.toString() + " added to approved accounts.");
	}
	public static void fetchAll(){
		Set<String> keys = approvedAccounts.keySet();
		for(String u: keys) {
			System.out.println("All Users");
			System.out.println("Username: " + u);
		}
	}
	public static Account fetchOne(String username) {
		Set<String> keys = approvedAccounts.keySet();
		Account account = null;
		for (String u: keys) {
			if(username.equals(u)) {
				System.out.println("Account found");
				 account = approvedAccounts.get(u);
				 System.out.println(account.toString());
					log.info(account.toString() + " fetched from approved accounts.");

			}
			else {
				System.out.println("Account not found");
				MainMenu.mainMenu();
			}
			}
		return account;
		
	}
	public static void removeOne(String username) {
		
	Set<String> keys = pendingAccounts.keySet();
		
		for (String u: keys) {
			if(username.equals(u)) {
				System.out.println("Removing account");
				pendingAccounts.remove(u);
				log.info(username + " removed from pending accounts.");
			}
			else {
				System.out.println("Account not found.");
				MainMenu.mainMenu();
			}
		}
	}
	// login methods
	public static void customerLogin() {
		Account a = null;
		sc.nextLine();
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");

//		if(usernamePW[0] == null || usernamePW[1] == null) {
//			System.out.println("Invalid input provided... enter username + space + password");
//			employeeLogin();
//		}
		String u = "";
		String pw = "";
		try {
			u += usernamePW[0];
			pw += usernamePW[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Enter username + space + password");
		}
			 a = fetchOne(u);
			 
		if(pw.equals(a.getPassword())){
			CustomerMenu.actionMenu();
		}
	}
	public static void employeeLogin() {
		sc.nextLine();
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");

//		if(usernamePW[0] == null || usernamePW[1] == null) {
//			System.out.println("Invalid input provided... enter username + space + password");
//			employeeLogin();
//		}
		String u = "";
		String pw = "";
		try {
			u += usernamePW[0];
			pw += usernamePW[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Enter username + space + password");
		}
		
		
		if(u.equals(emp.getUsername()) && pw.equals(emp.getPassword())) {
			System.out.println("Login success");
			log.info("Employee " + u + " logged in.");
			EmployeeMenu.actionMenu();
		}
		else {
			System.out.println("Incorrect login creds");
			log.info("Employee " + u + " failed login attempt.");
			MainMenu.firstLoginMenu();
		}
	}
	public static void adminLogin() {
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");
		String u = usernamePW[0];
		String pw = usernamePW[1];
			if(u.equals(admin.getUsername()) && pw.equals(admin.getPassword())) {
			System.out.println("Login success");
			log.info("Admin " + u + " logged in.");
			AdminMenu.mainMenu();
		}
		else {
			System.out.println("Incorrect login creds");
			log.info("Admin" + u + " failed login attempt.");
			MainMenu.firstLoginMenu();
		}
	}
	
	
//public static Account createNewUser() {
//		
//		System.out.println("Enter a username.");
////		sc.nextLine();
//		String username = sc.nextLine();
//		System.out.println("Enter a password.");
//		String pw = sc.nextLine();
//		System.out.println("Enter first name.");
//		String firstname = sc.nextLine();
//		System.out.println("Enter last name.");
//		String lastname = sc.nextLine();
//		System.out.println("Enter a balance");
//		double balance = sc.nextDouble();
//		Account newAccount = new Account(username,pw,balance,firstname,lastname);
//		System.out.println(newAccount.toString());
//		log.info(newAccount.toString() + " account created... and is now pending");
//		System.out.println("Your account is pending.");
//		addToPendingAccounts(username, newAccount);
//		MainMenu.firstLoginMenu();
//		return newAccount;
//	}
}
