package utilidades;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * La Clase Persistencia va a simular el acceso a la base de datos donde determinados datos van a
 * tener que estar almacenados para proporcionárselos a la Entidad que los requiera.
 * @author XXXXXXXXX
 *
 */
public class Persistencia {
	static private Map<String, String[]> familiaProductos; //Atributo static sin inicializar (se inicializa al cargarlo)
	
	//Caracteres relacionados con la familia del producto:
	static public char charOrdenador = 'C', charPeriferico = 'P', charComponente = 'I';
	static public int numOrdenador = 0, numPeriferico = 0, numComponente = 0;
	
	/**
	 * Genera automáticamente los códigos de producto IdProducto correlativos conforme a la familia
	 * de producto del que se trate.
	 * @param familia String. Podrá contener alguna de las familias de productos declaradas "Ordenador", "Periferico", "Componente"
	 * @return String. Devuelve un String compuesto por el carácter correspondiente a la familia asociada junto a dos dígitos
	 * correlativos correspondientes al siguiente numeral no generado.
	 * @throws Exception Si no reconoce el tipo de familia pasada como parámetro, devolverá una excepción explicando el suceso
	 */
	static private String generaNuevoCodigo(String familia) throws Exception{
		switch (familia) {
			case "Ordenador": return charOrdenador + String.format("%02d", ++numOrdenador);
			case "Periferico": return charPeriferico+ String.format("%02d", ++numPeriferico);
			case "Componente": return charComponente+ String.format("%02d", ++numComponente);
			default:
				throw new Exception ("Error al generar el código de familia: Familia no reconocida ("+ familia +")");
		}
	}
	
