package com.erikpihel.algorithms;

import java.util.Arrays;

/**
 * Given an initially sorted array of {@link Integer}s
 * that then has its last item rotated to the beginning,
 * determine how many times this rotation has occurred
 * to the given array. Therefore, if the array looks like:
 * {3, 4, 1, 2}
 * the rotation has occurred twice.
 * The algorithm finds where the highest number
 * is adjacent to the lowest number and then counts
 * the number of items from that index to the end.
 */
public class CalculateNumberOfRotations {
	public static int calculateNumRotations(int[] arr) {
		// no rotations
		if (arr[0] < arr[arr.length - 1]) {
			return 0;
		}
		
		else {
			return split(arr, 0);
		}
	}
	
	/**
	 * Keeps splitting the array until there's nothing left to split,
	 * counting the second half of the array as we go.
	 * @param arr
	 * @param numRotations
	 * @return
	 */
	private static int split(int[] arr, int numRotations) {
		int splitIndex = arr.length / 2;
		int[] firstArr = Arrays.copyOfRange(arr, 0, splitIndex);
		int[] secondArr = Arrays.copyOfRange(arr, splitIndex, arr.length);
		
		if (firstArr.length <= 1 && secondArr.length <= 1) {
			return numRotations + 1;
		}
		
		// if the second sub-array contains the split
		else if (secondArr[0] > secondArr[secondArr.length - 1]) {
			// keep splitting without counting the items
			return split(secondArr, numRotations);
		}
		
		else {
			// count the items from the second sub-array
			numRotations += secondArr.length;
			
			// if the first sub-array contains the split
			if (firstArr[0] > firstArr[firstArr.length - 1]) {
				// keep splitting
				return split(firstArr, numRotations);
			}
			
			else {
				return numRotations;
			}
		}
	}
}
