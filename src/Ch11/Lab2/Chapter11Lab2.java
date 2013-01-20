/*
 * Program: Chapter11Lab2.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 17, 2013
 * Purpose: Create two classes that extend the Account class. 
 * Test both classes for setting up Savings & Checking accounts.
 */

package Ch11.Lab2;

import java.util.Scanner;
import java.util.Date;

public class Chapter11Lab2 {
	
	public static void main(String[] args){

		// create variables, Date and Scanner objects
		int ID, choice =1;
		double checkingBalance, savingBalance, checkingDeposit, checkingWithdrawl, savingDeposit,
			savingWithdrawl, checkingOverage=0;
		Date dateAccessed;
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("\t\tAccount Set Up");
		System.out.println("Enter the ID number");
		ID = keyboard.nextInt();
		
		System.out.println("Enter the initial amount of deposit in your checking account");
		checkingBalance = keyboard.nextDouble();
		
		System.out.println("Enter the initial amount of deposit in your savings account");
		savingBalance = keyboard.nextDouble();
		
		Checkings c1 = new Checkings(ID, checkingBalance);
		System.out.println(c1);
		
		Saving s1 = new Saving(ID, savingBalance);
		System.out.println(s1);
		
		do {
			try {
				System.out.println("\n\n\t\tChoose from the following menu\n\n\t\t1) Deposit to Checking Account \n\n\t\t2) Withdrawl from Checking Account\n\n\t\t3) Deposit to Savings Account\n\n\t\t4) Withdrawl from Savings Account\n\n\t\t5) Exit program");
				choice = keyboard.nextInt();
				
				switch(choice){
				
				case 1:
					// request how much is to be deposited into the checking account and pass amount
					// to the setBalance() method
					
					System.out.println("How much do you want to deposit to your checking account?");
					checkingDeposit = keyboard.nextDouble();
					
					checkingBalance = checkingBalance + checkingDeposit;
						
					c1.setBalance(checkingBalance);
					
					// set the value of the Date object which represents the date accessed
					dateAccessed = new Date();
					
					c1.setDateAccessed(dateAccessed);
					
					System.out.println(c1);
					
					break;
					
				case 2:
					// request amount to be withdrawn from checking account
					System.out.println("How much do you wish to withdraw from your checking account?");
					checkingWithdrawl = keyboard.nextDouble();
					
					// set the date accessed and pass to the setDateAccessed() method
					dateAccessed = new Date();
					c1.setDateAccessed(dateAccessed);
					
					// check to see if the withdrawl is greater than the balance
					
					if (checkingWithdrawl > c1.getBalance())
						checkingOverage = checkingWithdrawl - c1.getBalance();
					
					// check to make certain the limit for overage is not exceeded
					if(checkingOverage >= c1.getLimit()){
						System.out.println("You are over your maximum overage limit. This withdrawl cannot be made. See your bank manager");
						
						break; // if over the limit, break the case and display the menu
					} else if (checkingWithdrawl <= c1.getBalance()){
						checkingBalance = checkingBalance - checkingWithdrawl;
						c1.setBalance(checkingBalance);
						
						System.out.println(c1);
						
						break;
						
					} else {
						System.out.println("Overdraft on this account is approved. There will be a fee of $" + c1.getFee() + " if you proceed. Do you wish to complete this transaction? Y/N");
						if (keyboard.next().equalsIgnoreCase("Y")){
						checkingBalance = checkingBalance - checkingWithdrawl - c1.getFee();
						c1.setBalance(checkingBalance);
						
						System.out.println(c1);
						
						break;
						}else {
							System.out.println("Transaction Canceled!");
							
							System.out.println(c1);
							break;
						}
					}
															
				case 3:
					// request amount to be deposited into savings account
					
					System.out.println("How much do you want to deposit to your savings account?");
					savingDeposit = keyboard.nextDouble();
					
					savingBalance = savingBalance + savingDeposit;
					
					dateAccessed = new Date();
					s1.setDateAccessed(dateAccessed);
					
					s1.setBalance(savingBalance);
					
					System.out.println(s1);
					
					break;
					
				case 4:
					// request amount to be withdrawn from saving account. Savings cannot be
					// overdrawn.
					
					System.out.println("How much do you wish to withdraw from your savings account?");
					savingWithdrawl = keyboard.nextDouble();
					
					dateAccessed = new Date();
					
					if (savingWithdrawl > s1.getBalance()){
						System.out.println("Insufficient funds! Your savings balance is " + s1.getBalance() + ". This is the most that you can withdraw.");
					} else {
						savingBalance = savingBalance - savingWithdrawl;
						s1.setBalance(savingBalance);
					}
					
					System.out.println(s1);
					break;
					
				case 5:
					// if user chose 5 from the menu the program exists
					System.exit(0);
					break;
					
					default:
						//always include a default case should the user enter an incorrect choice
						System.out.println("Error! This is not a menu choice");
						break;
				} // close switch statement
			} // close try statement
			
			catch(NumberFormatException e){
				System.out.println("Currency format must be used");
			}
		}while (choice != 5); // close do/while loop
		
	} // close main method
} // close class
