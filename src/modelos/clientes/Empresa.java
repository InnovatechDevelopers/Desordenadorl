package modelos.clientes;

/**
 * Representa a un Cliente Empresa.
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public class Empresa extends Cliente{

	public static String identificador = "CIF";

	private Cliente contacto;
	private String cif;
	private double descuento;

	public Empresa(String nombre, String cif, String direccion, String telefono, String email, Cliente contacto) {
		super(nombre, direccion, telefono, email);
		this.setCif(cif);
		this.setContacto(contacto);
		this.setDescuento(0.0);
	}

	public Cliente getContacto() {
		return contacto;
	}

	public void setContacto(Cliente contacto) {
		this.contacto = contacto;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return super.toString() + " - Contacto: " + this.contacto.getNombre();
	}

}
