package com.erikpihel.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class GroupIntersectionsTest {
	@Test
	public void testGroupIntersections() {
		Integer[][] input = { pair(1, 3), pair(5, 7), pair(2, 4), pair(100, 567), pair(6, 8), pair(120, 340) };
		Integer[][] expected = { pair(1, 4), pair(5, 8), pair(100, 567) };
		Assert.assertArrayEquals(expected, GroupIntersections.groupIntersections(input));
	}

	@Test
	public void testFindIntersection() {
		Integer[] expected = pair(1, 4);
		testFindIntersection(pair(1, 4), pair(2, 3), expected);
		testFindIntersection(pair(2, 3), pair(1, 4), expected);
		testFindIntersection(pair(1, 3), pair(2, 4), expected);
		
		testFindIntersection(pair(1, 2), pair(3, 4), null);
	}
	
	private void testFindIntersection(Integer[] firstPair, Integer[] secondPair, Integer[] expected) {
		Integer[] actual = GroupIntersections.findIntersection(firstPair, secondPair);
		Assert.assertArrayEquals(expected, actual);
	}
	
	private Integer[] pair(int low, int high) {
		return new Integer[] { low, high };
	}
}
