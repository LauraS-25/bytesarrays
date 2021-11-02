package RandomAccess;

import java.io.*;

public class Test {
	
	public static long indice=0;

	public static void main(String[] args) throws IOException{
		
		//Llamamos a la clase Randomaccess y creamos una variable, y le pasamos
		//el nombre de fichero que y rw que es leer y escribir
		
		RandomAccessFile fichero = new RandomAccessFile("acceso.dat", "rw");
		
		
		
		//Creamos 4 objetos de tipo Alumno
		
		Alumno a1 = new Alumno("María", "Fuentes", "maria@gmail.com", 22);
		
		Alumno a2 = new Alumno("Carlos","Rodriguez","carlos@gmail.com",24);
		
		Alumno a3 = new Alumno("Rosa","Gonzales", "rosa@gmail.com", 32);
		
		Alumno a4 = new Alumno("Fredo", "Castellón", "fredo@gmail.com", 27);
		
		//El indice indica de las posiciones que coge tanto con o sin espacios, si empiezas
		//en el 0 no cuenta espacios, si empiezas en el 1 cuenta espacios.
		
		indice=0;
		
		//aquí estamos haciendo que el objeto primero de Alumno se escriba en el fichero y a la vez
		//creas un objeto porque lo vamos a querer escribir dentro del fichero no sólo pasarlo en pantalla
		//ese objeto nuevo creado lee el fichero y a la par de escribir y leer en el fichero lo saca por pantalla.
		//Así con los otros objetos
		
		a1.write(fichero);
		Alumno a = a1.read(fichero);
		System.out.println(a);
		
		indice=1;
		a2.write(fichero);
		Alumno al= a2.read(fichero);
		System.out.println(al);	
		
		indice=2;
		a3.write(fichero);
		Alumno alu =a3.read(fichero);
		System.out.println(alu);
		
		indice=3;
		a4.write(fichero);
		Alumno alum =a4.read(fichero);
		System.out.println(alum);
		
		

	}

}
