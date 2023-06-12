package modelos;

import utilidades.Persistencia;

/**
 * Representa al artículo en venta, que tanto puede el proveedor vender a la tienda, como puede la
 * tienda, mediante su inclusión en su stock, vender al Cliente.
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public abstract class Producto implements Comparable<Producto>, Cloneable{
	//Atributos de Productos
	private String idProducto;
	private String familia;
	private String subfamilia;
	private String tipo;
	private double precio;

	/**
	 * Para generar un nuevo producto será necesario indicar el idProducto correspondiente
	 * @param idProducto String del producto que se quiere generar
	 * @throws Exception Lanza la excepción si dicho idProducto no se encuentra en la lista de persistencia de Productos
	 */
	public Producto(String idProducto) throws Exception{
		//Puede lanzar la excepción de que no se encuentra el producto
		String[] datosProducto = Persistencia.getArrayDatos(idProducto);

		this.idProducto = idProducto;
		this.familia = datosProducto[0];
		this.subfamilia = datosProducto[1];
		this.tipo = datosProducto[2];
		try {
			this.precio = Double.parseDouble(datosProducto[3]);
		}catch (Exception e) {
			throw new Exception ("Error a la hora de crear el precio del Producto" + datosProducto[3]);
		}
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getSubfamilia() {
		return subfamilia;
	}

	public void setSubfamilia(String subfamilia) {
		this.subfamilia = subfamilia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [idProducto=" + idProducto + ", familia=" + familia + ", subfamilia=" + subfamilia + ", tipo="
				+ tipo + " | Precio: " + precio + " €]";
	}

	@Override
	public int compareTo (Producto o) {
		return idProducto.compareTo(o.getIdProducto());
	}
}