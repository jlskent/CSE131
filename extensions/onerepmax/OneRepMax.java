package onerepmax;

import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class OneRepMax {
//To do : make sure the rounding is right
	
	
	public static void main(String[] args) {
//		user input
		ArgsProcessor ap = new ArgsProcessor(args);
		int weight = ap.nextInt("current one-rep max bench weight");
		int reps = ap.nextInt("Successful reps");
		int desiredReps = ap.nextInt("Desired reps");

//		calculation
		int oneRM =  (int)( weight * ( 1 + reps/30.0));
		double weight_n_Reps =  oneRM /(1 + (double)desiredReps/30) ;
		
		int Rounded_Weight_n_Reps = (int) Math.round(weight_n_Reps/5) * 5;
		
		String output1 = "One-rep Max: " + oneRM + "\nWeight for 5 reps: " + Rounded_Weight_n_Reps;

		
		System.out.println(output1);
		
		
		int percentage = 100;
		while (percentage > 50) {
			percentage = percentage -5 ;
			System.out.println(percentage + "% 1 RM: " + Math.round(oneRM * percentage/100/5) * 5);
		}
		
		

	}

}
