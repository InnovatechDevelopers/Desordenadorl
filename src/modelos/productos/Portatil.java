package modelos.productos;

import modelos.Ordenador;

public class Portatil extends Ordenador {

	//Atributos Portátil

	//Constructor
	public Portatil(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Portátil"))
			throw new Exception ("El código introducido no pertenece a un Portátil");
	}

}
