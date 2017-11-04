package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class GroupIntersections {
	/**
	 * Groups ranges of intersecting numbers into a single range.
	 * @param intersections  [[1, 3], [5, 7], [2, 4], [100, 567], [6, 8], [120, 340]]
	 * @return  [[1, 4], [5, 8], [100, 567]]
	 */
	public static Integer[][] groupIntersections(Integer[][] intersections) {
		List<Integer[]> groupedIntersections = new ArrayList<>();
		Collection<Integer> nonIntersectingIndices = new HashSet<>();
		int numIntersections = intersections.length;
		
		// initialize nonIntersectingIndices with all indices
		// and then remove them as intersections are found
		for (int i = 0; i < numIntersections; ++i) {
			nonIntersectingIndices.add(i);
		}

		for (int i = 0; i < numIntersections; ++i) {
			for (int j = i + 1; j < numIntersections; ++j) {
				Integer[] intersection = null;
				Integer[] currentPair = intersections[j];
				// check if the current pair can be grouped with an existing pair
				for (int k = 0; k < groupedIntersections.size(); ++k) {
					intersection = findIntersection(groupedIntersections.get(k), currentPair);
					if (intersection != null) {
						// remove the existing one because we'll add the updated one below
						groupedIntersections.remove(k);
						break;
					}
		        }
				
				// if the current pair doesn't intersect with an existing pair
				if (intersection == null) {
	                intersection = findIntersection(intersections[i], currentPair);
				}
				
				if (intersection != null) {
                	groupedIntersections.add(intersection);
                	nonIntersectingIndices.remove(i);
                	nonIntersectingIndices.remove(j);
                }
	        }
	    }
		// add all the pairs that weren't grouped with other pairs
		for (int i : nonIntersectingIndices) {
			groupedIntersections.add(intersections[i]);
		}
		return groupedIntersections.toArray(new Integer[groupedIntersections.size()][]);
	}
	
	private static boolean inRange(Integer num, Integer[] range) {
		return num >= range[0] && num <= range[1];
	}
	
	/**
	 * Determines if two range-pairs intersect.
	 * Package-friendly for testing.
	 * @param firstPair
	 * @param secondPair
	 * @return  the composite range if they intersect; null if they don't
	 */
	static Integer[] findIntersection(Integer[] firstPair, Integer[] secondPair) {
		if (inRange(firstPair[0], secondPair) ||
			inRange(firstPair[1], secondPair) ||
			inRange(secondPair[0], firstPair) ||
			inRange(secondPair[1], firstPair)) {
	            return new Integer[] { Math.min(firstPair[0], secondPair[0]), Math.max(firstPair[1], secondPair[1]) };
	    }
	    
	    else {
	        return null;
	    }
	}
}
