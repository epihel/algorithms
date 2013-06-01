package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given a list, shuffle the items.
 */
public class ShuffleListItems {
	public static List<String> shuffle(List<String> list) {
		List<String> shuffledList = new ArrayList<String>();
		List<String> unshuffledList = new ArrayList<String>(list);
		Random rnd = new Random();
		
		for (int i = 0; i < list.size(); ++i) {
			int index = rnd.nextInt(unshuffledList.size());
			String randomlyPulledItem = unshuffledList.remove(index);
			shuffledList.add(randomlyPulledItem);
		}
		
		return shuffledList;
	}
}
