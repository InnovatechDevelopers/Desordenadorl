package modelos.productos;

import modelos.Componente;

public class FuenteAlimentacion extends Componente {

	//Atributos Fuente Alimentación

	//Constructor
	public FuenteAlimentacion(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Fuente Alimentación"))
			throw new Exception ("El código introducido no pertenece a una Fuente de Alimentación");

	}

}
