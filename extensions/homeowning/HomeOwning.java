package homeowning;

import cse131.ArgsProcessor;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;


/**
 * @author Yang
 *
 */
public class HomeOwning {

//Q:	
//	The rent for a year, shown in dollars (no cents)
//	The rent for a week, rounded to the nearest cent
//	The interest payments for a year, shown in dollars and cents
//	The interest payments for a week, rounded to the nearest cent
//	Your decision, based on cost, of whether to rent or own, based on which is cheaper
	
//	note 
//	owning payment = principle + interest
	
	
// In working with money, computer scientists typically avoid double data types,
// because they sometimes approximate an intended value. Thus, $123.45 can be
// represented as the integer 12345 in cents per month.

	
	public static String compare(BigDecimal rent, BigDecimal owning) {
		
		String output = "compare not complete";
		
		if (rent.compareTo(owning) < 0)  {
			output = "I should rent";
		}
		
		if (rent.compareTo(owning) == 0)  {
			output = "Same amount";
			}
		if (rent.compareTo(owning) > 0)  {
			output = "I should buy";
			}
		
		return output;
	}
	
	

	
	
	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);

//user input name, zip
		String aptName = ap.nextString("the name of the apartment complex");
				String zipCode = ap.nextString("the zip code of the apartment");
//user input rent
		String monthlyRent = ap.nextString("the monthly rent of the apartment");
		BigDecimal montly_Rent = new BigDecimal(monthlyRent);

//user input owning
		String dailyInterest = ap.nextString("the daily interest payment for your mortgage on the house");
		BigDecimal daily_Interest = new BigDecimal(dailyInterest);

//prepare for the answer
		BigDecimal weekly_Rent, yearly_Rent;
		weekly_Rent = montly_Rent.divide( new BigDecimal("4"));
		weekly_Rent = weekly_Rent.setScale(2, RoundingMode.HALF_EVEN);
		yearly_Rent = montly_Rent.multiply(new BigDecimal("12"));
		yearly_Rent = yearly_Rent.setScale(2, RoundingMode.HALF_EVEN);

		
		BigDecimal yearly_Interest, weekly_Interest;
		yearly_Interest = daily_Interest.multiply(new BigDecimal("365"));
		yearly_Interest = yearly_Interest.setScale(2, RoundingMode.HALF_EVEN);

		weekly_Interest = daily_Interest.multiply(new BigDecimal("7"));
		weekly_Interest = weekly_Interest.setScale(2, RoundingMode.HALF_EVEN);

		
//output 1
		System.out.println(aptName + " is located in the Zip Code " + zipCode);
		
//output 2
		System.out.println("Rent per year: " + yearly_Rent);
		
//output 3
		System.out.println("Rent per week: " + weekly_Rent);

//output 4
		System.out.println("Interest paid per year: " + yearly_Interest);
				
//output 5
		System.out.println("Interest paid per week: " + weekly_Interest);		
		
//output 6
		String result = compare(weekly_Rent, weekly_Interest);
		System.out.println(result);		
		

		
	}
}
