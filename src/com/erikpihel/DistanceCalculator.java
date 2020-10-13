package com.erikpihel;

public class DistanceCalculator {
	/**
	 * Gets the Euclidean distance between two points.
	 * @param firstPt
	 * @param secondPt
	 * @return Euclidean distance
	 */
	public static double getDistance(Integer[] firstPt, Integer[] secondPt) {
		double distanceSquared = (Math.pow(firstPt[0] - secondPt[0], 2) + Math.pow(firstPt[1] - secondPt[1], 2));
		return Math.sqrt(distanceSquared);
	}
	
	/**
	 * Gets the Manhattan distance between two points.
	 * @param firstPt
	 * @param secondPt
	 * @return Manhattan distance
	 */
	public static double getManhattanDistance(Integer[] firstPt, Integer[] secondPt) {
		return Math.abs(firstPt[0] - secondPt[0]) + Math.abs(firstPt[1] - secondPt[1]);
	}
}
