package Ch11.Lab2;

import java.text.DecimalFormat;

public class Checkings extends Account{
	
	protected int overdraftLimit = 5000;
	protected double overdraftFee = 29.99;
	protected DecimalFormat currency = new DecimalFormat("$##,##0.00");
	protected DecimalFormat percentage = new DecimalFormat("##,##0.00%");
	protected final double INTERESTRATE = 0.015;
	
	// default constructor method
	
	Checkings(){
		
	}
	
	// overload method
	Checkings(int ID, double startingBalance){
		super(ID, startingBalance);
	}
	
	public int getLimit(){
		return overdraftLimit;
	}
	
	public double getFee(){
		return overdraftFee;
	}
	
	// include a toString() method to display values of all attributes
	
	public String toString(){
		if(getDateAccessed() == null)
			setDateAccessed(getDateCreated());
		
		setAnnualInterstRate(INTERESTRATE);
		
		return "\n\n\t\tChecking Account\n\nID:" + getId() + "\nBalance: " + currency.format(getBalance()) + "\nDate Created: "+ getDateCreated()+ "\nLast Date Accessed: "+ getDateAccessed() + "\nAnnual Interest Rate:" + percentage.format(getAnnualInterestRate());
		
		
	}

}
