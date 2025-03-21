package main.java.com.ejemplo;

import java.util.Scanner;

public class Calculadora
{
    private static int contador = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el primer número:");
        double num1 = scanner.nextDouble();

        System.out.println("Introduce el segundo número:");
        double num2 = scanner.nextDouble();

        System.out.println("Elige una operación:\n(1)suma\n(2)resta\n(3)multiplicacion\n(4)division");
        int operacion = scanner.nextInt();

        double resultado;
        if (operacion == 1)
        {
            resultado = num1 + num2;
            System.out.println("El resultado de la suma es: " + resultado);
        }
        else if (operacion == 2)
        {
            resultado = num1 - num2;
            System.out.println("El resultado de la resta es: " + resultado);
        }
        else if (operacion == 3)
        {
            resultado = num1 * num2;
            System.out.println("El resultado de la multiplicación es: " + resultado);
        }
        else if (operacion == 4)
        {
            if (num2 == 0)
            {
                System.out.println("Error: División por cero.");
                return;
            }
            resultado = num1 / num2;
            System.out.println("El resultado de la división es: " + resultado);
        }
        else
        {
            System.out.println("Operación no válida.");
            return;
        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
            {
                synchronized (Calculadora.class)
                {
                    contador++;
                }
            }
            System.out.println("Hilo ejecutándose, contador: " + contador);
        });
        thread.start();

        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        scanner.close();
    }
}
