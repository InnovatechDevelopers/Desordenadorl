package utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
