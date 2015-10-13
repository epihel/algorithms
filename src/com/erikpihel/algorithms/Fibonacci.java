package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377
 */
public class Fibonacci {
	/**
	 * Given the first two numbers of a Fibonacci sequence,
	 * generate the sequence of <code>length</code> numbers.
	 * @param x the first number of the sequence
	 * @param y the second number of the sequence
	 * @param length how many numbers to add before stopping
	 * @return a Fibonacci sequence
	 */
	public static Integer[] generate(int x, int y, int length) {
		List<Integer> seq = new ArrayList<>(length);
		generate(x, y, length, seq);
		return seq.toArray(new Integer[0]);
	}
	
	private static void generate(int x, int y, int length, List<Integer> seq) {
		int itemsLeft = length - seq.size();
		if (itemsLeft > 0) {
			seq.add(x);
			
			if (itemsLeft > 1) {
				generate(y, x + y, length, seq);
			}
		}
	}
}
