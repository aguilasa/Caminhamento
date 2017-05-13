package com.github.aguilasa;

public class Point {
	private int x;
	private int y;
	private int degree = 0;
	private int index = 0;

	public Point() {
		x = y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
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
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Point [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", degree=");
		builder.append(degree);
		builder.append(", index=");
		builder.append(index);
		builder.append("]");
		builder.append("\r\n");
		return builder.toString();
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
