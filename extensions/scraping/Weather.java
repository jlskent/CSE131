package scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cse131.ArgsProcessor;

public class Weather {
	
	public static void main(String[] args) throws IOException {
		ArgsProcessor ap = new ArgsProcessor(args);
			
		String zip = ap.nextString("What zip code?");
		
		Document doc = Jsoup.connect("http://www.wunderground.com/cgi-bin/findweather/getForecast?query="+zip).get();
		String wholeThing = doc.toString();
		//
		// Get rid of the print of the whole thing
		//
//		System.out.println(wholeThing);
		//
		// and instead do string searching and trimming 
		// to isolate the temperature reading
		// report that as your output
		//
		
		
		int beginInd1 = wholeThing.indexOf("curTemp");
		int endInd1 = wholeThing.indexOf("curFeel");
		String temp1 = wholeThing.substring(beginInd1, endInd1);
		
		int beginInd2 = temp1.indexOf("value");
		String temp2 = temp1.substring(beginInd2+7, beginInd2+11);
		
		System.out.println("Temperature is " + temp2 + " °F");
		//
		// And find one more statistic of interest and report that:
		//
		int beginInd3 = wholeThing.indexOf("curFeel");
		int endInd2 = wholeThing.indexOf("curWind");
		String feel1 = wholeThing.substring(beginInd3, endInd2);
		
		int beginInd4 = feel1.indexOf("value");
		String feel2 = feel1.substring(beginInd4+7, beginInd4+9);
		
		System.out.println("And it feels like " + feel2 + " °F"); 

	}

}
