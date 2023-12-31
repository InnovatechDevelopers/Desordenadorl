package modelos.clientes;

/**
 * Representa a un Cliente Particular
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public class Particular extends Cliente {

	public static String identificador = "DNI/NIE";

	private String dni;

	public Particular(String nombre, String dni, String direccion, String telefono, String email) {
		super(nombre, direccion, telefono, email);
		this.setDni(dni);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
