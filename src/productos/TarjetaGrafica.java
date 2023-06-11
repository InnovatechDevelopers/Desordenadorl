package productos;

import modelos.Componente;

public class TarjetaGrafica extends Componente implements Comparable<TarjetaGrafica>{

	//Atributos Tarjeta Gráfica
	
	//Constructor
	public TarjetaGrafica(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Tarjeta Gráfica"))
			throw new Exception ("El código introducido no pertenece a una Tarjeta Gráfica");

	}

	@Override
	public int compareTo(TarjetaGrafica o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
