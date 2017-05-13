package com.github.aguilasa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static StringBuilder loadFile(String filePath) {
		StringBuilder content = new StringBuilder();
		try {
			FileReader file = new FileReader(filePath);
			BufferedReader in = new BufferedReader(file);
			try {
				boolean done = false;
				while (!done) {
					String line = in.readLine();
					if (line == null) {
						done = true;
					} else {
						content.append(line.trim() + "\r\n");
					}
				}
			} finally {
				in.close();
			}
		} catch (IOException e1) {
		}
		return content;
	}

	public static double pointDist(Point p1, Point p2) {
		int difX = p2.getX() - p1.getX();
		int difY = p2.getY() - p1.getY();
		return Math.sqrt(Math.pow(difX, 2) + Math.pow(difY, 2));
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

	public static Point closestPoint(Point point, List<Point> points) {
		Point closest = null;
		double minDist = Double.MAX_VALUE;
		for (Point other : points) {
			if (other != point) {
				double pointDist = pointDist(point, other);
				if (pointDist < minDist) {
					minDist = pointDist;
					closest = other;
				}
			}
		}

		return closest;
	}

	public static List<Point> oneDegreePoints(List<Point> points) {
		List<Point> list = new ArrayList<>();
		for (Point point : points) {
			if (point.getDegree() == 1) {
				list.add(point);
			}
		}

		list.sort(new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				return p1.getIndex() - p2.getIndex();
			}
		});

		return list;
	}

	public static List<Integer> getNumbers(String value) {
		List<Integer> numbers = new ArrayList<>();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(value);
		while (m.find()) {
			numbers.add(Integer.valueOf(m.group()));
		}

		return numbers;
	}

	public static void adjustPoints(EntryPoints entry) {
		List<Point> oneDegreePoints = oneDegreePoints(entry.getPoints());
		while (!oneDegreePoints.isEmpty()) {
			Point first = oneDegreePoints.remove(0);
			Point next = closestPoint(first, entry.getPoints());

			if (next.getDegree() == 1) {
				entry.replacePoints(next, first);
			} else {
				entry.replacePoints(first, next);
			}

			oneDegreePoints = oneDegreePoints(entry.getPoints());
		}

	}
}
