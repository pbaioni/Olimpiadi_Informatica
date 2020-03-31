package Algoritmi;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Biblioteca extends Algoritmo{
	
	private LocalDateTime inizioPrestito;
	
	private LocalDateTime finePrestito;
	
	public Biblioteca() {
		super();
		
	}
	
	public Biblioteca(String inputFilePath) {
		
		super("Biblioteca", inputFilePath);
	}
	
	@Override
	public void calculate() {
		
		Scanner scanner = new Scanner(inputLines.get(0));
		int giornoInizio = scanner.nextInt();
		int meseInizio = scanner.nextInt();
		int giornoFine = scanner.nextInt();
		int meseFine = scanner.nextInt();
		scanner.close();
		
		inizioPrestito = LocalDateTime.of(2001, meseInizio, giornoInizio, 0, 0);
		
		finePrestito = LocalDateTime.of(2001, meseFine, giornoFine, 0, 0);
		
		long durataPrestito = ChronoUnit.DAYS.between(inizioPrestito, finePrestito);
		
		outputLines.add(String.valueOf(durataPrestito));
	}

}
