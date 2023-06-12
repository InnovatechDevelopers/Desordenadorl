package modelos;

public class Item {
	
	private Producto producto;
	private double descuento;
	
	public Item (Producto producto){
		this.setProducto(producto);
		this.setDescuento(0.0);
	}
	
	public Item (Producto producto, double descuento){
		this.setProducto(producto);
		this.setDescuento(descuento);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto){
		this.producto = producto;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
