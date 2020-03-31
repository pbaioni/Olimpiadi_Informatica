package Algoritmi;

public class Camillo extends Algoritmo{
	
	private int prelievo;
	
	private static int[] tagli = {100, 10, 5, 2, 1};
	
	public Camillo() {
		super();
		
	}
	
	public Camillo(String inputFilePath) {
		super("Camillo", inputFilePath);
		init();
		
	}
	
    private void init() {
		
    	prelievo = Integer.parseInt(inputLines.get(0));
		
	}

	@Override
	public void calculate() {
		
		int resto = prelievo;

		for(int taglio : tagli) {
			
			Double divisione = (double) (resto/taglio);
			int bigliettiDiQuestoTaglio = divisione.intValue();
			resto = resto - bigliettiDiQuestoTaglio*taglio;
			outputLines.add(String.valueOf(bigliettiDiQuestoTaglio));
			
		}
		
	}


}
