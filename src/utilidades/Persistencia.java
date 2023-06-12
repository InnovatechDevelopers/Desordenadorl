package utilidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import modelos.Venta;
import modelos.clientes.Cliente;
import modelos.clientes.Empresa;
import modelos.clientes.Particular;


/**
 * La Clase Persistencia va a simular el acceso a la base de datos donde determinados datos van a
 * tener que estar almacenados para proporcionárselos a la Entidad que los requiera.
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public class Persistencia {
	//Atributo static y private sin inicializar (se inicializa al cargarlo)
	//Simula BBDD, a la cual solo se podrán acceder a través de los métodos correspondientes
	static private Map<String, String[]> familiaProductos;

	//Lista de Clientes (particulares o empresas)
	static private ArrayList<Cliente> clientes;

	//Lista de Facturas (Ventas)
	static private ArrayList<Venta> ventas;

	//Caracteres relacionados con la familia del producto:
	static public char charOrdenador = 'C', charPeriferico = 'P', charComponente = 'I';
	static public int numOrdenador = 0, numPeriferico = 0, numComponente = 0;

	/**
	 * Rellena datos en el atributo estático (simulando los datos persistentes en una BBDD)
	 * @throws Exception Puede distribuir la excepción de que, al generar el idProducto nuevo, no se
	 * corresponda con las clases definidas en el programa.
	 */
	static public void rellenaDatos() throws Exception{
		familiaProductos = new TreeMap<>();
		familiaProductos.put(generaNuevoCodigo("Ordenador"), new String[] {"Ordenador", "Sobremesa", "", "5.0"});
		familiaProductos.put(generaNuevoCodigo("Ordenador"), new String[] {"Ordenador","AllInOne","", "15.0"});
		familiaProductos.put(generaNuevoCodigo("Ordenador"), new String[] {"Ordenador","Portatil","", "25.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Raton","Alambrico", "35.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Raton","Inalambrico", "45.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Raton","Gamming", "55.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Alambrico", "65.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Alambrico + DNIe", "75.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Inalambrico", "85.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Teclado","Gamming", "95.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Monitor","24\"", "25.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Monitor","27\"", "15.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Monitor","Otras \"", "35.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Impresora","Tinta", "55.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Impresora","Laser", "55.0"});
		familiaProductos.put(generaNuevoCodigo("Periferico"), new String[] {"Periferico","Impresora","Otras", "75.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Placa Base","Intel", "85.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Placa Base","AMD", "95.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Procesador","Intel", "45.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Procesador","AMD", "25.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Grafica","nVidia", "15.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Grafica","Gamming", "35.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Grafica","Otras", "55.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Fuente Alimentacion","<650W", "65.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Fuente Alimentacion",">=650W", "45.0"});
		familiaProductos.put(generaNuevoCodigo("Componente"), new String[] {"Componente","Tarjeta Sonido","Otras", "25.0"});

		clientes = new ArrayList<>();
		clientes.add(new Particular ("Alfonso de la Rubia", "DniAlfonso", "DireccionAlfonso", "TelAlfonso", "emailAlfonso"));
		clientes.add(new Particular ("Esther Calzón", "DniEsther", "DireccionEsther", "TelEsther", "emailEsther"));
		clientes.add(new Particular ("Vicente Alfonso Jimenez", "DniAlfonso", "DireccionAlfonso", "TelAlfonso", "emailAlfonso"));
		clientes.add(new Particular ("Francisco José García", "DniFran", "DireccionFran", "TelFran", "emailFran"));

		clientes.add(new Empresa("InnovaTech", "CIFInnovaTech", "DireccionInnovaTech", "TelInnovaTech", "emailInnovaTech", Persistencia.getCliente(1)));
		clientes.add(new Empresa("Desordenador", "CIFDesordenador", "DireccionDesordenador", "TelDesordenador", "emailDesordenador", Persistencia.getCliente(3)));

		ventas = new ArrayList<>();
		}


	//*******CLIENTES*******//
	/**
	 * A través del código de Cliente, el método devuelve el Cliente que corresponde con ese código
	 * @param codCliente Integer. Código del Cliente que se desea recuperar.
	 * @return Cliente. Devuelve el objeto Cliente correspondiente a ese Código de Cliente pasado
	 * como parámetro.
	 * @throws Exception. Lanza una Excepción en caso de que el Código de Cliente no se halle.
	 */
	public static Cliente getCliente(Integer codCliente) throws Exception{
		for (Cliente cliente: clientes)
			if(cliente.getCodCliente().equals(codCliente))
				return cliente;
		throw new Exception ("Cliente no encontrado");
	}

	/**
	 * Devuelve un listado de Clientes formateado obrantes en Persistencia.
	 * @return String. Cadena formateada conteniendo un listado de clientes.
	 * @throws Exception. Lanza una excepción en caso de no haber ningún cliente en Persistencia.
	 */
	public static String listarClientes () throws Exception{
		String retorno = "";
		for (Cliente cliente: clientes)
			retorno += cliente + "\n";
		if (retorno.equals(""))
			throw new Exception ("La lista de Clientes está vacía");
		return retorno;
	}


	//******VENTAS******//
	/**
	 * Añade una Venta a Persistencia.
	 * @param venta Objeto Venta que se ha de añadir a Persistencia.
	 */
	public static void añadirVenta(Venta venta) {
		ventas.add(venta);
	}

	/**
	 * Devuelve un listado de Ventas realizadas obrantes en Persistencia.
	 * @return String. Cadena formateada conteniendo un listado de ventas.
	 * @throws Exception. Lanza una excepción en caso de no haber ninguna venta en Persistencia.
	 */
	public static String listarVentas() throws Exception{
		String retorno = "";
		for (Venta venta: ventas)
			retorno += venta + "\n\n";
		if (retorno.equals(""))
			throw new Exception ("No hay ninguna venta realizada");
		return retorno;
	}

	/**
	 * Devuelve un listado de Ventas realizadas en una fecha concretaobrantes en Persistencia.
	 * @param fecha String. La fecha ha de tener el formato "dd/MM/yyyy"
	 * @return String. Cadena formateada conteniendo un listado de ventas de la fecha seleccionada.
	 * @throws Exception. Lanza una excepción en caso de no haber ninguna venta en esa fecha
	 * en Persistencia.
	 */
	public static String listarVentas(String fecha) throws Exception{
		String retorno = "";
		for (Venta venta: ventas)
			//Solo añade al listado aquellas fechas que coincidan con la fecha seleccionada
			if (Utilidades.formatoFecha("dd/MM/yyyy", venta.getFecha()).equals(fecha))
				retorno += venta + "\n\n";
		if (retorno.equals(""))
			throw new Exception ("No hay ninguna venta realizada");
		return retorno;
	}

	//*******FAMILIAPRODUCTOS*******//
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
	 * Pasándole como parámetro un idProducto, devolverá un array con los datos "familia", "subfamilia" y "tipo"
	 * @param idProducto String. Identificador del Producto que se desea consultar
	 * @return int[3]. Donde la posición 0, 1 y 2 son "familia", "subfamilia" y "tipo" respectivamente.
	 * @throws Exception Lanzará una excepción en caso de que el idProducto no haya sido encontrado.
	 */
	public static String[] getArrayDatos(String idProducto) throws Exception{
		String[] retorno = familiaProductos.get(idProducto.toUpperCase());
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
	public static String generaNuevoProducto(String familia, String subfamilia, String tipo, String precio) throws Exception{
		if (!exist(familia, subfamilia, tipo)) {
			String nuevoIdProducto = generaNuevoCodigo(familia);
			familiaProductos.put(nuevoIdProducto, new String[] {familia,subfamilia,tipo, precio});
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
		if (exist(idProducto.toUpperCase()))
			familiaProductos.remove(idProducto.toUpperCase());
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
		String resultado = "";
		for (Entry<String, String[]> registro: familiaProductos.entrySet())
			resultado += registro.getKey() + "\t" +
					registro.getValue()[0] + " | " +
					registro.getValue()[1] + " | " +
					registro.getValue()[2] + " | " +
					registro.getValue()[3] + " €\n";
		return resultado;
	}

}
