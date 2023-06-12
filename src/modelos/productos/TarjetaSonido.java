package modelos.productos;

import modelos.Componente;

public class TarjetaSonido extends Componente {

	//Atributos Tarjeta de Sonido

	//Constructor
	public TarjetaSonido(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Tarjeta Sonido"))
			throw new Exception ("El código introducido no pertenece a una Tarjeta de Sonido");

	}

}
