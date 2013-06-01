package com.erikpihel.algorithms;

import junit.framework.Assert;
import org.junit.Test;

public class FindSumInArrayTest {
	@Test
	public void testFind() {
		int[] arr = new int[] {1, 4, 6, 2, 445, 23};
		int targetSum = 8;
		Assert.assertTrue(FindSumInArray.find(arr, targetSum));
		
		arr = new int[] {1, 4, 6, 2, 445, 23};
		targetSum = 9;
		Assert.assertFalse(FindSumInArray.find(arr, targetSum));
	}
}
