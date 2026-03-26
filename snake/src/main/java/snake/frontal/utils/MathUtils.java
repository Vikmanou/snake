package snake.frontal.utils;

public class MathUtils {
	public static double distance(double x1, double y1, double x2, double y2) {
		double distanceX = x2 - x1;
		double distanceY = y2 - y1;

		return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
	}
}
