package com.erikpihel.algorithms;

import static org.junit.Assert.*;
import org.junit.Test;

public class GetLetterCombinationsTest {
	@Test
	public void testGetCombinations() {
		String word = "ABC";
		String[] expectedCombinations = new String[] {
			"AAA", "AAB", "AAC", "ABA", "ABB", "ABC", "ACA", "ACB", "ACC",
			"BAA", "BAB", "BAC", "BBA", "BBB", "BBC", "BCA", "BCB", "BCC",
			"CAA", "CAB", "CAC", "CBA", "CBB", "CBC", "CCA", "CCB", "CCC"	
		};
		String[] actualCombinations = GetLetterCombinations.getCombinations(word);
		assertArrayEquals(expectedCombinations, actualCombinations);
	}
}
