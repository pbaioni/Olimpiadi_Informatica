package main;

import Algoritmi.Biblioteca;
import Algoritmi.Camillo;
import Algoritmi.Codice;
import Algoritmi.Giostra;
import Algoritmi.Pirellone;

public class Application {

	private static String inputFilesPath = "./inputs/";

	public static void main(String[] args) {

		Camillo camillo = new Camillo(inputFilesPath + "inputCamillo.txt");
		camillo.process("./outputs/outputCamillo.txt");

		Biblioteca biblioteca = new Biblioteca(inputFilesPath + "inputBiblioteca.txt");
		biblioteca.process("./outputs/outputBiblioteca.txt");

		Giostra giostra = new Giostra(inputFilesPath + "inputGiostra.txt");
		giostra.process("./outputs/outputGiostra.txt");

		Codice codice = new Codice(inputFilesPath + "inputCodice.txt");
		codice.process("./outputs/outputCodice.txt");
		
		Pirellone pirellone = new Pirellone(inputFilesPath + "inputPirellone.txt");
		pirellone.process("./outputs/outputPirellone.txt");

	}

}
