package com.erikpihel.algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RandomSubsetTest {
	@Test
	public void testSubset() {
		int len = 1000;
		int subsetSize = 20;
		
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = RandomSubset.rnd(0, 10000);
		}
		
		int[] randomSubset = RandomSubset.subset(arr, subsetSize);
		assertEquals(subsetSize, randomSubset.length);
		
		// it's difficult to test randomness, but visually, these should look right
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(randomSubset));
	}
}
