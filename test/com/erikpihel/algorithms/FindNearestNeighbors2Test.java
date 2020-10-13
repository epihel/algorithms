package com.erikpihel.algorithms;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindNearestNeighbors2Test {
	
	@Test
	public void testMatchVehiclesWithPackages() {
		/*
		 * {1,2}-{1,6}
		 * {3,2}-{5,2}
		 * {4,8}-{3,16}
		 * {6,7}-{5,6}
		 */
		Integer[][] vehicleLocations = {{1,2}, {3,2}, {4,8}, {6,7}};
		Integer[][] packageLocations = {{5,2}, {5,6}, {3,16}, {1,6}};
		boolean useManhattanDistance = true;
		Map<Integer, Integer> matches = FindNearestNeighbors2.matchVehiclesWithPackages(
			vehicleLocations,
			packageLocations,
			useManhattanDistance
		);
		Assert.assertEquals(vehicleLocations.length, matches.size());
		assertEquals(matches, 0, 3);
		assertEquals(matches, 1, 0);
		assertEquals(matches, 2, 2);
		assertEquals(matches, 3, 1);
	}
	
	private void assertEquals(Map<Integer, Integer> matches, Integer vehicleIndex, Integer expectedPackageIndex) {
		Integer actualPackageIndex = matches.get(vehicleIndex);
		Assert.assertEquals(expectedPackageIndex, actualPackageIndex);
	}
}
