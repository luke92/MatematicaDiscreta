package practica1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
	/*
	 * 9. Los n�meros en nuestro sistema de numeraci�n se construyen con los d�gitos 0 , 1, . . . , 8 o 9.
		Considere aquellos n�meros entre 1 y 10.000 ambos inclusive que se forman utilizando �nicamente
		los d�gitos 1, 2 y 3.
		a) Cu�ntos de dichos n�meros hay?
		b) Cu�ntos de dichos n�meros son impares?
		c) Cu�ntos de dichos n�meros son impares y tienen al menos una vez al d�gito 2?
	 */
	public static void main(String[] args) {
		System.out.println("9. Los n�meros en nuestro sistema de numeraci�n se construyen con los d�gitos 0 , 1, . . . , 8 o 9.\r\n" + 
				"		Considere aquellos n�meros entre 1 y 10.000 ambos inclusive que se forman utilizando �nicamente\r\n" + 
				"		los d�gitos 1, 2 y 3.");
		System.out.println("a) Cu�ntos de dichos n�meros hay?");
		List<Integer> numeros = numerosUsandoDigitos123Entre1y10000();
		System.out.println("b) Cu�ntos de dichos n�meros son impares?");
		numerosImpares(numeros);
		System.out.println("c) Cu�ntos de dichos n�meros son impares y tienen al menos una vez al d�gito 2?");
		System.out.println("Lo mismo que b porque es obligatorio usar al menos una vez al digito 2");
	}
	
	private static List<Integer> numerosUsandoDigitos123Entre1y10000()
    {
        List<Integer> numbers = new ArrayList<Integer>();
        char[] digits = new char[] { '1', '2', '3' };

        int minNumber = 100;
        int maxNumber = 10000;
        
        for (int i = minNumber; i < maxNumber; i++)
        {
            String number = String.valueOf(i);
            int contDigits = 0;
            boolean validNumber = true;
            boolean[] digitsAppear = new boolean[] { false, false, false };
            
            for (char digit : number.toCharArray())
            {
                if (digit == digits[0])
                {
                    digitsAppear[0] = true;
                }
                else if (digit == digits[1])
                {
                    digitsAppear[1] = true;
                }
                else if (digit == digits[2])
                {
                    digitsAppear[2] = true;
                }
                else
                {
                    validNumber = false;
                }
            }

            if (validNumber && digitsAppear[0] && digitsAppear[1] && digitsAppear[2])
            {
                numbers.add(i);
            }
        }

        System.out.println("Cantidad de numeros usando 1 2 y 3 : " + numbers.size());
        return numbers;
    }
	
	private static void numerosImpares(List<Integer> numeros)
    {
        List<Integer> listaImpares = new ArrayList<Integer>();

        for (int numero : numeros)
        {
            if (numero % 2 != 0)
            {
                listaImpares.add(numero);
                System.out.println(numero);
            }
        }

        System.out.println("Cantidad de numeros usando 1 2 y 3 Impares : " + listaImpares.size());

    }

}
