package modelos.productos;

import modelos.Periferico;

public class Monitor extends Periferico {

	//Atributos Monitor

	//Constructor
	public Monitor(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Monitor"))
			throw new Exception ("El código introducido no pertenece a un Monitor");

	}

}
