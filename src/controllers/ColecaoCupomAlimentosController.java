package controllers;

import java.util.ArrayList;

import dao.ColecaoCupomDAO;
import dao.ColecaoCupomDAOImpl;
import entities.ColecaoCupom;
import entities.ColecaoCupomAlimentos;
import entities.CupomAlimento;

public class ColecaoCupomAlimentosController {

	private ColecaoCupomDAO ccDAO;
	private ColecaoCupomAlimentos colecaoCupom;

	
	public ColecaoCupomAlimentos getColecaoCupom() {
		if(colecaoCupom == null)
			colecaoCupom = new ColecaoCupomAlimentos();
		return colecaoCupom;
	}
	
	private ColecaoCupomDAO getColecaoCupomDAO() {
		if(ccDAO == null)
			ccDAO = new ColecaoCupomDAOImpl();
		return ccDAO;
	}
	
	private void newColecaoCupom() {
		colecaoCupom = new ColecaoCupomAlimentos();
	}
	
	public void cadastrar() {
		this.getColecaoCupomDAO().save(colecaoCupom);
		this.newColecaoCupom();
	}
	
	public void excluir() {
		this.getColecaoCupomDAO().remove(colecaoCupom);
		this.newColecaoCupom();
	}
	
	public void editar() {
		this.getColecaoCupomDAO().editar(colecaoCupom);
		this.newColecaoCupom();
	}
	
	public ColecaoCupom buscaColecaoCupom(ColecaoCupom colecaoCupom) {
		this.colecaoCupom = (ColecaoCupomAlimentos) this.getColecaoCupomDAO().busca(colecaoCupom);
		return this.getColecaoCupom();
	}
	
	public ArrayList<ColecaoCupom> buscaPorNome(String n){
		return this.getColecaoCupomDAO().buscaNome(n);
	}
	
	public ArrayList<CupomAlimento> getCupons(){
		return new ArrayList<>(this.getColecaoCupom().getCupons());
	}
	
	public void addCupom(CupomAlimento c) {
		this.getColecaoCupom().getCupons().add(c);
	}
	
	public void removeCupom(CupomAlimento c) {
		this.getColecaoCupom().getCupons().remove(c);
	}
	
}
