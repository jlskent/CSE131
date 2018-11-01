package arrays;
import java.util.Arrays;

import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class Birthday {
	
//	Q:
//		After processing all of the N people, iterate over your array to compute:
//		For each month, the fraction (or percentage) of people born in that month.
//		The average of the 12 values you computed for the above.
//		For each day, the fraction (or percentage) of people born on that day, whether in the same or in a different month.
//		The average of the 31 values you computed for the above.
//		The fraction (or percentage) of people born on exactly the same day.
//		Be careful! A 1 entry means just one person was born on that particular day. You are looking for the fraction of people who share a birthday with at least one other person.
//	
	public static void main(String[] args) {
		
//		user input
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("number of people N that will enter the room.");
        int[][] birthday = new int[12][31];
//		random month and day
		System.out.println("----------result:");

		for(int i=0; i<N; i++) {
            int month = (int) (Math.random() * 12 + 1);
            int day = (int) (Math.random() * 31 + 1);

			System.out.println("month " + month + " day " + day);

//            add count for same birthday
            for (int m = 0; m<12;m++) {
            	for (int d = 0; d<31;d++) {
            		if (month == m+1 && day == d+1 )
            		birthday[m][d] = birthday[m][d] + 1;
            	}
            }
  
            
		}
		
		
//		Q1
		double sumOfP1 =0;
		System.out.println("\n----------For each month, the fraction (or percentage) of people born in that month.");
//		System.out.println("For each month, the fraction (or percentage) of people born in that month:");
        for (int m = 0; m<12;m++) {
    		int sum = Arrays.stream(birthday[m]).sum();
    		System.out.print((double)sum/N + " ");
    		sumOfP1 += (double)sum/N;
        }
        
        
        
//		Q2
		System.out.println("\n\n----------he average of the 12 values you computed for the above.");
		System.out.println("The average is: " + String.format("%.3f", sumOfP1/12));
		System.out.println("(which is 1/12)");

		
		
		
//		Q3	
		int sameDay[] = new int[31];
		for (int m = 0; m< 12; m++) {
        	for (int d = 0; d<31; d++) {
    			sameDay[d] += birthday[m][d];
        	}
        }
		System.out.println("\n----------For each day, the fraction (or percentage) of people born on that day, whether in the same or in a different month.");
		
		double sum_Percentage_Sameday = 0;
		double avg_Percentage_Sameday;
		for(int day:sameDay) {
			double percentage = (double)day/31;
			System.out.print(String.format("%.3f", percentage) + " ");
			sum_Percentage_Sameday +=percentage;
		}
		avg_Percentage_Sameday = sum_Percentage_Sameday/31;
		
		
//		Q4
		System.out.println("\n\n----------The average of the 31 values you computed for the above.");
		System.out.println(String.format("%.3f", avg_Percentage_Sameday));
//		System.out.println("");

		
		
		
//		Q5
		System.out.println("\n----------The fraction (or percentage) of people born on exactly the same day.");
//		System.out.println(Arrays.deepToString(birthday));

		for (int m = 0; m< 12; m++) {
        	for (int d = 0; d<31; d++) {
    			double percentage = (double)birthday[m][d]/365;
    			if (birthday[m][d] >1) {
    				int realM = m + 1;
    				int reayD = d + 1;
	    			System.out.print("birthday  " + realM + "," + reayD + "th     percentage "+ String.format("%.3f", percentage) + " ");
	    			System.out.println("");
    			}
        	}
        }

		
		
	}

}
