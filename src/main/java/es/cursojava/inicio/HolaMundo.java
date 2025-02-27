package es.cursojava.inicio;

import java.util.Scanner;

public class HolaMundo {
  public static void main (String [] args) {
	 System.out.println("Hola Mundo MUU");
	 System.out.println("Que tal mi gente?");
	 final int numero = 4;
	 String nombre = "Viktor";
	 int edad = 24;
	 System.out.println(Math.PI);
	 Scanner scan = new Scanner(System.in);
	 System.out.println("Introduce tu año de nacimiento"); 
	 int anio = scan.nextInt();
	 System.out.println(anio);
	 
  }

// 1. Gestión de Archivos y Directorios

// Navegación

// pwd: Muestra el directorio actual.

// cd [directorio]: Cambia al directorio especificado.

// cd ..: Retrocede un nivel.

// cd ~: Accede al directorio home del usuario.

// cd /ruta/especifica: Navega a una ruta específica.


// Listado

// ls: Lista los archivos y directorios.

// ls -l: Muestra detalles como permisos, propietario, tamaño y fecha.

// ls -a: Incluye archivos ocultos.

// ls -ltr: Ordena por antigüedad (más antiguo a más reciente).

// ls *.ext: Filtra por extensión (ej. *.html).


// Creación y Manipulación

// mkdir [nombre]: Crea un directorio.

// touch [nombre]: Crea un archivo vacío.

// cp [origen] [destino]: Copia archivos o directorios.

// mv [origen] [destino]: Mueve o renombra archivos o carpetas.

// rm [archivo/directorio]: Elimina archivos o directorios.

// rm -r: Elimina un directorio con su contenido.

// rmdir [directorio]: Elimina directorios vacíos.


// 2. Visualización de Archivos

// cat [archivo]: Muestra el contenido de un archivo.

// cat > archivo: Crea un archivo y permite escribir contenido.

// cat archivo1 archivo2 > archivoDestino: Concatena archivos.

// more [archivo]: Muestra el contenido de un archivo página a página.

// head [archivo]: Muestra las primeras líneas de un archivo.

// tail [archivo]: Muestra las últimas líneas.

// tail -f archivo: Sigue actualizaciones en tiempo real.


// 3. Gestión de Usuarios y Permisos

// sudo [comando]: Ejecuta comandos con privilegios de administrador.

// chmod [permisos] [archivo]: Cambia los permisos de un archivo.

// Ejemplo: chmod 754 archivo.txt.

// chown [usuario] [archivo]: Cambia el propietario de un archivo.

// chgrp [grupo] [archivo]: Cambia el grupo propietario.

// adduser [usuario]: Añade un usuario.

// groupadd [grupo]: Crea un grupo.

// usermod -aG [grupo] [usuario]: Añade un usuario a un grupo.


// 4. Gestión del Sistema

// top: Muestra procesos en tiempo real.

// ps: Lista procesos en ejecución.

// ps aux: Detalla procesos activos.

// kill -9 [PID]: Termina un proceso usando su ID.

// df -h: Muestra el espacio libre en disco en formato legible.

// du -sh [directorio]: Muestra el tamaño de un directorio.

// free -h: Muestra el uso de memoria.

// uptime: Indica el tiempo de actividad del sistema.

// shutdown now: Apaga el sistema inmediatamente.

// reboot: Reinicia el sistema.


// 5. Red y Conexiones

// ping [host]: Verifica la conectividad con un host.

// ifconfig: Muestra la configuración de red.

// wget [URL]: Descarga archivos desde una URL.

// ssh [usuario]@[host]: Conecta a un servidor remoto.

// scp [origen] [usuario]@[host]:[destino]: Copia archivos de forma segura entre sistemas.


// 6. Compresión y Descompresión

// tar -czvf [archivo.tar.gz] [directorio]: Crea un archivo comprimido.

// tar -xzvf [archivo.tar.gz]: Extrae un archivo comprimido.

// gzip [archivo]: Comprime un archivo.

// gunzip [archivo.gz]: Descomprime un archivo.

// unzip [archivo.zip]: Extrae archivos ZIP.


// 7. Información del Sistema

// uname -a: Muestra información del sistema.

// hostname: Muestra o cambia el nombre del host.

// whoami: Indica el usuario actual.

// man [comando]: Muestra el manual de un comando.


// 8. Comandos Adicionales

// groups [usuario]: Muestra los grupos a los que pertenece un usuario.

// jps: Lista los procesos Java en ejecución.

// ps -ef | grep [proceso]: Busca procesos específicos.
}
