/**
 * Program: Ch20Lab1.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Apr 8, 2013
 * Purpose: Compute greatest common divisor.
 */

package Ch20.Lab1;

import java.util.Scanner;

public class Ch20Lab1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// enter the first number
		System.out.println("Enter the first number: ");
		int m = input.nextInt();
		
		// enter the second number
		System.out.println("Enter the seconds number: ");
		int n = input.nextInt();
		
		// Display results by invoking the gcd() method
		System.out.println("The GCD of " + m + " and " + n + " is " + gcd(m,n));
	}
	
	public static int gcd(int m, int n){
		
		// check to see if the remainder of m divided by n is 0
		if (m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}

}
