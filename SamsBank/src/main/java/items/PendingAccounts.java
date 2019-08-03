package items;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import Menus.MainMenu;

public class PendingAccounts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7812411237134521524L;
	static HashMap<String, Account> pendingAccounts = new HashMap<String, Account>();
	private static Scanner sc = new Scanner(System.in);
	private static Logger log = Logger.getLogger(ApprovedAccounts.class);
	
	// methods for pending accounts hashmap
		public static void addOne(String username, Account account) {
			pendingAccounts.put(username,account);
			System.out.println("User added.");
			log.info(account.toString() + " added to pending accounts.");
		}
		
		public static void fetchAll(){
			Set<String> keys = pendingAccounts.keySet();
			for(String u: keys) {
				System.out.println("All Users");
				System.out.println("Username: " + u);
			}
		}
		public static Account fetchOne(String username) {
			Set<String> keys = pendingAccounts.keySet();
			System.out.println("Username: " + username);
			Account account = null;
			for (String u: keys) {
				if(username.equals(u)) {
					System.out.println("Account found");
					account = pendingAccounts.get(u);
					 System.out.println(account.toString());
					 log.info(account.toString() + " fetched from pending accounts.");
					
				}
				else {
					System.out.println("Account not found.");
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
//					log.info(account.toString() + " removed from pending accounts.");
				}
				else {
					System.out.println("Account not found.");
					MainMenu.mainMenu();
				}
			}
		}
		
		public static Account createNewUser() {
			
			System.out.println("Enter a username.");
//			sc.nextLine();
			String username = sc.nextLine();
			System.out.println("Enter a password.");
			String pw = sc.nextLine();
			System.out.println("Enter first name.");
			String firstname = sc.nextLine();
			System.out.println("Enter last name.");
			String lastname = sc.nextLine();
			System.out.println("Enter a balance");
			double balance = sc.nextDouble();
			Account newAccount = new Account(username,pw,balance,firstname,lastname);
			System.out.println(newAccount.toString());
			log.info(newAccount.toString() + " account created... and is now pending");
			System.out.println("Your account is pending.");
			addOne(username, newAccount);
			MainMenu.firstLoginMenu();
			return newAccount;
		}
		
}
