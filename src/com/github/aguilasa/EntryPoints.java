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
		if (!processed) {
			process();
		}

		return points;
	}

	public List<Edge> getEdges() {
		if (!processed) {
			process();
		}

		return edges;
	}

	// (42, 3) (41, 1)
	private void process() {
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
				
				edges.add(new Edge(p1, p2));
			}
		}
	}

	private Point addPoint(Point point) {
		if (!points.isEmpty()) {
			int indexOf = points.indexOf(point);
			if (indexOf >= 0) {
				point = points.get(indexOf);
			} else {
				points.add(point);
			}
		} else {
			points.add(point);
		}
		point.incDegree();
		return point;
	}

}
