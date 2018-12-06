package controllers;

import java.util.ArrayList;

import dao.ColecaoCupomDAO;
import dao.ColecaoCupomDAOImpl;
import entities.ColecaoCupom;
import entities.ColecaoCupomCombustivel;
import entities.CupomCombustivel;

public class ColecaoCupomCombustivelController {

	private ColecaoCupomDAO ccDAO;
	private ColecaoCupomCombustivel colecaoCupom;

	
	public ColecaoCupomCombustivel getColecaoCupom() {
		if(colecaoCupom == null)
			colecaoCupom = new ColecaoCupomCombustivel();
		return colecaoCupom;
	}
	
	private ColecaoCupomDAO getColecaoCupomDAO() {
		if(ccDAO == null)
			ccDAO = new ColecaoCupomDAOImpl();
		return ccDAO;
	}
	
	private void newColecaoCupom() {
		colecaoCupom = new ColecaoCupomCombustivel();
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
	
	public ColecaoCupomCombustivel buscaColecaoCupom(ColecaoCupomCombustivel colecaoCupom) {
		this.colecaoCupom = (ColecaoCupomCombustivel) this.getColecaoCupomDAO().busca(colecaoCupom);
		return this.getColecaoCupom();
	}
	
	public ArrayList<ColecaoCupom> buscaPorNome(String n){
		return this.getColecaoCupomDAO().buscaNome(n);
	}
	
	public ArrayList<CupomCombustivel> getCupons(){
		return new ArrayList<>(this.getColecaoCupom().getCupons());
	}
	
	public void addCupom(CupomCombustivel c) {
		this.getColecaoCupom().getCupons().add(c);
	}
	
	public void removeCupom(CupomCombustivel c) {
		this.getColecaoCupom().getCupons().remove(c);
	}
	
}
