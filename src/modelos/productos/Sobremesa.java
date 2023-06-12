package modelos.productos;

import modelos.Ordenador;

public class Sobremesa extends Ordenador {

	//Atributos Sobremesa
	
	//Constructor
	public Sobremesa(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Sobremesa"))
			throw new Exception ("El código introducido no pertenece a un Sobremesa");

	}

}
