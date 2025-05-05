package de.pdbm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests to show string pool working.
 * 
 * <p>
 * Remark: variables are declared inside methods to prevent scrolling when shown
 * in conference demos. Declaration at class level (i.e. fields) doesn't change anything.
 * 
 * @author bernd
 *
 */
public class PoolTest {
	
	@Test
	public void sameLiterals() {
		Assertions.assertSame("Hello, World!", "Hello, World!");
	}

	@Test
	public void sameLiteralVariables() {
		String str1 = "Hello, World!";
		String str2 = "Hello, World!";
		Assertions.assertSame(str1, str2);
	}

	@Test
	public void sameLiteralExpressions() {
		Assertions.assertSame("Hello, " + "World!", "Hello, " + "World!");
		Assertions.assertSame("Hello, " + "World!", "H" + "ello," + " World!");
	}

	@Test
	public void notSameVariableExpressions() {
		String str1 = "Hello, World!";
		String str2 = "Hello, World!";
		Assertions.assertNotSame(str1 + str2, str1 + str2);
	}
	
	@Test
	public void sameConstantExpressions() {
		final String str1 = "Hello, World!";
		final String str2 = "Hello, World!";
		Assertions.assertSame(str1 + str2, str1 + str2);
	}
	
	@Test
	public void sameAfterInterning() {
		String str1 = "Hello, World!";
		String str2 = "Hello, World!";
		Assertions.assertNotSame(str1 + str2, str1 + str2);
		Assertions.assertSame((str1 + str2).intern(), (str1 + str2).intern());
	}
	
	@Test
	public void notSameCreated() {
		String str1 = new String("Hello, World!");
		String str2 = new String("Hello, World!");
		Assertions.assertEquals(str1, str2);
		Assertions.assertNotSame(str1, str2);
	}

}
