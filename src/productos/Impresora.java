package productos;

import modelos.Periferico;

public class Impresora extends Periferico implements Comparable<Impresora>{

	//Atributos Impresora
	
	//Constructor
	public Impresora(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Impresora"))
			throw new Exception ("El código introducido no pertenece a una Impresora");

	}

	@Override
	public int compareTo(Impresora o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
