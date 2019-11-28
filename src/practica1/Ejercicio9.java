package practica1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio9 {
	/*
	 * 9. Los números en nuestro sistema de numeración se construyen con los dígitos 0 , 1, . . . , 8 o 9.
		Considere aquellos números entre 1 y 10.000 ambos inclusive que se forman utilizando únicamente
		los dígitos 1, 2 y 3.
		a) Cuántos de dichos números hay?
		b) Cuántos de dichos números son impares?
		c) Cuántos de dichos números son impares y tienen al menos una vez al dígito 2?
	 */
	public static void main(String[] args) {
		System.out.println("9. Los números en nuestro sistema de numeración se construyen con los dígitos 0 , 1, . . . , 8 o 9.\r\n" + 
				"		Considere aquellos números entre 1 y 10.000 ambos inclusive que se forman utilizando únicamente\r\n" + 
				"		los dígitos 1, 2 y 3.");
		System.out.println("a) Cuántos de dichos números hay?");
		List<Integer> numeros = numerosUsandoDigitos123Entre1y10000();
		System.out.println("b) Cuántos de dichos números son impares?");
		numerosImpares(numeros);
		System.out.println("c) Cuántos de dichos números son impares y tienen al menos una vez al dígito 2?");
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
