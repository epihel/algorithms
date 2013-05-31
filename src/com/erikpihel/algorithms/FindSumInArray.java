package com.erikpihel.algorithms;

import java.util.Arrays;

/**
 * Given an array of integers, determine if any two numbers
 * add up to a given total.
 */
public class FindSumInArray {
	public static boolean find(int[] arr, int targetSum) {
		Arrays.sort(arr);
		
		// index of first element, the smallest number in first half of list
		int firstHalfIndex = 0;
		// index of last element, the largest number in second half of list
		int secondHalfIndex = arr.length - 1;
	    
		// loop until the middle of the array
		// when we've tried all additions
		while (firstHalfIndex < secondHalfIndex) {
			int sum = arr[firstHalfIndex] + arr[secondHalfIndex];
			//System.out.println("[" + arr[firstHalfIndex] + "] + [" + arr[secondHalfIndex] + "] = [" + sum + "]");
			if (sum == targetSum) {
				return true;
			}
			
			// we overshot: only way to make total smaller
			// is to move one index down in the larger-number half
			else if (sum > targetSum) {
				--secondHalfIndex;
			}
			
			// we undershot: only way to make total larger
			// is to move one index up in the smaller-number half
			else {
				++firstHalfIndex;
			}
		}
		
		return false;
	}
}
