package com.erikpihel.algorithms;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class ColorUtilTest {
	@Test
	public void testIntToRgb() {
		testIntToRgb(0, 0, 0, 0);
		testIntToRgb(16764057, 255, 204, 153);
		testIntToRgb(16777215, 255, 255, 255);
	}

	@Test
	public void testHexToRgb() {
		testHexToRgb("#000000", 0, 0, 0);
		testHexToRgb("FFFFFF", 255, 255, 255);
		testHexToRgb("#FFCC99", 255, 204, 153);
		
		try {
			testHexToRgb("#FFF", 255, 255, 255);
			throw new RuntimeException("Expected IllegalArgumentException, but found none.");
		}
		
		catch (Exception e) {
			if (e instanceof IllegalArgumentException) {
				assertEquals("Expected [#FFF] to be [7] characters, but was [4].", e.getMessage());
			}
			
			else {
				throw new RuntimeException("Expected IllegalArgumentException, but found " + e.getClass().getName() + ".");
			}
		}
	}
	
	private void testIntToRgb(int i, int expectedR, int expectedG, int expectedB) {
		Color c = ColorUtil.intToRgb(i);
		assertEquals(expectedR, c.getRed());
		assertEquals(expectedG, c.getGreen());
		assertEquals(expectedB, c.getBlue());
	}
	
	private void testHexToRgb(String hex, int expectedR, int expectedG, int expectedB) {
		Color c = ColorUtil.hexToRgb(hex);
		assertEquals(expectedR, c.getRed());
		assertEquals(expectedG, c.getGreen());
		assertEquals(expectedB, c.getBlue());
	}
}
