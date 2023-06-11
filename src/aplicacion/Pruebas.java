package aplicacion;

import java.util.TreeMap;

import modelos.*;
import productos.Teclado;


public class Pruebas {
	public static void main(String[] agrs) {
		Pruebas pruebas = new Pruebas();	
	}
	
	public Pruebas () {
		TreeMap<Teclado, Integer> mapa = new TreeMap<Teclado, Integer>();
		try{
			
			mapa.put(new Teclado("P07"), 5);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
