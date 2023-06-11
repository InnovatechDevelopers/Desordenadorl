package productos;

import modelos.Ordenador;

public class AllInOne extends Ordenador implements Comparable<AllInOne>{

	//Atributos All-In-One
	
	//Constructor
	public AllInOne(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("All-In-One"))
			throw new Exception ("El código introducido no pertenece a un All-In-One");

	}

	@Override
	public int compareTo(AllInOne o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
