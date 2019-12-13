package final20191212;

public class Ejercicio2B {
	/*
	 * Contar la cantidad de numeros capicuas de 6 cifras tal que sus digitos sumen 22
	 * Usar principio de Inclusion - Exclusion
	 */
	public static void main(String[] args) {
		cantidadNumerosCapicua(6,22);
		
	}
	

	private static void cantidadNumerosCapicua(int cantidadCifras, int sumaTotal) {
		int menorNumero = ((int) Math.pow(10, cantidadCifras -1));
		int mayorNumero = ((int) Math.pow(10, cantidadCifras)) -1;
		System.out.println(menorNumero);
		System.out.println(mayorNumero);
		int cantidad = 0;
		for(int i = menorNumero; i <= mayorNumero; i++) {
			
			if(isCapicua(i) && sumaCifras(i) == sumaTotal) {
				System.out.println(i);
				cantidad++;
			}
				
		}
		
		System.out.println("Numeros capicua de " + cantidadCifras + " cifras que sumen " + sumaTotal + ": " + cantidad);
	}
	
	private static boolean isCapicua(int numero) {
		String numeroStr = String.valueOf(numero);
		String numeroStrInvertido = new StringBuilder(numeroStr).reverse().toString();
		int cantidadDigitosPorParte = numeroStr.length() / 2;
		if(numeroStr.length() % 2 == 1) 
			cantidadDigitosPorParte++;
		String numeroStrPrimerParte = numeroStr.substring(0, cantidadDigitosPorParte);
		String numeroStrSegundaParte = numeroStrInvertido.substring(0, cantidadDigitosPorParte);
		if(numeroStrPrimerParte.equals(numeroStrSegundaParte)) {
			return true;
		}
		return false;
		
	}
	
	private static int sumaCifras(int numero) {
		int suma = 0;
		String numeroStr = String.valueOf(numero);
		for(char digito : numeroStr.toCharArray()) {
			String digitoStr = String.valueOf(digito);
			suma += Integer.parseInt(digitoStr);
		}
		return suma;
	}
	
}
