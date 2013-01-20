/*
 * Program: Account.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 17, 2013
 * Purpose: set up the standard attributes for all types of banking
 * accuonts. Includes the set up on the initial date, interest rate, balances.
 */

package Ch11.Lab2;

import java.util.Date;

public class Account {
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated, dateAccessed;
	
	public Account(){
		dateCreated = new Date();
	}
	
	public Account(int newId, double newBalance){
		id = newId;
		balance = newBalance;
		dateCreated = new Date();
	}
	
	public Account(int newId, double newBalance, double interestRate){
		id = newId;
		balance = newBalance;
		annualInterestRate = interestRate;
		dateCreated = new Date();
	}
	
	public int getId(){
		return id;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	public Date getDateCreated(){
		return dateCreated;
	}
	
	public Date getDateAccessed(){
		return dateAccessed;
	}
	
	public void setId(int newId){
		id = newId;
	}
	
	public void setBalance(double newBalance){
		balance = newBalance;
	}
	
	public void setAnnualInterstRate(double newAnnualInterestRate){
		annualInterestRate = newAnnualInterestRate;
	}
	
	public void setDateAccessed(Date newDate){
		dateAccessed = newDate;
	}
	
	public double getMonthlyInterest(){
		return balance * (annualInterestRate / 1200);
	}
	
	public void withdraw(double amount){
		balance -= amount;
	}
	
	public void deposit(double amount){
		balance += amount;
	}

}
