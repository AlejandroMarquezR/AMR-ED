package main.java.com.ejemplo;

import java.util.Scanner;

public class Calculadora
{
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
            if (num2 == 0) {
                num2 = 0; // Esto provocará un error de ejecución
            }
            resultado = num1 / num2;
            System.out.println("El resultado de la división es: " + resultado);
        }
        else
        {
            System.out.println("Operación no válida.") //Aquí un ;
            // Error de sintaxis: Falta un punto y coma
        }

        // Error de concurrencia y asincronía: Uso incorrecto de un hilo sin sincronización
        Thread thread = new Thread(() -> {
            System.out.println("Hilo ejecutándose sin sincronización");
        });
        thread.start();

        scanner.close();
    }    
}
