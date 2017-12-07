package com.erikpihel.algorithms;

public class RandomSubset {
	/**
	 * Given an array of {@link Integer}s, returns a randomly selected subset.
	 * Complexity: O(n).
	 * @param arr  the array of {@link Integer}s
	 * @param subsetSize  the number of randomly selected elements
	 * @return  an array of randomly selected numbers from the original array
	 */
	public static int[] subset(int[] arr, int subsetSize) {
		int len = arr.length;

		if (subsetSize >= len) {
			throw new IllegalArgumentException("Subset size [" + subsetSize + "] was greater than or equals to the array length [" + len + "].");
		}
		
		else {
			int[] subset = new int[subsetSize];
			
			// initialize all subsetSize values to ensure that every slot has a value
			for (int i = 0; i < subsetSize; ++i) {
				subset[i] = arr[i];
			}
			
			// randomly replace initial values
			for (int i = 0; i < len; ++i) {
				int randomIndex = rnd(0, subsetSize - 1);
				subset[randomIndex] = arr[i];
			}

			return subset;
		}
	}
	
	/**
	 * Package friendly because used in test.
	 * @param min
	 * @param max
	 * @return
	 */
	static int rnd(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
}
