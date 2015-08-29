package com.erikpihel.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of points, finds the {@link #NUM_NEIGHBORS} closest neighbors
 * for each point in the list.
 *           0     1     2     3
 * points [[1,2],[3,2],[4,8],[6,7]]
 *
 *            0        1        2        3
 * return [[1,2,3], [0,2,3], [0,1,3], [0,1,2]]
 */
public class FindNearestNeighbors {
	private static final int NUM_NEIGHBORS = 3;
	// package-friendly for testing
	static final double INIT_VALUE = -1;

	public static int[][] findNeighbors(int[][] points) {
		int[][] neighbors = new int[points.length][NUM_NEIGHBORS];
	    for (int i = 0; i < points.length; i++) {
	    	neighbors[i] = findNeighborsForOnePoint(points, points[i], i);
	    }
	    return neighbors;
	}

	/**
	 * Gets the nearest neighbors of a point (0(n) complexity).
	 * Package-friendly for testing.
	 * @param allPoints
	 * @param point  [x,y] coordinate
	 * @param i  the index of the point in <code>allPoints</code>
	 * @return
	 */
	static int[] findNeighborsForOnePoint(int[][] allPoints, int[] point, int i) {
		// distance to index in point array
		Map<Double, Integer> distanceToIndex = new HashMap<>();
		// the shortest distances (keys for distanceToIndex)
		double[] shortestDistances = new double[NUM_NEIGHBORS];
		for (int j = 0; j < NUM_NEIGHBORS; j++) {
			shortestDistances[j] = INIT_VALUE;
		}
		
		// loop through all points (O(n) complexity)
		for (int j = 0; j < allPoints.length; j++) {
			// skip the point itself
			if (j != i) {
				double distance = getDistance(point, allPoints[j]);
				distanceToIndex.put(distance, j);
				insert(shortestDistances, distance);
			}
		}
		
		// now that we have the final array of shortest distances,
		// use map to get the indices in the original points array
		int[] indices = new int[NUM_NEIGHBORS];
		for (int j = 0; j < indices.length; j++) {
			indices[j] = distanceToIndex.get(shortestDistances[j]);
		}
		// optional: if we don't need the indices in order, this is not needed
		Arrays.sort(indices);
		return indices;
	}
	
	/**
	 * Finds the insertion point in the ordered distances array
	 * to avoid a sort.
	 * Package-friendly for testing.
	 * @param shortestDistances
	 * @param distance
	 */
	static void insert(double[] shortestDistances, double distance) {
		for (int i = 0; i < shortestDistances.length; i++) {
			if (shortestDistances[i] == INIT_VALUE) {
				shortestDistances[i] = distance;
				break;
			}
			
			else if (distance < shortestDistances[i]) {
				// shift everything down
				for (int j = shortestDistances.length - 1; j > i; j--) {
					shortestDistances[j] = shortestDistances[j - 1];
				}
				// insert
				shortestDistances[i] = distance;
				break;
			}
		}
	}
	
	/**
	 * Gets the distance between two points.
	 * d^2 = (x2-x1)^2 + (y2-y1)^2
	 * @param firstPt
	 * @param secondPt
	 * @return
	 */
	private static double getDistance(int[] firstPt, int[] secondPt) {
		double distanceSquared = (Math.pow(firstPt[0] - secondPt[0], 2) + Math.pow(firstPt[1] - secondPt[1], 2));
		return Math.sqrt(distanceSquared);
	}
}
