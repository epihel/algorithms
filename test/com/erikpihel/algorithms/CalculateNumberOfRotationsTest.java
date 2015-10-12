package com.erikpihel.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateNumberOfRotationsTest {
	@Test
	public void testCalculateNumRotations() {
		testCalculateNumRotations(0, new int[] {1, 2, 3, 4});
		testCalculateNumRotations(1, new int[] {5, 6, 7, 8, 4});
		testCalculateNumRotations(2, new int[] {244, 255, 276, 23, 243});
		testCalculateNumRotations(4, new int[] {255, 276, 397, 408, 545, 1, 12, 23, 244});
		testCalculateNumRotations(6, new int[] {255, 276, 397, 408, 545, 1, 5, 12, 17, 23, 244});
	}
	
	private void testCalculateNumRotations(int expectedRotations, int[] arr) {
		int actualRotations = CalculateNumberOfRotations.calculateNumRotations(arr);
		assertEquals(expectedRotations, actualRotations);
	}
}
