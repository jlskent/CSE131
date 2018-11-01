package scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cse131.ArgsProcessor;

public class StockScraper {

	public static void main(String[] args) throws IOException {
		// Prompt for the stock symbol
		ArgsProcessor ap = new ArgsProcessor(args);

		String stockSym = ap.nextString("What is the stock symbol to look up?");

		Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stockSym + "?p=" + stockSym).get();
		String wholeThing = doc.toString();

		// get the name of the full name of the company
		// extract string including full name
		int beginInd1 = wholeThing.indexOf("longName");
		int endInd1 = wholeThing.indexOf("FinanceConfigStore");
		String nameStr = wholeThing.substring(beginInd1+11, endInd1);
		// extract full name of the company from substring
		char[] nameChar = new char[nameStr.length()];
		String name = "";
		for (int i = 0; i < nameStr.length(); i++){
			nameChar[i] = nameStr.charAt(i);
			if(nameChar[i] != '"'){
				name = name + nameChar[i];
			}
			else break;
		}

		// extract string including current stock price
		int beginInd2 = wholeThing.indexOf("regularMarketDayLow");
		int endInd2 = wholeThing.indexOf("regularMarketSource");
		String priceStr = wholeThing.substring(beginInd2, endInd2);
		int priceInd1 = priceStr.indexOf("regularMarketPrice");
		String priceSubStr1 = priceStr.substring(priceInd1);
		int priceInd2 = priceSubStr1.indexOf("fmt");
		String priceSubStr2 = priceSubStr1.substring(priceInd2);
		// extract stock price from substring
		char[] priceChar = new char[priceStr.length()];
		String price = "";
		for (int i = 0; i < priceSubStr2.length(); i++){
			priceChar[i] = priceSubStr2.charAt(i);
			if (Character.isDigit(priceChar[i])|| priceChar[i]=='.'){
				price += priceChar[i];
			}
			else if (price != "") break;
		}
		
		
		// extract string including current stock price
				int beginInd3 = wholeThing.indexOf("preMarketSource");
				int endInd3 = wholeThing.indexOf("FinanceConfigStore");
				String changeStr = wholeThing.substring(beginInd3, endInd3);
				int changeInd = changeStr.indexOf("fmt");
				String changeSubStr = changeStr.substring(changeInd);
				// extract stock price from substring
				char[] changeChar = new char[changeStr.length()];
				String change = "";
				for (int i = 0; i < changeSubStr.length(); i++){
					changeChar[i] = changeSubStr.charAt(i);
					if (Character.isDigit(changeChar[i])|| changeChar[i]=='.'||changeChar[i]=='-'){
						change += changeChar[i];
					}
					else if (change != "") break;
				}
				double changeNum = Double.parseDouble(change);
				
				
				System.out.print("Input: " + stockSym);
				System.out.println();
				System.out.println("Stock information for " + name);
				if(changeNum>0){
					System.out.println("The current stock price is $" + price + " which is up " + changeNum +"% from yesterday.");	
				}
				else{
					System.out.println("The current stock price is $" + price + " which is down " + (-changeNum) +"% from yesterday.");
				}

		
		
		
	
	
	}


}
