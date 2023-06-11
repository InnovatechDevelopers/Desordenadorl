package productos;

import modelos.Periferico;

public class Teclado extends Periferico implements Comparable<Teclado>{

	//Atributos Teclado
	
	//Constructor
	public Teclado(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Teclado"))
			throw new Exception ("El código introducido no pertenece a un Teclado");

	}

	@Override
	public int compareTo(Teclado o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
