package de.pdbm;

/**
 * Target to decompile: <code>javap -l -s -verbose de.pdbm.Indify</code>.
 * 
 * @author bernd
 *
 */
public class Indify {

	public static void main(String[] args) {
		String greeting = "Hello" + " " + "world!";
		System.out.println(args[0] + " sends a " + greeting + " to " + args[1]);
	}

}
