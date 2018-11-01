package scraping;

public class StringTheory {

	/**
	 * 
	 * @param s input string
	 * @return the value of the string
	 */
	public static double stringScraper(String s){
		char[] c = new char[s.length()];
		String m = "";
		String p = "";
		String n = "";

		// assign string to char
		for(int i = 0; i<s.length(); i++){
			c[i] = s.charAt(i);
		}

		// separate different kind of char
		for (int j=0; j<c.length; j++){
			if (Character.isDigit(c[j]) && p == "") m = m + c[j];
			else if (!Character.isDigit(c[j]) && !Character.isWhitespace(c[j])) p = p + c[j];
			else if (Character.isDigit(c[j]) && p != "") n = n + c[j];
		}


		// transform into equation
		int a = Integer.parseInt(m);
		int b = Integer.parseInt(n);
		double result = 0;
		
		if (p.equals("+")) result = a + b;
		else if (p.equals("-")) result = a - b;
		else if (p.equals("*")) result = a * b;
		else result = (double) a / b;
		return result;
	}


	public static void main(String[] args) {
		String s = "21 - 33";
		System.out.print(stringScraper(s));

	}

}
