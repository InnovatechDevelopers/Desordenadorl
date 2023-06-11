package productos;

import modelos.Periferico;

public class Monitor extends Periferico implements Comparable<Monitor>{

	//Atributos Monitor
	
	//Constructor
	public Monitor(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Monitor"))
			throw new Exception ("El código introducido no pertenece a un Monitor");

	}

	@Override
	public int compareTo(Monitor o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
