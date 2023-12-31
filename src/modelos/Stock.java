package modelos;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import modelos.productos.AllInOne;
import modelos.productos.FuenteAlimentacion;
import modelos.productos.Impresora;
import modelos.productos.Monitor;
import modelos.productos.PlacaBase;
import modelos.productos.Portatil;
import modelos.productos.Procesador;
import modelos.productos.Raton;
import modelos.productos.Sobremesa;
import modelos.productos.TarjetaGrafica;
import modelos.productos.TarjetaSonido;
import modelos.productos.Teclado;
import utilidades.Persistencia;
import utilidades.Utilidades;

/**
 * Representa al Stock que tiene una Tienda de Informática, cuyos productos son asignados a través
 * de sus proveedores.
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public class Stock {
	private Map<Producto, Integer> listaStock;
	private Date fechaActualizacion;

	public Stock() {
		this.listaStock = new TreeMap<>();
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
			if (registro != null) //Si el registro existe, actualiza nStock
				registro.setValue(registro.getValue() + numProductos);
			else //Si no existe, mete el Producto en Stock y actualiza nStock
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
		switch (datosProducto[1].replace(" ","").toUpperCase()) {
		case "ALLINONE": return new AllInOne(idProducto);
		case "FUENTEALIMENTACION": return new FuenteAlimentacion(idProducto);
		case "IMPRESORA": return new Impresora(idProducto);
		case "MONITOR": return new Monitor(idProducto);
		case "PLACABASE": return new PlacaBase(idProducto);
		case "PORTATIL": return new Portatil(idProducto);
		case "PROCESADOR": return new Procesador(idProducto);
		case "RATON": return new Raton(idProducto);
		case "SOBREMESA": return new Sobremesa(idProducto);
		case "TARJETAGRAFICA": return new TarjetaGrafica(idProducto);
		case "TARJETASONIDO": return new TarjetaSonido(idProducto);
		case "TECLADO": return new Teclado(idProducto);
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
			resultado = "No hay productos en Stock\n";
		resultado += "Stock actualizado en fecha: " + Utilidades.formatoFecha("dd/MM/yy HH:mm:ss", this.fechaActualizacion);
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

	/**
	 * Proporciona un Item para añadir a la factura. Se saca del Stock (en caso de que esté en él)
	 * el Producto correspondiente a idProducto. Posteriormente se resta una uniadad al Stock.
	 * Es importante saber que en este proceso SE CLONA el Producto, de tal manera que sus
	 * atributos quedan desvinculados del Producto que todavía sigue en Stock.
	 * @param idProducto String. Representa al Producto para facturar.
	 * @param descuento double. Se especifica si se quiere algún tipo de descuento para ese Item
	 * @return Item. Devuelve el Item para añadir a la factura.
	 * @throws Exception Puede lanzar una excepción de no haber Stock suficiente de ese producto o
	 * también pudiera lanzar una CloneNotSupportedException por la llamada al método clone().
	 */
	public Item getItem(String idProducto, double descuento) throws Exception{
		Item item = null;
		Entry<Producto, Integer> registro = this.getRegistro(idProducto);
		if (registro.getValue() > 0) {
			item = new Item((Producto)registro.getKey().clone(), descuento);
			this.añadirStock(idProducto, -1); //Restamos una unidad de ese producto
		}
		else
			throw new Exception ("No hay suficientes unidades en el Stock de ese Producto");
		return item;
	}


	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
}
