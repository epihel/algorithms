package com.erikpihel.algorithms;

public class ReverseString {
	public static String reverse(String str) {
		char[] strArr = str.toCharArray();
		int numChars = str.length();

		for (int i = 0, j = numChars - 1; i < numChars / 2; ++i, --j) {
			char rightSide = strArr[j];
			strArr[j] = strArr[i];
			strArr[i] = rightSide;
		}

		return new String(strArr);
	}
}
