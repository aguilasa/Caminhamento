package com.github.aguilasa;

public class Caminhamento {

	public static void main(String[] args) {
		StringBuilder entryData = Utils.loadFile("resources/in.txt");
		EntryPoints ep = new EntryPoints();
		ep.setEntryData(entryData.toString());
		Utils.adjustPoints(ep);
		
	}

}
