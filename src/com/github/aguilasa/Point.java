package com.github.aguilasa;

import java.util.LinkedList;

public class Point {
	private String name = "";
	private int x;
	private int y;
	private int degree = 0;
	private int index = 0;
	private LinkedList<Point> adjacent = new LinkedList<>();

	public Point() {
		x = y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public void incDegree() {
		degree++;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		setName(String.format("V%d", index + 1));
	}

	public LinkedList<Point> getAdjacent() {
		return adjacent;
	}

	public void addAdjacent(Point p) {
		adjacent.add(p);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
