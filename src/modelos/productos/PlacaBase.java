package modelos.productos;

import modelos.Componente;

public class PlacaBase extends Componente {

	//Atributos Placa Base
	
	//Constructor
	public PlacaBase(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Placa Base"))
			throw new Exception ("El código introducido no pertenece a una Placa Base");

	}

}
