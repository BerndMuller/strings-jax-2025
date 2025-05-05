package de.pdbm;

import java.lang.reflect.Field;

public class Util {

	/**
	 * The bytes of value field of some string.
	 * 
	 * @param str the string
	 * @return the bytes representing this string
	 */
	public static byte[] getValueBytes(String str) {
		try {
			Field value = str.getClass().getDeclaredField("value");
			value.setAccessible(true);
			return (byte[]) value.get(str);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean checkRuntimeArguments(String... args) {
		return false;
	}
	
//	RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
//	List<String> arguments = runtimeMxBean.getInputArguments(); 
//	arguments.forEach(System.out::println);
//	
//	Assertions.assertTrue(arguments.containsAll(Arrays.asList("-XX:+UseG1GC","-XX:+UseStringDeduplication")),
//			          "Run only with G1 and String-Deduplication!" );
}
