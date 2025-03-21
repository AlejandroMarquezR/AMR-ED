# README

**ALEJANDRO MARQUEZ ROMERO - ACT9.1**

## Instrucciones de instalación y ejecución del proyecto.

En gitbash, en el directorio donde estoy creando el proyecto puse el siguiente comando --> mvn archetype:generate -DgroupId=com.ejemplo -DartifactId=ProyectoDepuracion -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Luego creé una carpeta llamada .vscode y dentro un archivo llamado launch.json

Este archivo launch.json contiene el siguiente codigo:
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Debug (Launch) - ProyectoDepuracion",
            "request": "launch",
            "mainClass": "com.ejemplo.App",
            "projectName": "ProyectoDepuracion"
        }
    ]
}
```

**La estructura de carpetas seria la siguiente:**

ProyectoDepuracion/
 ├── pom.xml
 └── src/
     └── main/
         └── java/
             └── com/
                 └── ejemplo/
                     └── App.java
     └── test/
         └── java/
             └── com/
                 └── ejemplo/
                     └── AppTest.java
 └── .vscode/
     └── launch.json



**Errores encontrados y soluciones aplicadas.**

He hecho los siguientes errores en el archivo Calculadora.java  :

Un error de sintaxis, en la linea 51 del archivo Calculadora.java :

```java
System.out.println("Operación no válida.") // Aquí un ;
```

Un error de ejecucion, en la linea 46 del archivo Calculadora.java :

```java
resultado = num1 / num2; // se esta dividiendo por 0 , eso va a generar un error de ejecucion
```

Un error de concurrencia y asignacion, en la linea 59 del archivo Calculadora.java :

```java
contador++; // Esto puede generar un resultado incorrecto debido a la falta de sincronización
```

Un error logico, en la linea 31 del archivo Calculadora.java :

```java
resultado = num1 + num2; // Debería ser num1 - num2
```

**Dichos errores los he solucionado. El codigo Calculadora.java resuelto es el siguiente:**


```java
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
```


## Información sobre dependencias utilizadas (Maven, bibliotecas externas).

**Las dependencias utilizadas son las siguientes:**

```xml
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
```

**Las bibliotecas externas de java que he utilizado son la siguientes:**

- javax.swing.JFrame;
- javax.swing.JLabel;
- java.util.Scanner;

**El resto del material utilizado ha sido el siguiente:**

He utilizado Maven, java, vscode y su debuger, el archivo launch.json, el archivo pom.xml, OBS Studio para realizar el video que he convertido a Gif usando un convertidor de internet.

## Un GIF por cada error de ejecución de cómo se depura.

![Gif: error logico](.\esteEs_errorLogico.gif)

![Gif: error de sintaxis](.\esteEs_errorSintaxis.gif)

![Gif: error de ejecucion](.\esteEs_errorEjecucion_1.gif)

![Gif: error logico](.\esteEs_errorConcurrenciaAsincronia_2.gif)

