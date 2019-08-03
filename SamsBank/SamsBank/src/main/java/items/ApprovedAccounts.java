package items;


import java.io.Serializable;
import java.util.ArrayList;
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
	static HashMap<String, Account> approvedAccounts = new HashMap<String, Account>();
	private static Scanner sc = new Scanner(System.in);
	private static final Admin admin = new Admin();
	private static final Employee emp = new Employee();
//	private static Logger log = Logger.getLogger(ApprovedAccounts.class);
	
	// add test peoples
	public static void addDummies() {
		addOne("testa", new Account("testa","testa",10000,"testa","testa"));
		PendingAccounts.addOne("testp", new Account("testp","testp",10000,"testp","testp"));
	}
	public static void addAll(Object obj) {
		ArrayList<Object> approvedList = new ArrayList<Object>();
		approvedList.add(obj);
		
		for(Object object: approvedList) {
			Account cast = (Account) object;
			approvedAccounts.put(cast.getUsername(), cast);
		}
		
	}
	// methods for approved accounts hashmap
	public static void addOne(String username, Account account) {
		approvedAccounts.put(username, account);
		Persistence.writeData(account, "approvedaccounts");
		System.out.println("Put into approved accounts.");
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
				 account = approvedAccounts.get(u);
			}
			else {
				System.out.println("Account not found.");
				MainMenu.mainMenu();
			}
			}
		return account;
		
	}
	public static void removeOne(String username) {
		Account a = fetchOne(username);
		if(a!=null) {
			approvedAccounts.remove(username);
			Persistence.updateApprovedData(a);
		}
			else {
				System.out.println("Account not found");
				AdminMenu.mainMenu();
			}
		}
	
	// login methods
	public static void customerLogin() {
		Account a = null;
		sc.nextLine();
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");

		String u = "";
		String pw = "";
		
			try {
				u += usernamePW[0];
				pw += usernamePW[1];
				a = fetchOne(u);
				if(a==null) {
					System.out.println("No user found.");
					MainMenu.mainMenu();
				}
				else if(pw.equals(a.getPassword())){
					CustomerMenu.actionMenu(a);
				}
				else {
					System.out.println("Incorrect password.");
					MainMenu.mainMenu();
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				System.out.println("Enter username + space + password");
			} 
		}
		
	public static void employeeLogin() {
		sc.nextLine();
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");

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
			EmployeeMenu.actionMenu();
		}
		else {
			System.out.println("Incorrect login creds");
			MainMenu.firstLoginMenu();
		}
	}
	public static void adminLogin() {
		String u = "";
		String pw ="";
		System.out.println("Enter a username and password separated by a space");
		String usernamePW[] = sc.nextLine().split("\\s+");
		try {
			u += usernamePW[0];
			pw += usernamePW[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Enter username + space + password");
		}
			if(u.equals(admin.getUsername()) && pw.equals(admin.getPassword())) {
			System.out.println("Login success");
			AdminMenu.mainMenu();
		}
		else {
			System.out.println("Incorrect login creds");
			MainMenu.firstLoginMenu();
		}
	}
	
	
}