	/**
	 * Rellena datos en el atributo estático (simulando los datos persistentes en una BBDD)
	 * @throws Exception Puede distribuir la excepción de que, al generar el idProducto nuevo, no se
	 * corresponda con las clases definidas en el programa.
	 */
	static private void rellenaDatos() throws Exception{
		familiaProductos = new TreeMap<String, String[]>();
		familiaProductos.put(generaNuevoCodigo("Ordenador"), new String[] {"Ordenador", "Sobremesa", ""});
		familiaProductos.put(generaNuevoCodigo("Ordenador"), new String[] {"Ordenador","All-in-One",""});
		familiaProductos.put(generaNuevoCodigo("Ordenador"), new String[] {"Ordenador","Portatil",""});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Raton","Alambrico"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Raton","Inalambrico"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Raton","Gamming"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Alambrico"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Alambrico + DNIe"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Inalambrico"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Gamming"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Monitor","24\""});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Monitor","27\""});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Monitor","Otras \""});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Impresora","Tinta"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Impresora","Laser"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Impresora","Otras"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Placa Base","Intel"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Placa Base","AMD"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Procesador","Intel"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Procesador","AMD"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Grafica","nVidia"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Grafica","Gamming"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Grafica","Otras"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Fuente Alimentacion","<650W"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Fuente Alimentacion",">=650W"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Sonido","Otras"});
		}
	
	/**
	 * Pasándole como parámetro un idProducto, devolverá un array con los datos "familia", "subfamilia" y "tipo"
	 * @param idProducto String. Identificador del Producto que se desea consultar
	 * @return int[3]. Donde la posición 0, 1 y 2 son "familia", "subfamilia" y "tipo" respectivamente.
	 * @throws Exception Lanzará una excepción en caso de que el idProducto no haya sido encontrado.
	 */
	public static String[] getArrayDatos(String idProducto) throws Exception{
		if (familiaProductos == null)
			rellenaDatos();
		String[] retorno = familiaProductos.get(idProducto);
		if (retorno == null)
			throw new Exception ("El producto no ha sido encontrado");
		return retorno;
	}
	
	
	/**
	 * Genera un nuevo producto cuya familia, subfamilia y tipo se pasan como parámetros. Previamente, el propio método
	 * comprueba si dicho producto ya existe. En caso de que exista, genera una Excepción informando del suceso.
	 * @param familia String Familia del producto
	 * @param subfamilia String. Subfamilia del producto
	 * @param tipo String. Tipo del producto
	 * @return String. Devuelve el nuevoIdProducto asignado al Producto que se ha generado en familiaProductos
	 * @throws Exception. Puede lanzar una excepción en caso de que no se haya podido generar el nuevo producto informando
	 * del suceso.
	 */
	public static String generaNuevoProducto(String familia, String subfamilia, String tipo) throws Exception{
		if (familiaProductos == null)
			rellenaDatos();
		if (!exist(familia, subfamilia, tipo)) {
			String nuevoIdProducto = generaNuevoCodigo(familia);
			familiaProductos.put(nuevoIdProducto, new String[] {familia,subfamilia,tipo});
			return nuevoIdProducto;
		}
		else
			throw new Exception ("El producto {" + familia + ", " + subfamilia + ", " + tipo + "} ya existe");
	}
	
	/**
	 * Elimina el producto de familiaProductos correspondiente con idProducto pasado como parámetro.
	 * @param idProducto String. Identificador del producto que se desea eliminar.
	 * @throws Exception. Lanza una excepción en caso de que el producto no haya sido encontrado.
	 */
	public static void eliminaProducto(String idProducto) throws Exception{
		if (familiaProductos == null) 
			rellenaDatos();
		if (exist(idProducto))
			familiaProductos.remove(idProducto);
		else
			throw new Exception ("El producto " + idProducto + " no ha sido encontrado para eliminarse");
	}
	
	/**
	 * Método privado que comprueba si el producto compuesto por familia, subfamilia y tipo ya existe dentro de familiaProductos.
	 * @param familia String. Familia del Producto
	 * @param subfamilia. Subfamilia del Producto
	 * @param tipo. Tipo del Producto.
	 * @return Devuelve true si encuentra coincidencias de este producto en familiaProductos. Devuelve false en caso de que el
	 * producto cuya familia, subfamilia y tipo no exista dentro de familiaProductos.
	 * @throws Exception Puede distribuir la excepción de que, al generar el idProducto nuevo, no se
	 * corresponda con las clases definidas en el programa.
	 */
	public static boolean exist (String familia, String subfamilia, String tipo) throws Exception{
		if (familiaProductos == null)
			rellenaDatos(); //Puede lanzar excepción
		
		boolean existe = false;
		Iterator <String[]> it = familiaProductos.values().iterator();
		while (it.hasNext() && !existe)
			if (it.next()[0].equalsIgnoreCase(familia) &&
					it.next()[1].equalsIgnoreCase(subfamilia) &&
					it.next()[2].equalsIgnoreCase(tipo))
				existe = true;
		return existe;
	}
	
	/**
	 * Método público que comprueba si el producto con idProducto especificado existe dentro de familiaProductos.
	 * @param idProducto String. idProducto que se desea buscar
	 * @return Devuelve true si es encontrado dentro de familiaProductos. Devuelve false en caso contrario.
	 * @throws Exception Puede distribuir la excepción de que, al generar el idProducto nuevo, no se
	 * corresponda con las clases definidas en el programa.
	 */
	public static boolean exist(String idProducto) throws Exception{
		if (familiaProductos == null)
			rellenaDatos(); //Puede lanzar excepción
		
		boolean existe = false;
		Iterator <String> it = familiaProductos.keySet().iterator();
		while (it.hasNext() && !existe)
			if (it.next().equalsIgnoreCase(idProducto))
				existe = true;
		return existe;
	}
	
	/**
	 * Devuelve un String con el listado formateado de familiaProductos
	 * @return String. Listado de familiaProductos ordenados por idProducto.
	 * @throws Exception
	 * @throws Exception Puede distribuir la excepción de que, al generar el idProducto nuevo, no se
	 * corresponda con las clases definidas en el programa.
	 */
	public static String listarFamiliaProductos() throws Exception{
		if (familiaProductos == null)
			rellenaDatos(); //Puede lanzar excepción
		
		String resultado = "";
		for (Entry<String, String[]> registro: familiaProductos.entrySet())
			resultado += registro.getKey() + "\t" + 
					registro.getValue()[0] + " | " +
					registro.getValue()[1] + " | " +
					registro.getValue()[2] + "\n";
		return resultado;
	}
	
}
