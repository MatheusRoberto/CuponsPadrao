package controllers;

import java.util.ArrayList;

import dao.CupomDAO;
import dao.CupomDAOImpl;
import entities.Cupom;
import entities.CupomCombustivel;

public class CupomCombustivelController {

	private CupomDAO cDAO;
	private CupomCombustivel cupom;
	
	public CupomCombustivel getCupom() {
		if(cupom == null)
			cupom = new CupomCombustivel();
		return cupom;
	}
	
	private CupomDAO getCupomDAO() {
		if(cDAO == null)
			cDAO = new CupomDAOImpl();
		return cDAO;
	}
	
	private void newCupom() {
		cupom = new CupomCombustivel();
	}
	
	public void cadastrar() {
		this.getCupomDAO().save(cupom);
		this.newCupom();
	}
	
	public void excluir() {
		this.getCupomDAO().remove(cupom);
		this.newCupom();
	}
	
	public void editar() {
		this.getCupomDAO().editar(cupom);
		this.newCupom();
	}
	
	public Cupom buscaCupom(Cupom cupom) {
		this.cupom = (CupomCombustivel) this.getCupomDAO().busca(cupom);
		return this.getCupom();
	}
	
	public ArrayList<Cupom> buscaPorNome(String n){
		return this.getCupomDAO().buscaNome(n);
	}
	
}
