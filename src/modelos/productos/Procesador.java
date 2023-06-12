package modelos.productos;

import modelos.Componente;

public class Procesador extends Componente{

	//Atributos Placa Base
	
	//Constructor
	public Procesador(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Procesador"))
			throw new Exception ("El código introducido no pertenece a un Procesador");

	}

}
