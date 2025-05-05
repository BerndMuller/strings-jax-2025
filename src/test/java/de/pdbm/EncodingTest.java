package de.pdbm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for one, two and four bytes encoding.
 * 
 * @author bernd
 *
 */
public class EncodingTest {
	
	/**
	 * Assert that "a" has a one byte representation.
	 * 
	 * See Unicode <a href="http://www.unicode-symbol.com/u/0061.html">latin small letter a</a>
	 */
	@Test
	public void oneByteRepresentation() {
		final String str = "\u0061";

		Assertions.assertTrue(str.equals("a"));
		Assertions.assertEquals(1, str.length());
		Assertions.assertEquals(1, str.codePointCount(0, str.length()));
		Assertions.assertEquals(1, Util.getValueBytes(str).length);
	}

	
	/**
	 * Assert that "ś" has a two byte representation.
	 * 
	 * See Unicode <a href="http://www.unicode-symbol.com/u/015B.html">latin small letter s with acute</a>
	 */
	@Test
	public void twoBytesRepresentation() {
		final String str = "\u015B"; 

		Assertions.assertTrue(str.equals("ś"));
		Assertions.assertEquals(1, str.length());
		Assertions.assertEquals(1, str.codePointCount(0, str.length()));
		Assertions.assertEquals(2, Util.getValueBytes(str).length);
	}


	/**
	 * Assert that at least one two byte character switches to two byte representation for Latin 1.
	 */

	@Test
	public void atleastOneTwoBytesRepresentation() {
		final String str = "\u015B" + "a"; 

		Assertions.assertEquals(2, str.length());
		Assertions.assertEquals(2, str.codePointCount(0, str.length()));
		Assertions.assertEquals(4, Util.getValueBytes(str).length);
	}

	
	/**
	 * Assert that "𩸽" has a four byte representation.
	 * 
	 * See Unicode <a href="http://www.unicode-symbol.com/u/29E3D.html">cjk unified ideograph-29E3D</a>
	 */
	@Test
	public void fourBytesRepresentation() {
		final String str = "𩸽"; // hex: 29E3D, int: 171581

		Assertions.assertTrue(str.equals(new String(new int[] { 171581 }, 0, 1)));
		Assertions.assertEquals(2, str.length());
		Assertions.assertEquals(1, str.codePointCount(0, str.length()));
		Assertions.assertEquals(4, Util.getValueBytes(str).length);
	}

	
	
	/**
	 * Assert that at least one four byte character switches to two byte representation for Latin 1.
	 */
	@Test
	public void atLeastOneFourBytesRepresentation() {
		final String str = "𩸽" + "a"; 
		Assertions.assertEquals(3, str.length());
		Assertions.assertEquals(2, str.codePointCount(0, str.length()));
		Assertions.assertEquals(6, Util.getValueBytes(str).length);
	}

}
