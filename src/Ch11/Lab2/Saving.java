package Ch11.Lab2;

import java.text.DecimalFormat;

public class Saving extends Account	{
	
	protected int overdraftLimit = 0;
	protected DecimalFormat currency = new DecimalFormat("$##,##0.00");
	protected DecimalFormat percentage = new DecimalFormat("##,##0.00%");
	protected final double INTERESTRATE = 0.045;
	
	// default constructor method
	Saving(){
		
	}
	
	// overload method
	Saving(int ID, double startingBalance){
		super(ID, startingBalance);
	}
	
	public int getLimit(){
		return overdraftLimit;
	}
	
	// create toString() method to display the values of variables
	public String toString(){
		if (getDateAccessed() == null)
			setDateAccessed(getDateCreated());
		
		setAnnualInterstRate(INTERESTRATE);
		
		return "\n\n\t\tSavings Accountn\nID :" + getId() + "\nBalance: " +currency.format(getBalance()) + "\nDate created:" + getDateCreated() + "\nLast Date Accessed: "+ getDateAccessed() +"\nAnnual Interest Rate: " + percentage.format(getAnnualInterestRate());


	}
	
}