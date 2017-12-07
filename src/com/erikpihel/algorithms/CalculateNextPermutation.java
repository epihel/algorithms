package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class CalculateNextPermutation {
	/**
	 * Given a number, calculates the next highest permutation.
	 * 123 => 132
	 * 132 => 213
	 * @param num  the current number
	 * @return the next permutation
	 * @see https://en.wikipedia.org/wiki/Permutation
	 */
	public static int next(int num) {
		int swapped = swap(num);
		
		if (swapped > num) {
			return swapped;
		}
		
		else {
			return increment(num);
		}
	}
	
	static int increment(int num) {
		String s = String.valueOf(num);
		int len = s.length();

		if (len < 3) {
			return num;
		}
		
		else {
			char[] chars = s.toCharArray();
			Pair pair = getPair(s, chars, 3);
				
			StringBuilder next = new StringBuilder();
			Collection<Character> excluded = new ArrayList<>();
			
			for (int i = 0; i < pair.swappingPos; ++i) {
				next.append(chars[i]);
				excluded.add(chars[i]);
			}
			
			next.append(pair.incremented);
			excluded.add(pair.incremented);
			
			char nextChar = smallest(chars, excluded);
			next.append(nextChar);

			// append remaining numbers in ascending order to ensure we add the next smallest
			Collection<Integer> remaining = new TreeSet<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer firstInt, Integer secondInt) {
					return firstInt.compareTo(secondInt);
				}
			});
			for (int i = Math.max(0, pair.swappingPos); i < len; ++i) {
				if (chars[i] != pair.incremented && chars[i] != nextChar) {
					remaining.add(charToInt(chars[i]));
				}
			}
			for (int i : remaining) {
				next.append(intToChar(i));
			}
			
			return Integer.parseInt(next.toString());
		}
	}
	
	private static Pair getPair(String s, char[] chars, int posFromEnd) {
		Pair pair = new Pair();
		int len = s.length();
		pair.swappingPos = len - posFromEnd;
		pair.incremented = incrementChar(s.charAt(pair.swappingPos));

		if (pair.incremented == '0') {
			throw new UnsupportedOperationException("Incrementing two places not supported yet.");
		}
		
		// if the incremented char already exists to the left of the swapping position, increment
		else if (contains(s.substring(0, pair.swappingPos), pair.incremented)) {
			pair.incremented = incrementChar(pair.incremented);
			return pair;
		}
		
		// if the incremented char is not outside the range of the string, we're done
		else if (contains(s, pair.incremented)) {
			return pair;
		}
		
		// if the incremented char is outside the range of the string, try again
		else {
			return getPair(s, chars, posFromEnd + 1);
		}
	}
	
	private static int charToInt(char c) {
		return Character.getNumericValue(c);
	}
	
	private static char intToChar(int i) {
		return Integer.toString(i).charAt(0);
	}
	
	private static boolean contains(String s, char c) {
		return s.contains(Character.toString(c));
	}
	
	/**
	 * Finds the smallest number value in character array.
	 * Package-friendly for testing.
	 * @param arr
	 * @param excluded
	 * @return
	 */
	static char smallest(char[] arr, Collection<Character> excluded) {
		int min = 9;
		
		for (char c : arr) {
			if (!excluded.contains(c)) {
				min = Math.min(min, charToInt(c));
			}
		}

		return intToChar(min);
	}
	
	/**
	 * Package-friendly for testing.
	 * @param num
	 * @return
	 */
	static char incrementChar(char numAsChar) {
		int num = charToInt(numAsChar);
		return num == 9 ? '0' : intToChar(num + 1);
	}
	
	/**
	 * Swaps the last two digits of an Integer.
	 * Package-friendly for testing.
	 * @param num
	 * @return  num with the last two digits swapped
	 */
	static int swap(int num) {
		String s = String.valueOf(num);
		int len = s.length();
		if (len < 2) {
			return num;
		}
		
		else {
			String swapped = s.substring(0, len - 2) + s.substring(len - 1) + s.substring(len - 2, len - 1);
			return Integer.parseInt(swapped);
		}
	}
	
	private static class Pair {
		private int swappingPos;
		private char incremented;
	}
}
