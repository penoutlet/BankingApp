package items;

public class Serialization {
/* 
 * storing garbage here for now
 */
	
	package com.example.serialization;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;

	public class MyClass {

		/*
		 * Serialization - is the mechanism of converting the state(s) of an object into
		 * byte stream and persisting in a text file
		 * 
		 * Deserialization - reverse process, byte stream is used to recreate the actual
		 * Java object in memory
		 * 
		 * To make this happen: Serializable interface - marker interface (interface
		 * with 0 methods) (functional interface is an interface with exactly one
		 * method)
		 * 
		 * The ObjectOutputStream class contains the writeObject() method for
		 * serializing an object The ObjectInputStream class contains the readObject()
		 * method for deserializing an object
		 */

		public static void main(String[] args) {
			String filename = "./pendingaccounts.txt";
			static HashMap<String, Account> pendingAccounts = new HashMap<String, Account>();
			writeObject(filename, pendingAccounts);
			readObject(filename);
		}

		public static void writeObject(String filename, Object obj) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
				oos.writeObject(obj);
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}

		public static void readObject(String filename) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
				Object obj = ois.readObject();
				System.out.println(obj);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public static void runSerialize() {
			String filename = "./pendingaccounts.txt";
			static HashMap<String, Account> pendingAccounts = new HashMap<String, Account>();
			writeObject(filename, pendingAccounts);
			readObject(filename);
		}
		
	}

}
