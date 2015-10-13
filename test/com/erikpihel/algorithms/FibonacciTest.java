package com.erikpihel.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {
	@Test
	public void testGenerate() {
		testGenerate(1, 2, 5, new Integer[] {1, 2, 3, 5, 8});
		testGenerate(21, 34, 7, new Integer[] {21, 34, 55, 89, 144, 233, 377});
		testGenerate(0, 1, 15, new Integer[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377});
	}
	
	private void testGenerate(int x, int y, int length, Integer[] expected) {
		Integer[] actual = Fibonacci.generate(x,  y,  length);
		assertArrayEquals(expected, actual);
	}
}
