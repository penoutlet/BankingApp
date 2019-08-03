package items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import Menus.MainMenu;

public class PendingAccounts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7812411237134521524L;
	static HashMap<String, Account> pendingAccounts = new HashMap<String, Account>();
	private static Scanner sc = new Scanner(System.in);
	
	// methods for pending accounts hashmap
	
	public static void addAll(Object obj) {
		ArrayList<Object> pendingList = new ArrayList<Object>();
		pendingList.add(obj);
		
		for(Object object: pendingList) {
			Account cast = (Account) object;
			pendingAccounts.put(cast.getUsername(), cast);
		}
//		pendingList.addAll((ArrayList<Account>) obj);
//		HashMap<String, Account>(HashMap<String, Account>) obj;
//		for(Entry<String, Account> en: obj.entrySet()) {
//			pendingAccounts.put(en.getKey(), en.getValue());
//		}
		
	}
	
//	public static void addAll(Object obj) {
//		ArrayList<Account> pendingList = new ArrayList<Account>();
//		pendingList.addAll((ArrayList<Account>) obj);
////		HashMap<String, Account>(HashMap<String, Account>) obj;
////		pendingAccounts.putAll(obj);
//		
//	}
		public static void addOne(String username, Account account) {
			if(fetchOne(username)==null) {
				pendingAccounts.put(username,account);
				Persistence.writeData(account, "pendingaccounts");
			}
			else {
				System.out.println("Username already in use.");
			}
		}
		
		public static ArrayList<Account> fetchAll(){
			ArrayList<Account> pendingList = new ArrayList<Account>();
			Set<String> keys = pendingAccounts.keySet();
			for(String key: keys) {
				System.out.println(fetchOne(key).toString());
			}
			System.out.println("All Users");
			if(pendingAccounts.isEmpty()) {
				System.out.println("No pending accounts.");
			}
			
			
			return pendingList;
		}
		public static Account fetchOne(String username) {
			Set<String> keys = pendingAccounts.keySet();
			System.out.println("Username: " + username);
			Account account = null;
			for (String u: keys) {
				if(username.equals(u)) {
					System.out.println("Fetched");
					account = pendingAccounts.get(u);
					
				}
				else {
//					System.out.println("No user found.");
				}
				}
			return account;
			
		}
		
		public static void removeOne(String username) {
			Set<String> keys = pendingAccounts.keySet();
			Account a = fetchOne(username);
			if(a!=null) {
				
					pendingAccounts.remove(a.getUsername());
					Persistence.updatePendingData(a);
				}
				else {
					System.out.println("Account not found.");
					MainMenu.mainMenu();
				}
			}
		
		public static Account createNewUser() {
			Account newAccount = null;
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
			System.out.println("Joint account? 1 for yes, 2 for no.");
			int joint = sc.nextInt();
			switch(joint) {
			case 1:
				System.out.println("Enter a second username");
				sc.nextLine();
				String username2 = sc.nextLine();
				newAccount = new Account(username,pw,balance,firstname,lastname,username2);
				addOne(username2, newAccount); //adds an extra duplicate account as value
				break;
			case 2:
				newAccount = new Account(username,pw,balance,firstname,lastname);
//				System.out.println(newAccount.toString());
				
			}
			addOne(username, newAccount);
			MainMenu.firstLoginMenu();
			return newAccount;
		}
		
		
		
}
