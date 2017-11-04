package com.erikpihel.algorithms;

import java.text.ParseException;

import org.junit.Test;

public class BracketValidatorTest {
	@Test
	public void testValidate() throws Exception {
		testValidate(true, "Hello (goodbye).");
		testValidate(true, "He{l{l(o} go[od])bye}.");
		
		testValidate(false, "Hello )goodbye).");
		testValidate(false, "He{l{l(o}( go[od])bye}.");
		testValidate(false, "He{l{l(o} go[od])bye.");
	}
	
	private void testValidate(boolean valid, String str) throws Exception {
		try {
			BracketValidator.validate(str);
			if (!valid) {
				throw new Exception("Expected [" + str + "] to be invalid, but was valid.");
			}
		}
		
		catch(ParseException e) {
			if (valid) {
				throw new IllegalStateException("Expected [" + str + "] to be valid, but generated ParseException " + e.getMessage());
			}
			
			else {
				System.out.println("Found expected ParseException " + e.getMessage());
			}
		}
	}
}
