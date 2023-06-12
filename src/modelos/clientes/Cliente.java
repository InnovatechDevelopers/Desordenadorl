package modelos.clientes;

/**
 * Clase Abstracta. Simboliza al cliente de la tienda de informática con sus atributos correspondientes.
 * Su listado se conserva en la clase Persistencia
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public abstract class Cliente implements Comparable<Cliente>{

	protected static int contadorCliente = 0;

	private Integer codCliente;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private boolean lpd;



	public Cliente(String nombre, String direccion, String telefono, String email) {
		this.setCodCliente(Cliente.contadorCliente++);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setEmail(email);
		this.setLpd(false);
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	@Override
	public int compareTo(Cliente cliente) {
		return this.codCliente.compareTo(cliente.getCodCliente());
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [codCliente=" + codCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", email=" + email + "]";
	}


	public boolean isLpd() {
		return lpd;
	}


	public void setLpd(boolean lpd) {
		this.lpd = lpd;
	}

}
