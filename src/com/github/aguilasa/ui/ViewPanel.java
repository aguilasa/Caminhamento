/** @author Ingmar.Aguiar 
 * 
 */
package com.github.aguilasa.ui;

import static com.github.aguilasa.ui.Consts.CIRCLE_DIAMETER;
import static com.github.aguilasa.ui.Consts.MULTIPLIER;
import static com.github.aguilasa.ui.Consts.TOP_BORDER;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import com.github.aguilasa.Edge;
import com.github.aguilasa.EntryPoints;
import com.github.aguilasa.Point;

public class ViewPanel extends JPanel {

	private EntryPoints points;
	private int width;
	private int height;

	public ViewPanel(EntryPoints entryPoints, int width, int height) {
		this.points = entryPoints;
		this.width = width;
		this.height = height;
	}

	public void paint(Graphics g) {
		super.paint(g); // fixes the immediate problem.
		if (points != null) {
			Graphics2D g2 = (Graphics2D) g;
			draw(g2);
		}
	}

	private void draw(Graphics2D g2) {
		for (Edge e : points.getEdges()) {
			drawEdge(e, g2);
		}

		for (Point p : points.getPoints()) {
			drawPoint(p, g2);
			drawPointName(p, g2);
		}
	}

	private void drawEdge(Edge e, Graphics2D g2) {
		Line2D lin = new Line2D.Float(adjustX(e.getP1()), adjustY(e.getP1()), adjustX(e.getP2()), adjustY(e.getP2()));
		g2.draw(lin);
	}

	private void drawPointName(Point p, Graphics2D g2) {
		Point center = getCenter(p);
		int w = g2.getFontMetrics().stringWidth(p.getName());
		int h = g2.getFontMetrics().getHeight();
//		g2.drawString(p.getName(), center.getX() + w / 2, center.getY());
		g2.drawString(p.getName(), adjustX(p)+w/2 ,adjustY(p));
	}

	private void drawPoint(Point p, Graphics2D g2) {
		Point center = getCenter(p);
		Ellipse2D.Double circle = new Ellipse2D.Double(center.getX(), center.getY(), CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		Color color = g2.getColor();
		Color background = g2.getBackground();
		try {
			g2.setColor(background);
			g2.fill(circle);
		} finally {
			g2.setColor(color);
		}
		g2.draw(circle);
	}

	private Point getCenter(Point p) {
		int middle = CIRCLE_DIAMETER / 2;
		int x = adjustX(p) - middle;
		int y = adjustY(p) - middle;
		return new Point(x, y);
	}

	private int adjustY(Point p) {
		return height - TOP_BORDER - p.getY() * MULTIPLIER;
	}

	private int adjustX(Point p) {
		return p.getX() * MULTIPLIER;
	}
}
