package modelos.productos;

import modelos.Periferico;

public class Raton extends Periferico{

	//Atributos Ratón
	
	//Constructor
	public Raton(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Ratón"))
			throw new Exception ("El código introducido no pertenece a un Ratón");

	}

}
