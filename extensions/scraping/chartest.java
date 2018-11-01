package scraping;

public class chartest {

	public static void main(String[] args) {
		String s = "21 + 33";
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
		
		int a = Integer.parseInt(m);
		int b = Integer.parseInt(n);
		
		boolean y = (p == "+");
		
		System.out.println(y);	
	}

}
