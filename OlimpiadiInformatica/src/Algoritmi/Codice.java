package Algoritmi;

public class Codice extends Algoritmo{
	
	private String codice;
	
	public Codice() {
		super();
		
	}
	
	public Codice(String inputFilePath) {
		super("Codice", inputFilePath);
		init();
		
	}
	
    @Override
	public void calculate() {
    	
    	String tempCodice = codice;
    	
    	while(tempCodice.indexOf("*")!=0) {
    		
    		int lengthDigits = getLengthDigits(tempCodice);
    		tempCodice = dropCharacters(tempCodice, lengthDigits+1);
    		int length = readLength(tempCodice, lengthDigits);
    		tempCodice = dropCharacters(tempCodice, lengthDigits);
    		long number = readNumber(tempCodice, length);
    		tempCodice = dropCharacters(tempCodice, length);
    		
    		outputLines.add(String.valueOf(number));
    		
    	}

	}
    

	private void init() {
    	
    	codice = inputLines.get(0);
    	
    }
    
    private int getLengthDigits(String codice) {
    	
    	int countZeros=0;
		for(int i=0; i<codice.length(); i++) {
			if(codice.substring(i, i+1).equals("0")) {
				countZeros++;
			} else {
				break;
			}
		}
		
    	return countZeros;
    }
    
    private int readLength(String codice, int lengthDigits) {
    	return Integer.parseInt(codice.substring(0, lengthDigits));

    }
    
    private long readNumber(String codice, int length) {
    	return Long.parseLong(codice.substring(0, length));

    }
    
    private String dropCharacters(String codice, int charactersToDrop) {
		
		return codice.substring(charactersToDrop);
	}


}
