package modelos.productos;

import modelos.Periferico;

public class Impresora extends Periferico{

	//Atributos Impresora

	//Constructor
	public Impresora(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Impresora"))
			throw new Exception ("El código introducido no pertenece a una Impresora");

	}

}
