package com.erikpihel.algorithms;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ShuffleListItemsTest {
	/**
	 * It's hard to unit-test randomness.
	 * Instead, shuffle 5 times and visually verify
	 * that there's reasonable randomness.
	 */
	@Test
	public void testShuffle() {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");
		int numSamples = 5;
		
		for (int i = 0; i < numSamples; ++i) {
			List<String> shuffledList = ShuffleListItems.shuffle(list);
			System.out.println("shuffled list: " + Arrays.toString(shuffledList.toArray()));
		}
	}
}
