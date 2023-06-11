package productos;

import modelos.Componente;

public class Procesador extends Componente implements Comparable<Componente>{

	//Atributos Placa Base
	
	//Constructor
	public Procesador(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Procesador"))
			throw new Exception ("El código introducido no pertenece a un Procesador");

	}

	@Override
	public int compareTo(Componente o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
