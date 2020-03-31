package Algoritmi;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import helper.FileHelper;

public abstract class Algoritmo {

	private String name;

	private LocalDateTime start;

	List<String> inputLines = new ArrayList<String>();

	List<String> outputLines = new ArrayList<String>();

	public Algoritmo() {

	}

	public Algoritmo(String name, String inputFilePath) {
		this.name = name;
		inputLines = FileHelper.getAllFileLines(inputFilePath);
	}

	public void startExecution() {

		start = LocalDateTime.now();
	}

	public void endExecution() {

		LocalDateTime end = LocalDateTime.now();

		Duration d = Duration.between(start, end);

		System.out.println(
				name + " algorithm duration: " + d.getSeconds() + " seconds and " + d.getNano() / 1000000 + " millis.");

	}

	public void process(String outputFilePath) {
		
		startExecution();

		calculate();

		printAndStoreResult(outputFilePath);
		
		//in case of recall of this method
		outputLines.clear();

		endExecution();
	}

	public void calculate() {

	}

	public void printAndStoreResult(String outputFilePath) {
		
		System.out.println(name + " result: " + outputLines.toString());
		FileHelper.WriteLines(outputFilePath, outputLines);
	}

}
