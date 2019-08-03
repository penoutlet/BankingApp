package items;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistence {
	ArrayList<Account> loaded = new ArrayList<Account>();
	static String pendingData = "./pendingaccounts.txt";
	static String approvedData = "./approvedaccounts.txt";
	public static void updatePendingData(Account pendingNoMore) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(pendingData))) {
	        writer.writeObject(pendingNoMore);
	        writer.flush();
	        writer.close();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void updateApprovedData(Account pendingNoMore) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(approvedData))) {
	        writer.writeObject(pendingNoMore);
	        writer.flush();
	        writer.close();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
	public static void writeData(Account pending, String whichList) {
		String filename = "";
		if (whichList.equals("pendingaccounts")) {
			filename += pendingData;

		} else if (whichList.equals("approvedaccounts")) {
			filename += approvedData;
		} else {
			System.out.println("Please provide a correct input for writeData.");
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(pending);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeData(ArrayList<Account> pendingList, String whichList) {
		String filename = "";
		if (whichList.equals("pendingaccounts")) {
			filename += pendingData;

		} else if (whichList.equals("approvedaccounts")) {
			filename += approvedData;
		} else {
			System.out.println("Please provide a correct input for writeData.");
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(pendingList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object readData(String filenamePending, String filenameApproved) {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filenamePending))) {
			Object pendingList = ois.readObject();
			//add pending to the pending hashmap
			PendingAccounts.addAll(pendingList);
//			System.out.println(pendingList);
			return pendingList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filenameApproved))) {
			Object approvedList = ois.readObject();
			//add approved to approved hashmap
//			System.out.println(approvedList);
			return approvedList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static Object readData(String filename) {


		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object pendingList = ois.readObject();
//			System.out.println(pendingList);
			return pendingList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
