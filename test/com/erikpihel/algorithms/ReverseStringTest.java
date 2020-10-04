package com.erikpihel.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseStringTest {
	@Test
	public void testReverse() {
		testReverse("a", "a");
		testReverse("ab", "ba");
		testReverse("cat", "tac");
		testReverse("hola", "aloh");
		testReverse("hello", "olleh");
	}
	
	private void testReverse(String input, String expected) {
		assertEquals(expected, ReverseString.reverse(input));
	}
}
