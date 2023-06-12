package aplicacion;

import utilidades.Persistencia;
import vista.Terminal;

/**
 * Clase que arranca el programa cargando datos en memoria y ejecutando la Clase principal Aplicacion.
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public class Main {
	public static void main(String[] args) {
		try{
			Persistencia.rellenaDatos();
		}catch(Exception e) {
			Terminal.muestraError(e);
		}

		new Aplicacion();
	}
}
