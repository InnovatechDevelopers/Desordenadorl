package modelos.clientes;

public abstract class Cliente implements Comparable<Cliente>{
	
	protected static int contadorCliente = 0;
	
	private Integer codCliente;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	
	
	
	public Cliente(String nombre, String direccion, String telefono, String email) {
		this.setCodCliente(Cliente.contadorCliente++);
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
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
	
}
