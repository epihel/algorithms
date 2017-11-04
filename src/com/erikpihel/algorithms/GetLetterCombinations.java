package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of characters, returns all possible word combinations
 * from those characters.
 */
public class GetLetterCombinations {
	public static String[] getCombinations(String word) {
		List<String> combinations = new ArrayList<>();
		addCombinations(word.toCharArray(), combinations, new StringBuilder());
		return combinations.toArray(new String[0]);
	}
	
	private static void addCombinations(char[] chars, List<String> combinations, StringBuilder word) {
        // if the current string has reached its maximum length
        if (word.length() == chars.length) {
        	combinations.add(word.toString());
        }

        else {
            for (char c : chars) {
                String currentFork = word.toString();

                // go through all possibilities on this fork
                word.append(c);
                addCombinations(chars, combinations, word);

                // retreat to previous fork to go through next set of combinations
                word = new StringBuilder(currentFork);
            }
        }
    }
}