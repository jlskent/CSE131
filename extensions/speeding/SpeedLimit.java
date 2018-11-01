package speeding;
 

import cse131.ArgsProcessor;

/**
 * @author Yang
 *
 */
public class SpeedLimit {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);

		// input speed limit
		double speedLimit = ap.nextInt("please enter the speed limit");
		while (speedLimit <= 0) {
			speedLimit = ap.nextInt("please enter a valid speed limit");
		}

		// input speed
		double inputSpeed = ap.nextInt("please enter your speed");
		while (speedLimit <= 0 || inputSpeed <= speedLimit) {
			inputSpeed = ap.nextInt("Please enter a speed value larger than speed limit");
		}

		// result
		double exceedSpeed = inputSpeed - speedLimit;
		double fine = (exceedSpeed <= 10) ? 50 : 50 + (exceedSpeed - 10) * 10;
		String result = "You reported a speed of " + inputSpeed + " MPH for a speed limit of " + speedLimit
				+ " MPH.\nYou went " + exceedSpeed + " MPH over the speed limit." + "\nYour fine is $" + fine + ".";
		System.out.println(result);

	}

}
