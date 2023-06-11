package productos;

import modelos.Ordenador;

public class Sobremesa extends Ordenador implements Comparable<Sobremesa>{

	//Atributos Sobremesa
	
	//Constructor
	public Sobremesa(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Sobremesa"))
			throw new Exception ("El código introducido no pertenece a un Sobremesa");

	}

	@Override
	public int compareTo(Sobremesa o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
