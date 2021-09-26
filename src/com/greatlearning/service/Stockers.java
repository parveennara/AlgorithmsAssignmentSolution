package com.greatlearning.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Stockers {
	
	public void stockersImplementation() {
		
		double[] sharePrice;
		boolean[] shareTrend;
		
		int upTrend = 0;
		int downTrend = 0;
					
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no of companies");		
		int noOfCompanies = sc.nextInt();
		
		sharePrice = new double[noOfCompanies];
		shareTrend = new boolean[noOfCompanies];
				
		if (noOfCompanies > 0) {
			
			for (int i = 1; i <= noOfCompanies; i++) {
				
				System.out.println("Enter current stock price of the company " + i);
				sharePrice[i-1] = sc.nextDouble();
				
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				shareTrend[i-1] = sc.nextBoolean();
				
				if (shareTrend[i-1]) {
					
					upTrend++;	
					
				} else {
					
					downTrend++;
					
				}
			}
		}
		else {
			
			System.out.println("Please enter a valid no of companies");
			
		}		

		int option = 0;
		MergeSort ms = new MergeSort();
		BinarySearch bs = new BinarySearch();
		
		do {
			
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. Press 0 to exit");
			System.out.println("---------------------------------------------");
			
			try {
				
				option = sc.nextInt();
				
			}
			catch (InputMismatchException ex) {
				
				System.out.println("Invalid input : Please choose a correct option");
				
			}
			
			
			switch(option) {
			
				case 1: {
					
					boolean asc = true;
					ms.sortArray(sharePrice, 0, sharePrice.length-1, asc );
					
					System.out.println("Stock prices in ascending order are :");
					
					for (int i=0; i< noOfCompanies; i++) {
						
						System.out.print(sharePrice[i] + " ");
						
					}
					
					System.out.println();				
					break;
					
				}
			
				case 2: {
					
					boolean asc = false;
					ms.sortArray(sharePrice, 0, sharePrice.length-1, asc );
					
					System.out.println("Stock prices in descending order are :");
					
					for (int i=0; i< noOfCompanies; i++) {
						
						System.out.print(sharePrice[i] + " ");
						
					}
					
					System.out.println();				
					break;
					
				}
			
				case 3: {
					
					System.out.println("Total no of companies whose stock price rose today : " + upTrend);
					break;
					
				}
				
				case 4: {
					
					System.out.println("Total no of companies whose stock price declined today : " + downTrend);
					break;
					
				}
				
				case 5: {
					
					double key;
					boolean result;
					
					System.out.println("Enter the key value");
					key = sc.nextDouble();
					
					ms.sortArray(sharePrice, 0, sharePrice.length-1, true );
					result = bs.search(sharePrice, 0, sharePrice.length-1, key);
					
					if (result) {
						
						System.out.println("Stock of value " + key + " is present");
						
					}
					else {
						
						System.out.println("Value not found");
						
					}
					
					break;
					
				}
				
				case 0: {
					
					System.out.println("Exited Successfully");
					break;
					
				}
			
				default: {
					
					System.out.println("Invalid input : Please choose a correct option");
					break;
					
				}
			}			
		}
		while (option != 0);
		
		sc.close();

	}
}
