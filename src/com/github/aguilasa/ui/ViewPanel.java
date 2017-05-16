package com.github.aguilasa.ui;

import static com.github.aguilasa.ui.Consts.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JPanel;

import com.github.aguilasa.Point;

public class ViewPanel extends JPanel {

	private List<Point> points;
	private int width;
	private int height;
	
	public void paint(Graphics g) {
		super.paint(g); // fixes the immediate problem.
		if (points != null) {
			Graphics2D g2 = (Graphics2D) g;
			draw(g2);
		}
	}

	private void draw(Graphics2D g2) {
		// Line2D lin = new Line2D.Float(100, 100, 250, 260);
		// g2.draw(lin);
		for (Point p : points) {
			drawPoint(p, g2);
		}
	}

	private void drawPoint(Point p, Graphics2D g2) {
		int middle = CIRCLE_DIAMETER / 2;
		int x = p.getX() * MULTIPLIER - middle;
		int y = (height - TOP_BORDER - p.getY() * MULTIPLIER) + middle;
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
		g2.draw(circle);
	}
}
