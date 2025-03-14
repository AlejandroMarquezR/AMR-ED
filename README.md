# MI README

## Lo que he utilizado es lo siguiente
- Maven
- VSCode
- Java
- Un archivo pom

## Problemas que he tenido
- Crear la varialbe de Maven en el PATH
- Crear la estructura porque yo la estaba haciendo a mano en lugar de con comandos

**Instalar Maven en su página oficial, y crear la variable del sistema y la variable PATH con sus respectivas rutas**

_Para probar si está bien instroduce el comando 'mvn --version' (sin comillas), si te sale una versión es que está bien instalado_

**Ahora vamos a abrir la Git Bash y accedemos al directorio donde queremos crear el proyecto, en mi caso lo he creado en la carpeta de mi usuario llamado Romero, luego vamos a introducir el siguiente comando para crear la estructura con el arquetipo básico de Maven: 'mvn archetype:generate -DgroupId=com.ejemplo -DartifactId=mi-proyecto -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false' (sin comillas), especificamos el nombre de nuestro proyecto...**

__Luego vamos a ver si el programa funciona App.java funciona y si funciona lo subimos a nuestro repositorio en Git Hub__

__Finalmente cambiamos el programa hola mundo por el código que el profesor nos ha puesto en la tarea para crear una ventana con un mensaje 'Hola mundo' y un botón. Y vamos a subir esto a nuestro Git Hub modificando así el hola mundo en consola de antes__