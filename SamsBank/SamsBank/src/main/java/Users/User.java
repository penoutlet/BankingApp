package Users;

import java.util.Scanner;

import items.Account;
import menus.AdminMenu;
import menus.EmployeeMenu;

public class User {
	static Scanner sc = new Scanner(System.in);
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	
	
}
