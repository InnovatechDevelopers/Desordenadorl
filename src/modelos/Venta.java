package modelos;

import java.util.ArrayList;
import java.util.Date;

import modelos.clientes.Cliente;
import modelos.clientes.Empresa;
import utilidades.Utilidades;

/**
 * Se escenifica una venta como el acto de facturar a un cliente unos productos que previamente
 * se han cargado en el Stock de la tienda, hay disponibilidad de ellos y suma una cantidad de
 * dinero mediante el cálculo del coste de los productos menos los decuentos que le pueden pertenecer
 * por Empresa o por ofertas puntuales.
 * @author Grupo 13 - InnovaTech_Solutions
 *
 */
public class Venta  implements Comparable<Venta>{

	public static int nFactura = 0;
	public static double iva = 0.21;

	private ArrayList<Item> items;
	private Cliente cliente;
	private Date fecha;
	private String numFactura;
	private double subtotal = 0.0;

	public Venta(ArrayList<Item> items, Cliente cliente, Date fecha) {
		this.setItems(items);
		this.setCliente(cliente);
		this.setFecha(fecha);
		this.setNumFactura(++nFactura + "/" + Utilidades.formatoFecha("yyyy", fecha));

		for (Item item: items) {
			Producto producto = item.getProducto();
			this.subtotal += (producto.getPrecio() * (1 - (item.getDescuento()/100)));
		}
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		String retorno = "";
		retorno = "\n"
		+ "Número de Factura: " + this.getNumFactura() + "\n"
		+ "Cliente: " + this.getCliente() + "\n"
		+ "Fecha: " + Utilidades.formatoFecha("dd/MM/yyyy HH:MM:ss", this.getFecha()) + "\n"
		+ "Items:\n";

		for (Item item: this.items)
			retorno += item.getProducto() + "\n";

		retorno += "\nSubtotal: " + this.getSubtotal() + " €\n"
			+ "IVA: " + (this.getSubtotal()*Venta.iva) + "\n";

		if (cliente instanceof Empresa) {
			Empresa empresa = (Empresa)cliente;
			this.setSubtotal(this.getSubtotal() * (1 - empresa.getDescuento())/100);
			//this.setSubtotal(this.getSubtotal() * (1 - empresa.getDescuento() / 100));
			retorno += "Descuento por Empresa: " + this.getSubtotal() + "%\n"
					+ "Subtotal (Empresa): " + this.getSubtotal() + "";
		}

		retorno += "TOTAL: " + (this.getSubtotal()*(1 + Venta.iva));
		return retorno;
	}

	//Dos facturas son iguales si tienen la misma numeración.
	@Override
	public int compareTo(Venta o) {
		return this.getNumFactura().compareTo(o.getNumFactura());
	}
}
