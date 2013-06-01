package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list, return a new list
 * with the most frequently occuring items.
 */
public class GetMostFrequentItems {
	/**
	 * Gets a list of {@link Math#min(numMaxItems, items.size())} size of the most-frequent entries.
	 * @param items  the entire list
	 * @param numTopItems  top n items where n == frequency in the list
	 * @return a list of the most-frequent items
	 */
	public static <T> List<T> getMostFrequentItems(Collection<T> items, int numTopItems) {
		// if num items less than numTopItems, just return all items
		if (items == null || items.size() <= numTopItems) {
			return new ArrayList<T>(items);
		}
		
		// sort by frequency and pull off the top entries
		else {
			return sortByFrequency(items).subList(0, numTopItems);
		}
	}
	
	/**
	 * Gets unique values from the given items, sorted by frequency.
	 * @param items  the items to sort
	 * @return  unique values from the given items, sorted by frequency
	 */ 
	public static <T> List<T> sortByFrequency(Collection<T> items) {
		// if 2 or less items, no frequencies
		if (items == null || items.size() <= 2) {
			return new ArrayList<T>(items);
		}
		
		else {
			// build a map of unique item => frequency count
			final Map<T, Integer> frequencyMap = new HashMap<T, Integer>();
			for (T item : items) {
				Integer currentCount = frequencyMap.get(item);
				frequencyMap.put(item, currentCount == null ? 1 : currentCount + 1);
			}
			
			// create a list of the map keys
			List<T> allItems = new ArrayList<T>(frequencyMap.keySet());
			
			// sort items (map keys) by frequency (map values)
			Collections.sort(allItems, new Comparator<T>() {
				@Override
				public int compare(T firstItem, T secondItem) {
					// compare the values (frequency count) in descending order (-1)
					return -1 * frequencyMap.get(firstItem).compareTo(frequencyMap.get(secondItem));
				}
			});
			
			return allItems;
		}
	}
}
