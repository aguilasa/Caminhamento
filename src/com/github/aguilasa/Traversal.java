/** @author Ingmar.Aguiar 
 * 
 */
package com.github.aguilasa;

import java.awt.EventQueue;
import java.util.List;

import com.github.aguilasa.ui.View;

public class Traversal {

	public static void main(String[] args) {
		StringBuilder entryData = Utils.loadFile("resources/in.txt");
		EntryPoints entryPoint = new EntryPoints();
		entryPoint.setEntryData(entryData.toString());

		List<Point> points = entryPoint.getPoints();
		List<Point> pointBounds = Utils.getPointBounds(points);
		Point point = pointBounds.get(1);

		Dijkstra dijkstra = new Dijkstra(entryPoint);
		dijkstra.doDijkstra();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(point.getX(), point.getY(), entryPoint);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
