/**
 * This class decodes the message that is passed in
 *
 */
public class LogicDecode {
	/** String message that is passed in **/
	private String string;
	/** Password that is passed in **/
	private int password;

	/**
	 * Constructor
	 * 
	 * @param stringPut
	 * @param pass
	 */
	public LogicDecode(String stringPut, int pass) {
		this.string = stringPut;
		password = pass;
	}

	/**
	 * Transfers the string message to a char array
	 * 
	 * @param str
	 * @return
	 */
	private char[] stringToChar(String str) {
		char[] c = str.toCharArray();
		return c;
	}

	/**
	 * Transfers the char array to an integer array of decimals
	 * 
	 * @param charA
	 * @return
	 */
	private int[] charToDecimal(char[] charA) {
		int[] decimal = new int[charA.length];
		for (int i = 0; i < charA.length; i++) {
			decimal[i] = Character.codePointAt(charA, i);
		}
		return decimal;
	}

	/**
	 * Use an algorithm to change the decimal array
	 * 
	 * @param originalDecimal
	 * @param pass
	 * @return
	 */
	private int[] convertDecimal(int[] originalDecimal, int pass) {
		int newpass = pass % 50;
		int[] newDecimal = originalDecimal;
		for (int i = 0; i < originalDecimal.length; i++) {
			newDecimal[i] = newDecimal[i] - 10 * newpass;
		}
		return newDecimal;
	}

	/**
	 * Use the new decimal array to get codes
	 * 
	 * @return
	 */
	public int[] getOriginal() {
		char[] a = stringToChar(string);
		int[] b = charToDecimal(a);
		return convertDecimal(b, password);
	}

}
