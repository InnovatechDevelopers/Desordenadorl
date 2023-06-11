package aplicacion;

import utilidades.Persistencia;
import vista.Terminal;
import utilidades.Stock;

public class Aplicacion {
	
	private int opcionSalir = 7;
	
	private Stock stock;

	private String menuPrincipal = "SELECCIONA UNA DE LAS SIGUIENTES OPCIONES\n"
			+ "1. Alta de un nuevo producto.\n"
			+ "2. Baja de un producto existente.\n"
			+ "3. Realizar una venta.\n"
			+ "4. Listados.\n"
			+ "5. Añadir Productos Nuevos al Stock\n"
			+ "6. Actualizar Stock.\n"
			+ "7. Salir.\n";
	
	private String menuListado = "SELECCIONA UNA DE LAS SIGUIENTES OPCIONES\n"
			+ "1. Listar familiaProductos.\n"
			+ "2. Listar Stock Actual.\n"
			+ "3. Salir.\n";

	public Aplicacion() {
		this.stock = new Stock();
		int opcionPrincipal = 0, opcionListado = 0;
		while (opcionPrincipal != opcionSalir)
			try {
				opcionPrincipal = Terminal.muestraMenu(menuPrincipal);
				switch(opcionPrincipal) {
				case 1: //Alta de un nuevo producto.
					Terminal.muestraMensaje(opcion1());
					break;
				case 2: //Baja de un producto existente.
					Terminal.muestraMensaje(opcion2());
					break;
				case 3: //Realiar una Venta.
					//opcion3();
					break;
				case 4: //Listados.
					opcionListado = Terminal.muestraMenu(menuListado);
					switch(opcionListado) {
					case 1: //Listado de familiaProductos
						Terminal.muestraMensaje(Persistencia.listarFamiliaProductos());
						break;
					case 2: //Listado de Stock
						Terminal.muestraMensaje(stock.listarStock());
						break;
					case 3:
						Terminal.muestraMensaje("Saliendo del menú de listados");
						break;
					default:
						throw new Exception ("Opción incorrecta");
					}
					break;
				case 5: //Añadir producto al Stock
					Terminal.muestraMensaje(opcion5());
					break;
				case 6: //Actualizar Stock.
					Terminal.muestraMensaje(opcion6());
					break;
				case 7: //Salir
					Terminal.muestraMensaje("Gracias por utilizar este programa");
					break;
				default: throw new Exception ("Opción Incorrecta");
				}
			}catch(Exception e) {
				Terminal.muestraError(e);
			}
	}
	
	/**
	 * Método privado para el: "Alta de un nuevo producto".
	 * Se pretende dar de alta un nuevo producto en la BBDD de familiaProductos de Persistencia (no de
	 * Stock). Ante ello, se deberá comprobar previamente si la familia, subfamilia y tipo se encuentran
	 * dados de alta.
	 * @return String. Devuelve el mensaje que configuramos para informar al usuario del resultado de
	 * la operación.
	 * @throws Exception. Puede distribuir la excepción lanzada a la hora de generar el nuevo producto.
	 */
	private String opcion1() throws Exception{
		String resultadoOperacion = "Resultado de la operación 1";
		String familia, subfamilia, tipo;
		Terminal.muestraMensaje("Vamos a buscar si el producto está en familiaProductos");
		familia = Terminal.muestraMensajeRespuesta("Introduce la familia");
		subfamilia = Terminal.muestraMensajeRespuesta("Introduce la subfamilia");
		tipo = Terminal.muestraMensajeRespuesta("Introduce el tipo");
		
		String idProducto = Persistencia.generaNuevoProducto(familia, subfamilia, tipo);
		resultadoOperacion = "Producto correctamente generado con el IdProducto " + idProducto;
		return resultadoOperacion;
	}
	
	/**
	 * Método privado para la: "Baja de un producto de familiaProductos".
	 * Se pretende dar de baja un producto de la BBDD de familiaProductos (Persistencia).
	 * Ante ello, el mismo método ya comprueba si el producto con idProducto ya existe o no;
	 * si no existe lanza una Excepción avisando de tal circunstancia.
	 * @return String. Devuelve el mensaje que configuramos para informar al usuario del resultado de
	 * la operación.
	 * @throws Exception. Puede distribuir la excepción generada a la hora de no poder encontrar el
	 * producto a eliminar.
	 */
	private String opcion2() throws Exception{
		String resultadoOperacion = "Resultado de la operación 2";
		
		String idProductoEliminar = Terminal.muestraMensajeRespuesta("Introduce el código del producto que deseas eliminar");
		Persistencia.eliminaProducto(idProductoEliminar);
		resultadoOperacion = "El producto " + idProductoEliminar + " ha sido eliminado";
		return resultadoOperacion;
	}
	
	/**
	 * Método privado para el: "Alta de un nuevo producto al listado de Stock".
	 * Se pretende dar de alta un producto de el Stock de la tienda. Ante ello, el método ha de
	 * comprobar si dicho producto ya estuviese en ese Stock para no ser duplicado. Una vez
	 * comprobado que no existe en el Stock, pide cuántos productos del mismo se quieren añadir.
	 * @return String. Devuelve el mensaje que configuramos para informar al usuario del resultado de
	 * la operación.
	 * @throws Exception. Puede lanzar una excepción en caso de que el producto ya se encuentre en
	 * el stock de la tienda o que el número de productos a introducir en el stock sea incorrecto.
	 */
	private String opcion5() throws Exception{
		String resultadoOperacion = "Resultado de la operación 5";
		
		String idProductoAñadir = Terminal.muestraMensajeRespuesta("Introduce el código del producto del Stock que deseas añadir");
		if (stock.getRegistro(idProductoAñadir) != null)
			throw new Exception ("El código del producto introducido ya existe");
		String numProductosStr = Terminal.muestraMensajeRespuesta("Cuántos productos deseas añadir"); 
		try {
			int numProductos = Integer.parseInt(numProductosStr);
			stock.añadirStock(idProductoAñadir, numProductos);
			resultadoOperacion = "Operación realizada correctamente";
		}catch (Exception e) {
			throw new Exception ("Número de productos incorrecto");
		}
		return resultadoOperacion;
	}
	
	
	
	/**
	 * Método privado para la: "Actualización del Stock de un Producto".
	 * Se pretende actualizar el número de productos que hay de un producto determinado.
	 * @return String. Devuelve el mensaje que configuramos para informar al usuario del resultado de
	 * la operación.
	 * @throws Exception. Puede distribuir la excepción generada a la hora de no poder encontrar el
	 * producto o que el número de productos a actualizar en el stock sea incorrecto.
	 */
	private String opcion6() throws Exception{
		String resultadoOperacion = "Resultado de la operación 6";
		
		String idProductoActualizar = Terminal.muestraMensajeRespuesta("Introduce el código del producto del Stock que deseas actualizar");
		Terminal.muestraMensaje("Del producto " + idProductoActualizar + " hay " + stock.getStock(idProductoActualizar) + " unidades");
		String numProductosStr = Terminal.muestraMensajeRespuesta("Cuántos productos deseas añadir"); 
		try {
			int numProductos = Integer.parseInt(numProductosStr);
			stock.añadirStock(idProductoActualizar, numProductos);
			resultadoOperacion = "Operación realizada correctamente";
		}catch (Exception e) {
			throw new Exception ("Número de productos incorrecto");
		}
		return resultadoOperacion;
	}
}
