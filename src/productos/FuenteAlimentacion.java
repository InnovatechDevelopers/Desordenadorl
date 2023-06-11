package productos;

import modelos.Componente;

public class FuenteAlimentacion extends Componente implements Comparable<FuenteAlimentacion>{

	//Atributos Fuente Alimentación
	
	//Constructor
	public FuenteAlimentacion(String idProducto) throws Exception{
		super(idProducto);
		if (super.getFamilia().equalsIgnoreCase("Fuente Alimentación"))
			throw new Exception ("El código introducido no pertenece a una Fuente de Alimentación");

	}

	@Override
	public int compareTo(FuenteAlimentacion o) {
		// TODO Esbozo de método generado automáticamente
		return 0;
	}

}
