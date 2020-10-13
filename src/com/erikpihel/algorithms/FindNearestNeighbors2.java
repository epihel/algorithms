package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.erikpihel.DistanceCalculator;

/**
 * Given vehicle locations and package locations, matches each package to the nearest vehicle.
 * 
 */
public class FindNearestNeighbors2 {
	private static final boolean DEBUG = false;
	
	public static Map<Integer, Integer> matchVehiclesWithPackages(Integer[][] vehicleLocations, Integer[][] packageLocations, boolean useManhattanDistance) {
		int numVehicles = vehicleLocations.length; 
		if (numVehicles != packageLocations.length) {
			throw new IllegalArgumentException("Received " + numVehicles + " vehicleLocations and " + packageLocations.length + " packageLocations.");
		}

		Map<Integer, Integer> matches = new HashMap<>();

		// initialize to hold all indices
		List<Integer> vehicleIndices = new ArrayList<>();
		List<Integer> packageIndices = new ArrayList<>();
		for (int i = 0; i < numVehicles; ++i) {
			vehicleIndices.add(i);
			packageIndices.add(i);
		}
		// start with a short distance to knock out vehicles and packages close to each other right away
		double distanceToCheck = 1;
		
		// loop until we've matched all vehicles and packages except one
		while (matches.size() < numVehicles - 1) {
			Collection<Integer> vehicleIndicesToRemove = new HashSet<>();
			for (int i : vehicleIndices) {
				int foundPackageIndex = withinMinDistance(vehicleLocations[i], packageLocations, packageIndices, distanceToCheck, useManhattanDistance);
				
				if (foundPackageIndex >= 0) {
					if (DEBUG) {
						System.out.println("Found indices " + i + "-" + foundPackageIndex + " with distanceToCheck " + distanceToCheck);
					}
					matches.put(i, foundPackageIndex);
					
					// shrink the indices
					vehicleIndicesToRemove.add(i);
					packageIndices.remove(packageIndices.indexOf(foundPackageIndex));
				}
			}
			
			vehicleIndices.removeAll(vehicleIndicesToRemove);
			// increase minimum distance for next round of checks
			++distanceToCheck;
		}
		
		assertOneElem(vehicleIndices, "vehicleIndices");
		assertOneElem(packageIndices, "packageIndices");
		
		// add the only remaining one
		matches.put(vehicleIndices.get(0), packageIndices.get(0));
		return matches;
	}
	
	private static int withinMinDistance(Integer[] vehicleLocation, Integer[][] packages, Collection<Integer> packageIndices, double distanceToCheck, boolean useManhattanDistance) {
		for (int i : packageIndices) {
			double d = getDistance(vehicleLocation, packages[i], useManhattanDistance);
			if (d <= distanceToCheck) {
				return i;
			}
			
			else if (DEBUG) {
				System.out.print(vehicleLocation[0] + "," + vehicleLocation[1] + " : ");
				System.out.print(packages[i][0] + "," + packages[i][1] + " = ");
				System.out.println(d + " > " + distanceToCheck);
			}
		}

		return -1;
	}
	
	private static double getDistance(Integer[] firstPt, Integer[] secondPt, boolean useManhattanDistance) {
		if (useManhattanDistance) {
			return DistanceCalculator.getManhattanDistance(firstPt, secondPt);
		}
		
		return DistanceCalculator.getDistance(firstPt, secondPt);
	}
	
	private static void assertOneElem(Collection<?> coll, String msg) {
		if (coll.size() != 1) {
			throw new IllegalStateException("Expected 1 element, but found " + coll.size() + ": " + msg);
		}
	}
}
