package com.github.aguilasa.ui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.aguilasa.Point;

public class View extends JFrame {

	private static final int CIRCLE_DIAMETER = 10;
	private static final int MULTIPLIER = 20;
	private static final int TOP_BORDER = 30;
	private JPanel contentPane;
	private List<Point> points;
	private int width;
	private int height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(300, 450, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param points
	 */
	public View(int w, int h, List<Point> points) {
		this.width = w * MULTIPLIER + MULTIPLIER;
		this.height = h * MULTIPLIER + MULTIPLIER;
		this.points = points;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		// setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

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
