package RandomAccess;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Alumno {

	private String nombre;
	private String apellido;
	private String email;
	private int edad;

	public static int TAMANO_S = 2*40;
	public static int TAMANO_REGISTRO = TAMANO_S *3+4;


	public Alumno(String nombre, String apellido, String email, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;		
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}



	public void write(RandomAccessFile raf) throws IOException{
		
		//Aquí estamos escribiendo en nuestro fichero, es decir, estamos empaquetando a bytes
		//nuestra variable de nuestro método es el que llamará al método seek
		//el método seek nos permite movernos a una posición determinada del fichero.
		//Le pasaremos la clase donde tenemos el indice, y el atributo de tamano registro de la clase Alumno.
		//Haremos un array de bytes en el cual le pasaremos para almacenar el tamano registro
		//Las packutils son punteros desde donde se puede mover.
		raf.seek(Test.indice*TAMANO_REGISTRO);
		byte[] datos = new byte[TAMANO_REGISTRO];
		
		PackUtils.packLimitedString(nombre, TAMANO_S, datos, 0* TAMANO_S);        

		PackUtils.packLimitedString(apellido, TAMANO_S, datos, 1* TAMANO_S);
		
		PackUtils.packLimitedString(email, TAMANO_S, datos, 2* TAMANO_S);
		

		PackUtils.packInt(edad, datos, 3* TAMANO_S);
		
		raf.write(datos);

	}

	public Alumno read(RandomAccessFile raf) throws IOException {
		

		//Aquí estamos leyendo en nuestro fichero, es decir, estamos empaquetando a bytes
		//nuestra variable de nuestro método es el que llamará al método seek
		//el método seek nos permite movernos a una posición determinada del fichero.
		//Le pasaremos la clase donde tenemos el indice, y el atributo de tamano registro de la clase Alumno.
		//Haremos un array de bytes en el cual le pasaremos para almacenar el tamano registro
		//Ahora pasaremos en el método de pack utils los string el tamano de registro, nuestro array la posición
		//Las pakutils son punteros,los cuales, se mueven dependiendo de las posiciones, los 
		//almacenamos en string y luego los pasaremos por el return
		
		raf.seek(Test.indice*TAMANO_REGISTRO);
		byte[] datos = new byte[TAMANO_REGISTRO];
		raf.read(datos);

		String nom = PackUtils.unpackLimitedString(TAMANO_S, datos, 0* TAMANO_S);       

		String ape = PackUtils.unpackLimitedString(TAMANO_S, datos, 1* TAMANO_S );

		String correo = PackUtils.unpackLimitedString(TAMANO_S, datos, 2* TAMANO_S);
		
		int edad = PackUtils.unpackInt(datos, 3* TAMANO_S);
		
		return new Alumno(nom, ape, correo, edad);


	}


	public String toString() {
		
		//Sobrecargamos el método toString
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", edad=" + edad + "]";
	}

	public int getTamano() {

		return 0;
	}

}


