/** @author Ingmar.Aguiar 
 * 
 */
package com.github.aguilasa;

import java.util.LinkedList;
import java.util.List;

public class Dijkstra {

	private EntryPoints entry;
	private List<Point> predecessor = new LinkedList<>();
	private List<Double> cost = new LinkedList<>();
	private List<Point> priority = new LinkedList<>();

	public Dijkstra(EntryPoints entry) {
		this.entry = entry;
	}

	private void initialize() {
		cost.clear();
		predecessor.clear();
		for (Point point : entry.getPoints()) {
			cost.add(Double.MAX_VALUE);
			predecessor.add(null);
			priority.add(point);
		}
		cost.set(0, 0.0);
	}

	private Point extractMin() {
		Double minCost = Double.MAX_VALUE;
		Point minPoint = priority.get(0);
		for (Point point : priority) {
			Double pointCost = cost.get(point.getIndex());
			if (pointCost < minCost) {
				minCost = pointCost;
				minPoint = point;
			}
		}
		priority.remove(minPoint);
		return minPoint;
	}

	private void relax(Point u, Point v) {
		double pointDist = Utils.pointDist(u, v);
		Double dV = cost.get(v.getIndex());
		Double dU = cost.get(u.getIndex());
		if (dV > dU + pointDist) {
			cost.set(v.getIndex(), dU + pointDist);
			predecessor.set(v.getIndex(), u);
		}
	}

	public void doDijkstra() {
		initialize();

		while (!priority.isEmpty()) {
			Point u = extractMin();
			for (Point v : u.getAdjacent()) {
				relax(u, v);
			}
		}
		System.out.println("acabou");
	}

}
