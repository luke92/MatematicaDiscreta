package final20191212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio1 {

	public static void main(String[] args) {
		String palabra = "REORDENAMIENTO";
		System.out.println("Matematica Discreta Final 12/12/2019");
		
		System.out.println("Ejercicio 1");
		System.out.println("Considere el conjunto S formado por todas las palabras que se obtienen de los reordenamientos de las letras de la palabra " + palabra);
		
		System.out.println("Ejercicio 1A");
		System.out.println("Cuantos elementos tiene el conjunto S? ");
		System.out.println(ejercicio1A(palabra));
		
		System.out.println("Ejercicio 1B");
		System.out.println("Cuantos elementos en S empiezan con R o terminan con O?");
		System.out.println(ejercicio1B(palabra));
		
		System.out.println("Ejercicio 1C");
	}
	
	private static long ejercicio1B(String palabra) {
		long resultado = 0;
		
		return resultado;
		
	}
	
	private static long ejercicio1A(String palabra) {
		long resultado = 0;
		
		long cantidadLetras = palabra.length();
		System.out.println("Cantidad elementos: "+ cantidadLetras);
		
		List<Letra> letrasDistintas = new ArrayList<Letra>();
		
		for(char s : palabra.toCharArray()) {
			String caracter = String.valueOf(s);
			Letra letra = new Letra(caracter);
			if(!letrasDistintas.contains(letra)) {
				letrasDistintas.add(letra);
			}
			else {
				letrasDistintas.get(letrasDistintas.indexOf(letra)).sumarAparicion();
			}
			
		}
		
		System.out.println("Cantidad letras distintas : " + letrasDistintas.size());
		
		resultado = cantidadPermutaciones(cantidadLetras);
		
		for(Letra letraDistinta : letrasDistintas) {
			System.out.println("Letra " + letraDistinta.getLetra() +  " : " + letraDistinta.getApariciones());
			resultado /= cantidadPermutaciones(letraDistinta.getApariciones());
		}
		
		return resultado;
	}

	private static long cantidadPermutaciones(long cantidadLetras) {
		if(cantidadLetras == 0)
			return 1;
		return cantidadLetras * cantidadPermutaciones(cantidadLetras -1);
	}

}

class Letra {
	private Integer cantidadApariciones;
	private String letra;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letra == null) ? 0 : letra.hashCode());
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
		Letra other = (Letra) obj;
		if (letra == null) {
			if (other.letra != null)
				return false;
		} else if (!letra.equals(other.letra))
			return false;
		return true;
	}

	public Letra(String letra) {
		this.cantidadApariciones = 1;
		this.letra = letra;
		
	}
	
	public String getLetra() {
		return letra;
	}
	
	public long getApariciones() {
		return cantidadApariciones;
	}
	
	public void sumarAparicion() {
		cantidadApariciones++;
	}
}
