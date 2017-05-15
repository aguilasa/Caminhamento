package com.github.aguilasa;

import java.util.List;

public class Caminhamento {

	public static void main(String[] args) {
		StringBuilder entryData = Utils.loadFile("resources/in.txt");
		EntryPoints ep = new EntryPoints();
		ep.setEntryData(entryData.toString());
		Utils.adjustPoints(ep);
		
		List<Edge> edges = ep.getEdges();
		for (Edge e : edges) {
			System.out.println(e.getP1() + " " + e.getP2());
		}
	}

}
