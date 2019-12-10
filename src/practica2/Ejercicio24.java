package practica2;

import java.util.Arrays;
import java.util.HashSet;

public class Ejercicio24 {
	/*
	 * 24. Considere los números con 7 dígitos; es decir, los números que van del 1.000.000 al 9.999.999, ambos
			inclusive. Separe estos números de la siguiente forma: ponga dos números en un mismo subconjunto
			si y sólo si la escritura decimal de uno de ellos se obtiene reordenando los dígitos de la escritura
			decimal del otro. Por ejemplo, 1333414 iría en el mismo subconjunto que 3441133. ¾Cuántos de estos
			subconjuntos hay?
	 */
	public static void main(String[] args) {
		
		subConjuntosConMismaEscrituraDecimal(1000000,9999999);
	}

	private static void subConjuntosConMismaEscrituraDecimal(int numeroMinimo, int numeroMaximo) {
		HashSet<NumeroEspecial> numeros = new HashSet<NumeroEspecial>();
		
		for(int i = numeroMinimo; i < numeroMaximo; i++) {
			NumeroEspecial numeroEspecial = new NumeroEspecial(i);
			if(!numeros.contains(numeroEspecial)) {
				numeros.add(numeroEspecial);
			}
		}
		
		System.out.println("Cantidad de Subconjuntos: " + numeros.size());
	}

}

class NumeroEspecial {
	private Integer numero;
	
	private int[] cantidadDigitosNumeros = new int[10];
	
	public NumeroEspecial(Integer numero) {
		this.numero = numero;
		String numeroString = numero.toString();
		
		for(int i = 0; i < 10; i ++) {
			cantidadDigitosNumeros[i] = 0;
		}
		
		for(Character digito : numeroString.toCharArray()) {
			String digitoStr = digito.toString();
			cantidadDigitosNumeros[Integer.parseInt(digitoStr)]++;	
			
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cantidadDigitosNumeros);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumeroEspecial other = (NumeroEspecial) obj;
		if (!Arrays.equals(cantidadDigitosNumeros, other.cantidadDigitosNumeros))
			return false;
		return true;
	}
	
	
}
