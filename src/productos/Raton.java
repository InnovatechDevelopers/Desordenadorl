package productos;

import modelos.Periferico;

public class Raton extends Periferico implements Comparable<Raton>{

	//Atributos Ratón
	
	//Constructor
	public Raton(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Ratón"))
			throw new Exception ("El código introducido no pertenece a un Ratón");

	}

	@Override
	public int compareTo(Raton o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
