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
		Point origin = entry.getOriginPoint();
		cost.set(origin.getIndex(), 0.0);
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
	}

	public void printDijkstra() {
		Point destiny = entry.getDestinyPoint();

		outPrint(destiny);
	}

	public void outPrint(Point destiny) {
		if (!predecessor.isEmpty()) {
			LinkedList<Point> points = new LinkedList<>();
			points.add(destiny);

			Point pred = predecessor.get(destiny.getIndex());
			while (pred != null) {
				points.addFirst(pred);
				pred = predecessor.get(pred.getIndex());
			}

			StringBuilder out = new StringBuilder();
			out.append("Origem: ").append(points.getFirst()).append("\r\n");
			out.append("Destino: ").append(points.getLast()).append("\r\n").append("\r\n");
			out.append("X\tY\tVértice\t\tDistância\r\n");
			Point previous = null;
			Double total = 0.0;
			for (Point p : points) {
				out.append(p.getX()).append("\t");
				out.append(p.getY()).append("\t");
				out.append(p).append("\t\t");
				if (previous != null) {
					double pointDist = Utils.pointDist(previous, p);
					total += pointDist;
					out.append(pointDist);
				}
				out.append("\r\n");

				previous = p;
			}

			out.append("\r\nTotal\t").append(total);
			out.append("\r\n---------------------------------------------------------");
			out.append("\r\n\r\n");

			System.out.println(out);
		}
	}

}
