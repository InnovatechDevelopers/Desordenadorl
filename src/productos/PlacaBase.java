package productos;

import modelos.Componente;

public class PlacaBase extends Componente implements Comparable<PlacaBase>{

	//Atributos Placa Base
	
	//Constructor
	public PlacaBase(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Placa Base"))
			throw new Exception ("El código introducido no pertenece a una Placa Base");

	}

	@Override
	public int compareTo(PlacaBase o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
