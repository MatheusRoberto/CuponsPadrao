package controllers;

import java.util.ArrayList;

import entities.Compra;

public class CompraProxy implements CompraInterface{
	private ArrayList<Compra> compra;
	private FisicoController fisicaController;
	
	public CompraProxy(FisicoController f) {
		// TODO Auto-generated constructor stub
		this.fisicaController = f;
	}

	@Override
	public ArrayList<Compra> listaCompras() {
		// TODO Auto-generated method stub
		if(compra == null) {
			System.out.println("Listando compras:");
			compra = fisicaController.listaCompras(); 
		}
		return compra;
	}

}
