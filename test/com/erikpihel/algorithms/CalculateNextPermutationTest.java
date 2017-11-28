package com.erikpihel.algorithms;

import static org.junit.Assert.assertEquals;

import java.nio.CharBuffer;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

public class CalculateNextPermutationTest {
	@Test
	public void testNext() {
		testNext(123, 132);
		testNext(132, 213);
		testNext(213, 231);
		testNext(231, 312);
		testNext(312, 321);
		
		testNext(1234, 1243);
		testNext(1243, 1324);
		testNext(1324, 1342);
		testNext(1342, 1423);
		testNext(1423, 1432);
		//testNext(1432, 2134);
	}
	
	@Test
	public void testIncrement() {
		testIncrement(132, 213);
		testIncrement(231, 312);
		
		testIncrement(1243, 1324);
		testIncrement(1342, 1423);
		//testIncrement(1432, 2134);
	}
	
	@Test
	public void testSmallest() {
		testSmallest(new char[] { '2', '3', '1' }, '3', '1');
		testSmallest(new char[] { '1', '3', '2' }, '2', '1');
	}
	
	@Test
	public void testIncrementChar() {
		testIncrementChar('1', '2');
		testIncrementChar('9', '0');
	}
	
	@Test
	public void testSwap() {
		testSwap(1, 1);
		testSwap(12, 21);
		testSwap(123, 132);
		testSwap(1234, 1243);
	}
	
	private void testNext(int num, int expected) {
		assertEquals(expected, CalculateNextPermutation.next(num));
	}
	
	private void testIncrement(int num, int expected) {
		assertEquals(expected, CalculateNextPermutation.increment(num));
	}
	
	private void testSmallest(char[] arr, char excluded, char expected) {
		Collection<Character> excludedColl = Collections.singleton(excluded);
		assertCharEquals(expected, CalculateNextPermutation.smallest(arr, excludedColl));
	}
	
	private void testIncrementChar(char num, char expected) {
		assertCharEquals(expected, CalculateNextPermutation.incrementChar(num));
	}
	
	private void testSwap(int num, int expected) {
		assertEquals(expected, CalculateNextPermutation.swap(num));
	}
	
	private void assertCharEquals(char expected, char actual) {
		assertEquals(buffer(expected), buffer(actual));
	}
	
	private CharBuffer buffer(char c) {
		return CharBuffer.wrap(Character.toString(c));
	}
}
