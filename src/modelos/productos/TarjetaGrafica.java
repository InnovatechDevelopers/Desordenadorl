package modelos.productos;

import modelos.Componente;

public class TarjetaGrafica extends Componente{

	//Atributos Tarjeta Gráfica
	
	//Constructor
	public TarjetaGrafica(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Tarjeta Gráfica"))
			throw new Exception ("El código introducido no pertenece a una Tarjeta Gráfica");

	}

}
