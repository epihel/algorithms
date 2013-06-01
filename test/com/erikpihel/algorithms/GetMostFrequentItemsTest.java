package com.erikpihel.algorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GetMostFrequentItemsTest {
	private static final int NUM_MAX_ITEMS = 3;
	private static final Collection<String> SHORT_LIST = Arrays.asList("hello", "goodbye");
	private static final Collection<String> LONG_LIST = Arrays.asList("hello", "goodbye", "hello", "what?", "adios", "hello", "goodbye", "where?", "how?", "adios", "adios");
	
	@Test
	public void testGetMostFrequentEntries() {
		// if size is less than NUM_MAX_ITEMS, then list items should be the same
		assertEquals(new String[] {"hello", "goodbye"}, GetMostFrequentItems.getMostFrequentItems(SHORT_LIST, NUM_MAX_ITEMS));
		
		// if size is greater than NUM_MAX_ITEMS, then return top NUM_MAX_ITEMS
		List<String> mostFrequentItems = GetMostFrequentItems.getMostFrequentItems(LONG_LIST, NUM_MAX_ITEMS);
		
		// sort to get a predictable order for comparison
		Collections.sort(mostFrequentItems);
		assertEquals(new String[] {"adios", "goodbye", "hello"}, mostFrequentItems);
	}
	
	@Test
	public void testSortByFrequency() {
		assertEquals(new String[] {"hello", "goodbye"}, GetMostFrequentItems.sortByFrequency(SHORT_LIST));
		
		// just test the first three elements because elements with the same frequency have an unpredictable order
		assertEquals(new String[] {"hello", "adios", "goodbye"}, GetMostFrequentItems.sortByFrequency(LONG_LIST).subList(0, 3));
	}
	
	private void assertEquals(String[] expectedResults, Collection<String> actualResults) {
		Assert.assertArrayEquals(expectedResults, actualResults.toArray(new String[actualResults.size()]));
	}
}
