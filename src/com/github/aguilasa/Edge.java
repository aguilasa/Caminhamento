/** @author Ingmar.Aguiar 
 * 
 */
package com.github.aguilasa;

public class Edge {
	private Point p1;
	private Point p2;

	public Edge() {

	}

	public Edge(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Edge [p1=");
		builder.append(p1);
		builder.append(", p2=");
		builder.append(p2);
		builder.append("]");
		return builder.toString();
	}

}
