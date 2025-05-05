package de.pdbm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Is deduplication working?
 * 
 * <p>
 * Deduplication only works if G1 is used (default or {@code -XX:+UseG1GC}) and 
 * deduplication ({@code -XX:+UseStringDeduplication}) is required.
 * <p>
 * There is also a threshold option ({@code -XX:StringDeduplicationAgeThreshold=6}). 
 * For me it works only as a lower not an upper bound.
 * <p>
 * Switch {@code -XX:+PrintStringDeduplicationStatistics} was removed with Java 9.
 * Use {@code -Xlog:stringdedup*=debug} instead.
 * 
 * @author bernd
 *
 */
public class DeduplicationTest {
	
	@Test
	public void decuplication() throws Exception {
		String tmp = "Hello World";
		String string1 = new String(tmp + tmp);
		String string2 = new String(tmp + tmp);

		Assertions.assertEquals(string1, string2);
		Assertions.assertNotSame(string1, string2); // not interned
		Assertions.assertNotSame(Util.getValueBytes(string1), Util.getValueBytes(string2));
		
		System.gc(); Thread.sleep(1000);
		System.gc(); Thread.sleep(1000);
		System.gc(); Thread.sleep(1000);

		Assertions.assertNotSame(string1, string2);
		Assertions.assertSame(Util.getValueBytes(string1), Util.getValueBytes(string2));
	}
	
}
