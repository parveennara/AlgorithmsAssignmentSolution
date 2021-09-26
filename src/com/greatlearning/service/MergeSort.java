package com.greatlearning.service;

public class MergeSort {
	
	
	public void sortArray(double[] arr, int left, int right, boolean asc) {
		
		if (left < right) {
			
			int mid = left + (right - left)/2;
			sortArray(arr, left, mid, asc);
			sortArray(arr, mid+1, right, asc);
			
			if (asc) {
				
				mergeArrayAsc(arr, left, mid, right);
				
			} 
			else {
				
				mergeArrayDesc(arr, left, mid, right);
				
			}			
		}		
	}
	
	public void mergeArrayDesc(double[] arr, int left, int mid, int right) {
		
		int length1 = mid - left + 1;
		int length2 = right - mid;		
		
		double[] arrayLeft = new double[length1];
		double[] arrayRight = new double[length2];
		
		for (int i = 0; i < length1; i++) {
			
			arrayLeft[i] = arr[left + i];
		
		}
		
		for (int j = 0; j < length2; j++) {
		
			arrayRight[j] = arr[mid + 1 + j];
		
		}
		
		int i = 0, j = 0;
		int k = left;
		
		while (i < length1 && j < length2) {
			
			if (arrayLeft[i] >= arrayRight[j]) {
				
				arr[k] = arrayLeft[i];
				i++;
			
			} else {
				
				arr[k] = arrayRight[j];
				j++;
			
			}
			
			k++;
		
		}
		
		while (i < length1) {
			
			arr[k] = arrayLeft[i];
			i++;
			k++;
		
		}
		
		while (j < length2) {
			
			arr[k] = arrayRight[j];
			j++;
			k++;
		
		}
	}
	
	public void mergeArrayAsc(double[] arr, int left, int mid, int right) {
		
		int length1 = mid - left + 1;
		int length2 = right - mid;		
		
		double[] arrayLeft = new double[length1];
		double[] arrayRight = new double[length2];
		
		for (int i = 0; i < length1; i++) {
		
			arrayLeft[i] = arr[left + i];
		
		}
		
		for (int j = 0; j < length2; j++) {
		
			arrayRight[j] = arr[mid + 1 + j];
		
		}
		
		int i = 0, j = 0;
		int k = left;
		
		while (i < length1 && j < length2) {
			
			if (arrayLeft[i] <= arrayRight[j]) {
				
				arr[k] = arrayLeft[i];
				i++;
		
			} else {
				
				arr[k] = arrayRight[j];
				j++;
			
			}
			
			k++;
		
		}
		
		while (i < length1) {
			
			arr[k] = arrayLeft[i];
			i++;
			k++;
		
		}
		
		while (j < length2) {
			
			arr[k] = arrayRight[j];
			j++;
			k++;
		
		}
	}
}