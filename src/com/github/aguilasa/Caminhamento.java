package com.github.aguilasa;

import java.util.List;

public class Caminhamento {

	public static void main(String[] args) {
//		List<Point> points = new ArrayList<>();
//		points.add(new Point(1, 1));
//		points.add(new Point(2, 1));
//		points.add(new Point(3, 6));
//		points.add(new Point(20, 5));
//		points.add(new Point(6, 8));
//		points.add(new Point(10, 11));
//		
//		Pair closestPair = Utils.closestPair(points);
//		System.out.println(closestPair.getP1() + " to " + closestPair.getP2());
		
		StringBuilder entryData = Utils.loadFile("resources/in.txt");
		EntryPoints ep = new EntryPoints();
		ep.setEntryData(entryData.toString());
		List<Point> pts = ep.getPoints();
		System.out.println(pts);
		
	}

}
