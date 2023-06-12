package vista;

import java.util.Scanner;

/**
 * Esta Clase va a ser la única encargada y con privilegios de mostrar por pantalla e interactuar con
 * el usuario para pedirle que introduzca alguna información por teclado.
 * @author
 *
 */
public class Terminal {

	private static Scanner teclado = new Scanner(System.in);

	/**
	 * Muestra por pantalla el String que se le pasa como parámetro (MENÚ de opciones) y devuelve
	 * en forma de número entero lo retornado por teclado.
	 * @param menu String. Cadena de caracteres del menú a mostrar.
	 * @return int. Entero perteneciente a la opción seleccioanda.
	 * @throws Exception Lanzará una excepción en caso de que la opción seleccionada no se corresponda
	 * con un entero (por ejemplo, si se introduce algún símbolo).
	 */
	public static int muestraMenu(String menu) throws Exception{
		System.out.println(menu);
		System.out.println("Elige la opción deseada: ");
		return Integer.parseInt(teclado.nextLine());
	}

	/**
	 * Muestra en color rojo el mensaje implícito de la Excepción que se le pasa como argumento.
	 * @param e Exception. Excepción que contiene el mensaje a mostrar.
	 */
	public static void muestraError (Exception e) {
		System.err.println(e.getMessage());
	}

	/**
	 * Muestra por pantalla el mensaje que se le envía como parámetro.
	 * @param mensaje String. Mensaje que se quiere mostrar por pantalla.
	 */
	public static void muestraMensaje (String mensaje) {
		System.out.println(mensaje);
		}

	/**
	 * Muestra por pantalla el mensaje que se le envía como parámetro y retorna el String de interacción
	 * con el usuario.
	 * @param mensaje String. Mensaje que se quiere mostrar por pantalla.
	 * @return String. Respuesta del usuario o interacción al mensaje que se le envía.
	 */
	public static String muestraMensajeRespuesta (String mensaje) {
		System.out.print(mensaje + ": ");
		return teclado.nextLine();
		}

	/**
	 * Esta función únicamente devuelve el texto que el usuario introduce por teclado antes de presionar
	 * la tecla ENTER.
	 * @return String. Información que el usuario introduce por teclado.
	 */
	public static String leerDato(){
		return teclado.nextLine();
	}
}
