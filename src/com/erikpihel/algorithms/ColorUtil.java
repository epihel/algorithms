package com.erikpihel.algorithms;

import java.awt.Color;

public class ColorUtil {
	public static Color intToRgb(int i) {
		int white = 0xFF;
		int r = (i >> 16) & white;
		int g = (i >> 8) & white;
		int b = i & white;
		return new Color(r, g, b);
	}

	public static Color hexToRgb(String hexColor) {
		int len = hexColor.length();
		int expectedLen = -1;
		int startIndex = -1;
		
		if (hexColor.charAt(0) == '#') {
			startIndex = 1;
			expectedLen = 7;
		}
		
		else {
			startIndex = 0;
			expectedLen = 6;
		}

		if (expectedLen != len) {
			throw new IllegalArgumentException("Expected [" + hexColor + "] to be [" + expectedLen + "] characters, but was [" + len + "].");
		}
		
		else {
		    return new Color(
		    	rgbValue(hexColor, startIndex, startIndex + 2),
		    	rgbValue(hexColor, startIndex + 2, startIndex + 4),
		    	rgbValue(hexColor, startIndex + 4, startIndex + 6)
		    );
		}
	}
	
	private static int rgbValue(String hexColor, int startIndex, int endIndex) {
		int radix = 16;
		return Integer.valueOf(hexColor.substring(startIndex, endIndex), radix);
	}
}
