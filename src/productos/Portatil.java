package productos;

import modelos.Ordenador;

public class Portatil extends Ordenador implements Comparable<Portatil>{

	//Atributos Portátil
	
	//Constructor
	public Portatil(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Portátil"))
			throw new Exception ("El código introducido no pertenece a un Portátil");
	}

	@Override
	public int compareTo(Portatil o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
