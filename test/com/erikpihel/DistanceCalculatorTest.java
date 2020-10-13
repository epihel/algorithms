package com.erikpihel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DistanceCalculatorTest {
	private static final Integer[] FIRST_POINT = {0, 2};
	private static final Integer[] SECOND_POINT = {2, 0};
	private static final double PRECISION = 0;

	@Test
	public void testGetDistance() {
		assertEquals(Math.sqrt(8), DistanceCalculator.getDistance(FIRST_POINT, SECOND_POINT), PRECISION);
	}
	
	@Test
	public void testGetManhattanDistance() {
		assertEquals(4, DistanceCalculator.getManhattanDistance(FIRST_POINT, SECOND_POINT), PRECISION);
	}

}
