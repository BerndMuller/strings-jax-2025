package de.pdbm;

public class CompactStrings {

	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyz";
		
		System.out.println(str.length());
		System.out.println(str.codePointCount(0, str.length()));
		System.out.println(Util.getValueBytes(str).length);
	}

}
