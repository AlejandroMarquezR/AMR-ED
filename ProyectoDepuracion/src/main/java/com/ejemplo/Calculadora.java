package main.java.com.ejemplo;

import java.util.Scanner;

public class Calculadora
{
    private static int contador = 0; // Recurso compartido entre el hilo principal y el hilo creado

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
            // Error lógico: Resta incorrecta 
            resultado = num1 + num2; // Debería ser num1 - num2
            System.out.println("El resultado de la resta es: " + resultado);
        }
        else if (operacion == 3)
        {
            resultado = num1 * num2;
            System.out.println("El resultado de la multiplicación es: " + resultado);
        }
        else if (operacion == 4)
        {
            // Error de ejecución: División por cero
            if (num2 == 0)
            {
                num2 = 0; // Esto provocará un error de ejecución
            }
            resultado = num1 / num2; // se esta dividiendo por 0 , eso va a generar un error de ejecucion
            System.out.println("El resultado de la división es: " + resultado);
        }
        else
        {
            System.out.println("Operación no válida.") // Aquí un ;
            // Error de sintaxis: Falta un punto y coma
        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
            {
                // Error de concurrencia: Modificación de recurso compartido sin sincronización
                contador++; // Esto puede generar un resultado incorrecto debido a la falta de sincronización
            }
            System.out.println("Hilo ejecutándose sin sincronización, contador: " + contador);
        });
        thread.start();

        // Añadir un pequeño delay para permitir que el hilo termine antes de cerrar el scanner
        try
        {
            Thread.sleep(100); // Espera de 100ms
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        scanner.close();
    }    
}
