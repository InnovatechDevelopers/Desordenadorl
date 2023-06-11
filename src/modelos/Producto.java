package modelos;

import utilidades.Persistencia;

public abstract class Producto {
	//Atributos de Productos
	private String idProducto;
	private String familia;
	private String subfamilia;
	private String tipo;
	
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

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", familia=" + familia + ", subfamilia=" + subfamilia + ", tipo="
				+ tipo + "]";
	}
}