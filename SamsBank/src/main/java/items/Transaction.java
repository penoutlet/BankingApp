package items;


public class Transaction {
	public String action = "";
	public double amount;
	//write a method that takes in an action as a string as one parameter, and an amount as the second, that handles the following cases:
		// depositing
		/*
		 * withdrawing
		 * transferring
		 * canceling - takes in no amount - this is a privilege that should belong to admin and customers only and not transactions
		 * Transaction.sendTransaction(t);
		 */
	public static boolean sendTransaction(Transaction t) {
		if(t.getAction().equals("deposit")){
			
			
		}
		else if(t.getAction().equals("withdraw")) {
			
		}
		else if(t.getAction().equals("transfer")) {
			
		}
	}
	public Transaction(String action, double amount) {
		// TODO Auto-generated constructor stub
		this.action = action;
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [action=" + action + ", amount=" + amount + "]";
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	
}
