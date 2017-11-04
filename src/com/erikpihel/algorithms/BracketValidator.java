package com.erikpihel.algorithms;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class BracketValidator {
	/**
	 * Validates that the brackets [, {, and ( have valid opening and closing pairs.
	 * @param str  the string to parse
	 * @return  true if valid
	 * @throws ParseException  if there are opening brackets without closing brackets
	 */
	public static boolean validate(String str) throws ParseException {
		char[] charArr = str.toCharArray();
		int numChars = charArr.length;
		Map<Character, Integer> counts = new HashMap<>();
		counts.put('[', 0);
		counts.put('{', 0);
		counts.put('(', 0);
		
		for (int i = 0; i < numChars; ++i) {
			char c = charArr[i];
			switch(c) {
				case '[':
				case '{':
				case '(':
					counts.put(c, counts.get(c).intValue() + 1);
					break;
				case ']':
				case '}':
				case ')':
					char open = opener(c);
					int count = counts.get(open).intValue();

					if (count == 0) {
						throw new ParseException("Closed " + c + " with no corresponding open " + open + ".", i);
					}
					
					else {
						counts.put(open, count - 1);
					}
					break;
			}
		}
		
		StringBuilder err = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
			int numOpenTags = entry.getValue().intValue(); 
			if (numOpenTags > 0) {
				if (err.length() > 0) {
					err.append(", ");
				}
				err.append(numOpenTags).append(" open ").append(entry.getKey());
			}
		}
		
		if (err.length() > 0) {
			throw new ParseException(err.toString() + " tags were not closed.", -1);
		}
		
		else {
			return true;
		}
	}

	private static char opener(char closer) {
		switch(closer) {
			case ']':
				return '[';
			case '}':
				return '{';
			case ')':
				return '(';
			default:
				throw new RuntimeException("Expected ], }, or ), but found [" + closer + "].");
		}
	}
}
