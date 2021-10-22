package javaATM;

import java.util.*;
import javax.swing.JOptionPane;

public class ATM {
  
	static int one, five; 
	static int atmbalance;
	static ArrayList <String>log = new ArrayList<>();
	
	public ATM() {
		one = 1000; five = 200;
		atmbalance = one*10000+five*50000;
	}
	
	
	static void Deposit(DataBase db, String id, long cash) {
		atmbalance =one*10000+five*50000;
		db.setBalance(id, db.getBalance(id) + cash);
		log.add(id + " deposit: " + String.valueOf(cash)+"\n");
		System.out.printf("atm status:%d\n",atmbalance);
	

	}
	
	static void WithDraw(DataBase db, String id, long cash) {
		atmbalance =one*10000+five*50000;
		db.setBalance(id, db.getBalance(id) - cash);
		log.add(id + " withdraw: " + String.valueOf(cash)+"\n");
		System.out.printf("atm status:%d\n",atmbalance);
	}
	
	static long DisplayCash(DataBase db, String id) {
		return db.getBalance(id);
	}

	static void LogPrint(int idx){
		System.out.printf(log.get(idx));

	}

	}