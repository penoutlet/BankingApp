package Users;
import items.Account;

public class Customer extends User {
	
	Account account;
	String customerID;
	boolean isApproved=false;
	
	
	
	
	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	protected Customer(String username, String password, String firstName, String lastName, Account account) {
		super(username, password, firstName, lastName);
		this.account = account;
	}
	
	public static Account createAccount(String accountType, String username, String username2) {
		Account newAccount = null;
		if(accountType.toLowerCase()=="single") {
			newAccount = new Account(username, accountType);
		}
		else if(accountType.toLowerCase()=="joint") {
			newAccount = new Account(username, "joint", username2);
		}
		newCustomer.setAccount(newAccount);
		return newAccount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String getCustomerID() {
		return this.customerID;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
}
