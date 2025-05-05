package de.pdbm;

/**
 * Demo to output some string table statistics.
 * 
 * Default bucket size is 65536. Smallest possible size is 16384. Only in between 32768.
 * 
 * 
 * @author bernd
 *
 */
public class StringTableStatistics {
	
	private static final String STRING = "0123456789";
	//private static final String STRING = "0";
	private static final int MAX = 10000;
	
	public static void main(String[] args) {
		StringTableStatistics.waste();
	}
	
	
	public static void waste() {
		//Thread.sleep(1000);
		String[] waste = new String[MAX];
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < MAX; i++) {
			//System.out.println(i);
			waste[i] = builder.append(STRING).toString().intern();
			//System.out.println(waste[i]);
		}

	}
}
