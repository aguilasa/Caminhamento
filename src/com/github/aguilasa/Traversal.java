package com.github.aguilasa;

public class Traversal {

	public static void main(String[] args) {
		StringBuilder entryData = Utils.loadFile("resources/in.txt");
		EntryPoints entryPoint = new EntryPoints();
		entryPoint.setEntryData(entryData.toString());
		
		Dijkstra dijkstra = new Dijkstra(entryPoint);
		dijkstra.doDijkstra();
	}

}
