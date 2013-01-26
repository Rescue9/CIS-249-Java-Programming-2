/*
 * Program: Ch11Lab3.java
 * Programmer: Andrew Buskov
 * Class: CIS 249
 * Date: Jan 19, 2013
 * Purpose: To properly order a set of 5 integers from least to greatest value.
 */

package Ch11.Lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch11Lab3 {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		System.out.println("Enter five integers: ");
		for (int i=0; i < 5; i++){
			list.add(input.nextInt());
		}
		
		sort(list);
		
		for (int i = 0; i < list.size(); i++){
			System.out.println(list.get(i) + " ");
		}
	}
	
	public static void sort(ArrayList<Integer> list){
		for (int i = 0; i < list.size() - 1; i++){
			// find the minimum in the list[ i..list.length-1]
			int currentMin = list.get(i);
			int currentMinIndex = i;
			
			for (int j = i + 1; j < list.size(); j++){
				if (currentMin > list.get(j)){
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}
			
			//swap list.get(i) with list.get(currentMinIndex) if necessary;
			if (currentMinIndex != i){
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}

}
