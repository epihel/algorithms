package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given a list, shuffle the items.
 */
public class ShuffleListItems {
	public static <T> List<T> shuffle(List<T> list) {
		List<T> shuffledList = new ArrayList<T>();
		List<T> unshuffledList = new ArrayList<T>(list);
		Random rnd = new Random();
		
		for (int i = 0; i < list.size(); ++i) {
			int randomIndex = rnd.nextInt(unshuffledList.size());
			T randomlyPulledItem = unshuffledList.remove(randomIndex);
			shuffledList.add(randomlyPulledItem);
		}
		
		return shuffledList;
	}
}
