package aplicacion;

import utilidades.Persistencia;
import vista.Terminal;

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
