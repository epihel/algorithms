package com.erikpihel.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class FindNearestNeighborsTest {
	private static final int[][] POINTS = {{1,2}, {3,2}, {4,8}, {6,7}};
	private static final int[][] EXPECTED_NEIGHBORS = {{1,2,3}, {0,2,3}, {0,1,3}, {0,1,2}};
	
	@Test
	public void testFindNeighbors() {
		Assert.assertArrayEquals(EXPECTED_NEIGHBORS, FindNearestNeighbors.findNeighbors(POINTS));
	}

	@Test
	public void testFindNeighborsForOnePoint() {
		for (int i = 0; i < POINTS.length; i++) {
			testFindNeighborsForOnePoint(POINTS, EXPECTED_NEIGHBORS[i], i);
		}
	}
	
	@Test
	public void testInsert() {
		double delta = 0;
		double[] shortestDistances = new double[] {FindNearestNeighbors.INIT_VALUE, FindNearestNeighbors.INIT_VALUE, FindNearestNeighbors.INIT_VALUE};
		FindNearestNeighbors.insert(shortestDistances, 1);
		Assert.assertArrayEquals(new double[] {1, FindNearestNeighbors.INIT_VALUE, FindNearestNeighbors.INIT_VALUE}, shortestDistances, delta);
		
		shortestDistances = new double[] {1, 3, 4};
		FindNearestNeighbors.insert(shortestDistances, 2);
		Assert.assertArrayEquals(new double[] {1, 2, 3}, shortestDistances, delta);
		
		shortestDistances = new double[] {1, 3, 4};
		FindNearestNeighbors.insert(shortestDistances, 5);
		Assert.assertArrayEquals(new double[] {1, 3, 4}, shortestDistances, delta);
	}
	
	private void testFindNeighborsForOnePoint(int[][] input, int[] expected, int index) {
		Assert.assertArrayEquals(expected, FindNearestNeighbors.findNeighborsForOnePoint(input, input[index], index));
	}
}
