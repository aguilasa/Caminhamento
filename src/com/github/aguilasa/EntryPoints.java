/** @author Ingmar.Aguiar 
 * 
 */
package com.github.aguilasa;

import java.util.ArrayList;
import java.util.List;

public class EntryPoints {
	private String entryData = "";
	private boolean processed = false;
	private List<Point> points = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();

	public EntryPoints() {

	}

	public EntryPoints(String entryData) {
		if (!this.entryData.equalsIgnoreCase(entryData)) {
			this.entryData = entryData;
			processed = false;
		}
	}

	public String getEntryData() {
		return entryData;
	}

	public void setEntryData(String entryData) {
		this.entryData = entryData;
	}

	public List<Point> getPoints() {
		checkProcessed();

		return points;
	}

	public List<Edge> getEdges() {
		checkProcessed();

		return edges;
	}

	private void checkProcessed() {
		if (!processed) {
			process();
		}
	}

	private void process() {
		processPoints();
		adjustPoints();
		resetPointIndex();
		processAdjacencies();
		processed = true;
	}

	private void processPoints() {
		points.clear();
		edges.clear();
		String[] lines = entryData.split("\r?\n");
		for (String line : lines) {
			List<Integer> numbers = Utils.getNumbers(line);
			if (numbers.size() == 4) {
				Point p1 = new Point(numbers.get(0), numbers.get(1));
				Point p2 = new Point(numbers.get(2), numbers.get(3));

				p1 = addPoint(p1);
				p2 = addPoint(p2);

				// p1.addAdjacent(p2);
				// p2.addAdjacent(p1);

				edges.add(new Edge(p1, p2));
			}
		}
	}

	private void adjustPoints() {
		List<Point> oneDegreePoints = Utils.oneDegreePoints(points);
		while (!oneDegreePoints.isEmpty()) {
			Point first = oneDegreePoints.remove(0);
			Point next = Utils.closestPoint(first, points);

			if (next.getDegree() == 1) {
				replacePoints(next, first);
			} else {
				replacePoints(first, next);
			}

			oneDegreePoints = Utils.oneDegreePoints(points);
		}
	}

	private Point addPoint(Point point) {
		if (!points.isEmpty()) {
			int index = points.indexOf(point);
			if (index >= 0) {
				point = points.get(index);
				point.setIndex(index);
			} else {
				points.add(point);
				point.setIndex(points.indexOf(point));
			}
		} else {
			points.add(point);
		}
		point.incDegree();
		return point;
	}

	private void replacePoints(Point from, Point to) {
		for (Edge edge : edges) {
			if (edge.getP1() == from) {
				edge.setP1(to);
			}

			if (edge.getP2() == from) {
				edge.setP2(to);
			}
		}

//		Point first = from.getAdjacent().getFirst();
//		first.getAdjacent().remove(from);
//		first.getAdjacent().add(to);

		to.setDegree(to.getDegree() + from.getDegree());
		to.setIndex(Math.min(to.getIndex(), to.getIndex()));
		points.remove(from);
	}

	private void resetPointIndex() {
		int i = 0;
		for (Point p : points) {
			p.setIndex(i++);
		}
	}

	private void processAdjacencies() {
		for (Edge edge : edges) {
			edge.getP1().addAdjacent(edge.getP2());
			edge.getP2().addAdjacent(edge.getP1());
		}
	}
}
