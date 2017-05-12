package com.github.aguilasa;

import java.util.List;

public class Utils {

	public static double pointDist(Point p1, Point p2) {
		return Math.sqrt((p2.getX() - p1.getX()) ^ 2 + (p2.getY() - p1.getY()) ^ 2);
	}

	public static Pair closestPair(List<Point> points) {
		Pair pair = new Pair();
		double minDist = Double.MAX_VALUE;
		int length = points.size();
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				Point p1 = points.get(i);
				Point p2 = points.get(j);

				double pointDist = pointDist(p1, p2);
				if (pointDist < minDist) {
					minDist = pointDist;
					pair.setP1(p1);
					pair.setP2(p2);
				}
			}
		}

		return pair;
	}
}
