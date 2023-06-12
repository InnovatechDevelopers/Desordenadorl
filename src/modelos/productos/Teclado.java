package modelos.productos;

import modelos.Periferico;

public class Teclado extends Periferico{

	//Atributos Teclado
	
	//Constructor
	public Teclado(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Teclado"))
			throw new Exception ("El código introducido no pertenece a un Teclado");

	}

}
