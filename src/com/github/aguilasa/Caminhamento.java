package com.github.aguilasa;

public class Caminhamento {

	public static void main(String[] args) {
		StringBuilder entryData = Utils.loadFile("resources/in.txt");
		EntryPoints entryPoint = new EntryPoints();
		entryPoint.setEntryData(entryData.toString());
		Utils.adjustPoints(entryPoint);
		
		Dijkstra dijkstra = new Dijkstra(entryPoint);
		dijkstra.doDijkstra();
	}

}
