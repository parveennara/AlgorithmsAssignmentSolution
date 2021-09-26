package com.greatlearning.service;

public class BinarySearch {
	
	public boolean search(double[] arr, int left, int right, double x) {
		
		int mid = left + (right -left)/2;
		
		while (left <= right) {
			
			if (arr[mid] < x) {
				
				left = mid + 1;
				
			}
			else if (arr[mid] == x) {
				
				return true;
				
			}
			else {
				
				right = mid - 1;
				
			}
			
			mid = left + (right -left)/2;
		
		}
		
		return false;
				
	}
}
