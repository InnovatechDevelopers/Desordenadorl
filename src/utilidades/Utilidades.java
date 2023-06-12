package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta Clase se va a nutrir de métodos útiles que en algún momento del programa pueden ser necesitados
 * para facilitar algún proceso o gestión de datos complejos.
 * @author Alfonso
 *
 */
public class Utilidades {

	/**
	 * Formatea una fecha tipo Date en un formato establecido como parámetro.
	 * @param formato String. Formato tipo "dd/MM/yyyy" ó "dd/MM/yy HH:mm:ss" u otros. Ver documentación sobre SimpleDateFormat
	 * @param fecha Date. Fecha la cual queremos formatear.
	 * @return Devuelve un String con la fecha formateada en el formato deseado.
	 */
	public static String formatoFecha(String formato, Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(fecha);
	}

	/**
	 * Comprueba si una fecha pasada como parámetro en un formato concreto puede ser adecuada para
	 * ser considerada como tal conforme el formato que se le indica también como parámetro..
	 * @param formato String. Formato tipo "dd/MM/yyyy" ó "dd/MM/yy HH:mm:ss" u otros. Ver documentación sobre SimpleDateFormat
	 * @param fecha String. Fecha la cual queremos comprobar.
	 * @return Devuelve un objeto tipo Date con la fecha en caso de haberse podido portar a esta Clase.
	 */
	public static Date formatoDate(String formato, String fecha) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.parse(fecha);
	}
}
