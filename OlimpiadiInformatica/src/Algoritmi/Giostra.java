package Algoritmi;

import java.util.Scanner;

public class Giostra extends Algoritmo{
	
	int a;
	
	int b;
	
	public Giostra() {
		super();
		
	}
	
	public Giostra(String inputFilePath) {
		super("Giostra", inputFilePath);
		init();
		
	}
	
    @Override
	public void calculate() {
    	
    	int bMinimo = 0;
    	int vagoniVisitabili = calcolaVagoniVisitabili(a, b);
    	
    	for(int i=20; i<=32000; i++) {
    		int tempVagoniVisitabili = calcolaVagoniVisitabili(a, i);
    		if(a==tempVagoniVisitabili) {
    			bMinimo = i;
    			break;
    		}
    	}
    	
    	outputLines.add(String.valueOf(vagoniVisitabili) + " " + bMinimo);

	}
    
    private int calcolaVagoniVisitabili(int a, int b) {
    	
    	int position = 0;
    	int vagoniVisitabili = 1;
    	boolean goOn = true;
    	
    	while(goOn) {
    		
    		int newPosition = (position + b)%a;
    		
    		if(newPosition != 0) {
    			vagoniVisitabili++;
    			position = newPosition;
    		} else {
    			goOn = false;
    		}
    		
    	}
    	
    	return vagoniVisitabili;
    	
    }
    
    private void init() {
    	
		Scanner scanner = new Scanner(inputLines.get(0));
		a = scanner.nextInt();
		b = scanner.nextInt();
		scanner.close();
    	
    }


}
