package main;

import Algoritmi.Camillo;

public class Application {

	private static String inputFilesPath = "./inputs/";

	public static void main(String[] args) {
		
		Camillo camillo = new Camillo(inputFilesPath + "inputCamillo.txt");
		camillo.process("./outputs/outputCamillo.txt");

	
	}



}
