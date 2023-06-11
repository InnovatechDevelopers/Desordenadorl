package utilidades;

import modelos.*;
import productos.AllInOne;
import productos.FuenteAlimentacion;
import productos.Impresora;
import productos.Monitor;
import productos.PlacaBase;
import productos.Portatil;
import productos.Procesador;
import productos.Raton;
import productos.Sobremesa;
import productos.TarjetaGrafica;
import productos.TarjetaSonido;
import productos.Teclado;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Stock {
	private Map<Producto, Integer> listaStock;
	private Date fechaActualizacion;
	
	public Stock() {
		this.listaStock = new TreeMap<Producto, Integer>();
		this.setFechaActualizacion(new Date());
	}
	
	/**
	 * Por sobrecarga de métodos, en caso de que no se especifique cuántas unidades habrá de aumentarse
	 * el stock del producto idProducto, éste se tomará como en UNA unidad.
	 * @param idProducto String. Producto sobre el que queremos actuar.
	 * @throws Exception. Puede lanzar una excepción en caso de que, bien el idProducto no exista en
	 * familia de Productos o bien si hubiera algún problema a la hora de generar el producto en el
	 * listado de stock. En cualquier caso, informa en su propia excepción del mensaje de error ocurrido.
	 */
	public void añadirStock (String idProducto) throws Exception{
		this.añadirStock(idProducto, 1);
	}
	
	/**
	 * Si el producto ya existe en el listado de stock, aumenta el stock del Producto con idProducto
	 * en tantas unidades como numProductos se especifique. Si el producto no existiera todavía en
	 * el listado de stock, lo incluye en éste con el número de unidades especificadas en numProductos. 
	 * @param idProducto String. idProducto sobre el que queremos actuar.
	 * @param numProductos int. Número de productos a aumentar en el sock
	 * @throws Exception. Puede lanzar una excepción en caso de que, bien el idProducto no exista en
	 * familia de Productos o bien si hubiera algún problema a la hora de generar el producto en el
	 * listado de stock. En cualquier caso, informa en su propia excepción del mensaje de error ocurrido.
	 */
	public void añadirStock (String idProducto, int numProductos) throws Exception{
		Entry<Producto, Integer> registro;
			registro = this.getRegistro(idProducto); 
			if (registro != null)
				registro.setValue(registro.getValue() + numProductos);
			else
				if (Persistencia.exist(idProducto))
					this.listaStock.put(generaProductoStock(idProducto), numProductos);
				else
					throw new Exception ("El producto " + idProducto + " no existe en familiaProductos");
		this.setFechaActualizacion(new Date()); //Actualiza al momento actual la última modificación de stock
	}
	

	/**
	 * Método que busca el idProducto en el mapa listaStock. Hay que tener en cuenta que el idProducto puede existir en
	 * el mapa familiaProducto de la BBDD (Persistencia), pero no haberse introducido nunca en el Stock (ni siquiera con Stock 0)
	 * @param idProducto String. idProducto que deseamos encontrar
	 * @return Entry<Producto, Integer>. Devuelve el registro <Producto, numStock> si éste se ha encontrado. Devuelve null
	 * en caso de no haberse encontrado.
	 */
	public Entry<Producto, Integer> getRegistro(String idProducto) throws Exception{
		boolean encontrado = false;
		Entry<Producto, Integer> registroRetorno = null, registroAuxiliar = null;
		Iterator<Entry<Producto, Integer>> it = listaStock.entrySet().iterator();
		while (it.hasNext() && !encontrado) {
			registroAuxiliar = it.next();
			if (registroAuxiliar.getKey().getIdProducto().equalsIgnoreCase(idProducto)) {
				registroRetorno = registroAuxiliar;
				encontrado = true;
			}
		}
		return registroRetorno;
	}
	
	/**
	 * Método privado para generar una instancia del producto deseado especificado mediante idProducto.
	 * Los datos del objeto serán los relacionados en familiaProductos correspondientes a la subfamilia
	 * que corresponda.
	 * @param idProducto String. Producto que se desea generar.
	 * @return Devuelve la instancia del Producto deseado.
	 * @throws Exception. Lanza una excepción en caso de no corresponderse el idProducto con ninguno
	 * de la familiaProductos o no haber alguna clase que coincida con el campo subfamilia. En
	 * cualquier caso, informa mediante mensaje del tipo de error.
	 */
	private Producto generaProductoStock (String idProducto) throws Exception{
		String[] datosProducto = Persistencia.getArrayDatos(idProducto);
		switch (datosProducto[1]) {
		case "AllInOne": return new AllInOne(idProducto);
		case "FuenteAlimentacion": return new FuenteAlimentacion(idProducto);
		case "Impresora": return new Impresora(idProducto);
		case "Monitor": return new Monitor(idProducto);
		case "PlacaBase": return new PlacaBase(idProducto);
		case "Portatil": return new Portatil(idProducto);
		case "Procesador": return new Procesador(idProducto);
		case "Raton": return new Raton(idProducto);
		case "Sobremesa": return new Sobremesa(idProducto);
		case "TarjetaGrafica": return new TarjetaGrafica(idProducto);
		case "TarjetaSonido": return new TarjetaSonido(idProducto);
		case "Teclado": return new Teclado(idProducto);
		default:
			throw new Exception ("No se ha podido generar el Producto con el idProducto " + idProducto);
		}
	}
	
	/**
	 * Método para listar el stock que hay en tienda.
	 * @return String. Cadena de caracteres formateada del listado del stock en tienda.
	 */
	public String listarStock() {
		String resultado = "";
		for (Entry<Producto, Integer> registro: listaStock.entrySet())
			resultado += registro.getValue() + "\t" + registro.getKey() + "\n";
		if (resultado == "")
			resultado = "No hay productos en Stock";
		return resultado;
	}
	
	/**
	 * Método que devuelve el número de unidades que hay en el Stock del producto
	 * con idProducto.
	 * @param idProducto String. Identificador del producto del cual queremos saber cuántas unidades
	 * hay en Stock
	 * @return int. Devuelve el número de unidades en stock.
	 * @throws Exception. Lanza una Excepción en caso de que no haya sido localizado el 
	 * idProducto dentro del listado de Stock.
	 */
	public int getStock (String idProducto) throws Exception{
		Entry<Producto, Integer> registro;
			registro = this.getRegistro(idProducto); 
			if (registro != null)
				return registro.getValue();
			else
				throw new Exception ("El producto " + idProducto + " no existe en el Stock");
	}


	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
}
