package Users;

public class Admin extends Employee {
	private final String username="admin";
	private final String password="admin";

	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean deposit() {
		System.out.println("Deposit inside of admin");
		return true;
	};
	public static boolean withdraw() {
		System.out.println("withdraw inside of admin");
		return true;
	};
	public static  boolean transfer() {
		System.out.println("transfer inside of admin");
		return true;
	};
	public static boolean cancelAccount() {
		System.out.println("cancel inside of admin");
		return true;
	}

	public  String getUsername() {
		return username;
	}

	public  void setUsername(String username) {
		this.username = username;
	}

	public  String getPassword() {
		return password;
	}

	public  void setPassword(String password) {
		this.password = password;
	};
	
	
	
}
