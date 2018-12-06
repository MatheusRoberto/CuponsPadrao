package controllers;

import java.util.ArrayList;

import dao.CompraDAO;
import dao.CompraDAOImpl;
import dao.FisicaDAO;
import dao.FisicaDAOImpl;
import entities.ColecaoCupom;
import entities.Compra;
import entities.Cupom;
import entities.Fisica;
import entities.ItemCompra;

public class FisicoController implements CompraInterface{

	private FisicaDAO fDAO;
	private Fisica fisica;
	private CompraDAO cDAO;
	
	public Fisica getFisica() {
		if(fisica == null)
			fisica = new Fisica();
		return fisica;
	}
	
	private FisicaDAO getFisicaDAO() {
		if(fDAO == null)
			fDAO = new FisicaDAOImpl();
		return fDAO;
	}
	
	private CompraDAO getCompraDAO() {
		if(cDAO == null)
			cDAO = new CompraDAOImpl();
		return cDAO;
	}
	
	private void newFisica() {
		fisica = new Fisica();
	}
	
	public void cadastrar() {
		this.getFisicaDAO().save(fisica);
		this.newFisica();
	}
	
	public void excluir() {
		this.getFisicaDAO().remove(fisica);
		this.newFisica();
	}
	
	public void editar() {
		this.getFisicaDAO().editar(fisica);
		this.newFisica();
	}
	
	public Fisica buscaFisica(Fisica fisica) {
		this.fisica = this.getFisicaDAO().busca(fisica);
		return this.getFisica();
	}
	
	public ArrayList<Fisica> buscaPorCPF(String cpf){
		return this.getFisicaDAO().buscaCPF(cpf);
	}
	
	public ArrayList<Compra> listaCompras(){
		System.out.println("Buscando no banco");
		return this.getCompraDAO().buscaFisica(fisica);
	}
	
	public ArrayList<ColecaoCupom> listaColecoes(){
		ArrayList<Compra> compras = this.listaCompras();
		ArrayList<ColecaoCupom> colecoes = new ArrayList<>();
		for (Compra compra : compras) {
			for (ItemCompra itemCompra : compra.getItens()) {
				if(!colecoes.contains(itemCompra.getColecaoCupom()))
					colecoes.add(itemCompra.getColecaoCupom());
			}
		}
		return colecoes;
	}
	
	public ArrayList<Cupom> listaCupons(){
		ArrayList<Compra> compras = this.listaCompras();
		ArrayList<Cupom> cupons = new ArrayList<>();
		for (Compra compra : compras) {
			for (ItemCompra itemCompra : compra.getItens()) {
				cupons.add(itemCompra.getCupom());
			}
		}
		return cupons;
	}
	
}
