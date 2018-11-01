package mousefollower;

public class FollowTheMouse {

	/**
	 * 
	 * @return the x and y coordinate of the mouse currently
	 */
	public static double[] getMousePosition() {
		return new double[] { -1, -1 };   // FIXME
	}

	/**
	 * Draw a ball of radius r at the specified location
	 * @param location the x and y coordinate for the ball
	 * @param r the radius of the ball
	 */
	public static void drawBall(double[] location, double r) {
		// Delete the following line and then draw the ball here as specified
		//  in the write up
		throw new UnsupportedOperationException("Implement drawBall!");
	}
	
	/**
	 * 
	 * @param currentBallPosition the location of the ball currently
	 * @param mousePosition the location of the mouse currently
	 * @param speed the speed with which the ball should move toward the mouse
	 * @return the next location of the ball given its current position, the mouse's position, and the speed
	 */
	public static double[] changePosition(double[] currentBallPosition, double[] mousePosition, double speed) {
		throw new UnsupportedOperationException("Implement changePosition!");
	}

}
