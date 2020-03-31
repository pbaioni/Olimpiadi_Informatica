package Algoritmi;

import java.util.Scanner;
import java.util.Vector;

public class Pirellone extends Algoritmo{
	
	private int righe;
	
	private int colonne;
	
	private Vector<Vector<Integer>>  matrix= new Vector<Vector<Integer>>();
	
	public Pirellone() {
		super();
		
	}
	
	public Pirellone(String inputFilePath) {
		super("Pirellone", inputFilePath);
		init();
		
	}

	private void init() {
		
		Scanner scanner = new Scanner(inputLines.get(0));
		righe = scanner.nextInt();
		colonne = scanner.nextInt();
		scanner.close();
		
		for(int i=1; i<inputLines.size(); i++) {
			Vector<Integer> row = new Vector<>();
			Scanner windowsScanner = new Scanner(inputLines.get(i));
			while(windowsScanner.hasNextInt()) {
				row.add(windowsScanner.nextInt());
			}
			windowsScanner.close();
			matrix.add(row);
			
		}
    }
	
	
    @Override
	public void calculate() {
    	
    	Vector<Vector<Integer>>  tempMatrix = matrix;
    	String rowSwitches = "";
    	String columnSwitches = "";

		for(int i=0; i<righe; i++) {
			if(tempMatrix.get(i).get(0)==1) {
				tempMatrix = switchRow(tempMatrix, i);
				rowSwitches += "1 ";
			} else {
				rowSwitches += "0 ";
			}
		}
		
		rowSwitches = rowSwitches.trim();
		
		for(int i=0; i<colonne; i++) {
			if(tempMatrix.get(0).get(i)==1) {
				tempMatrix = switchColumn(tempMatrix, i);
				columnSwitches += "1 ";
			} else {
				columnSwitches += "0 ";
			}
		}
		
		columnSwitches = columnSwitches.trim();
		
		boolean allSwitchedOff = true;
		
		for(int i=0; i<righe; i++) {
			for(int j=0; j<colonne; j++) {
				if(tempMatrix.get(i).get(j)==1) {
					allSwitchedOff = false;
					break;
				}
			}
		}
		
		if(allSwitchedOff) {
			outputLines.add(rowSwitches);
			outputLines.add(columnSwitches);
		} else {
			outputLines.add(createDefaultSwitches(righe));
			outputLines.add(createDefaultSwitches(colonne));
		}

	}
	
	private Vector<Vector<Integer>> switchRow(Vector<Vector<Integer>>  matrix, int row) {
		
		for(int i=0; i<colonne; i++) {
			if(matrix.get(row).get(i)==0) {
				matrix.get(row).set(i, 1);
			} else {
				matrix.get(row).set(i, 0);
			}
		}
		
		return matrix;
	}
	
	private Vector<Vector<Integer>> switchColumn(Vector<Vector<Integer>>  matrix, int column) {
		
		for(int i=0; i<righe; i++) {
			if(matrix.get(i).get(column)==0) {
				matrix.get(i).set(column, 1);
			} else {
				matrix.get(i).set(column, 0);
			}
		}
		
		return matrix;
	}

	private String createDefaultSwitches(int numberOfSwitches) {
		
		String rval = "";
		
		for(int i=0; i<numberOfSwitches; i++) {
			rval += "0 ";
		}
		
		return rval.trim();
	}

}
