package controllers;

import java.util.ArrayList;

import dao.CupomDAO;
import dao.CupomDAOImpl;
import entities.Cupom;
import entities.CupomAlimento;

public class CupomAlimentoController {

	private CupomDAO cDAO;
	private CupomAlimento cupom;
	
	public CupomAlimento getCupom() {
		if(cupom == null)
			cupom = new CupomAlimento();
		return cupom;
	}
	
	private CupomDAO getCupomDAO() {
		if(cDAO == null)
			cDAO = new CupomDAOImpl();
		return cDAO;
	}
	
	private void newCupom() {
		cupom = new CupomAlimento();
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
		this.cupom = (CupomAlimento) this.getCupomDAO().busca(cupom);
		return this.getCupom();
	}
	
	public ArrayList<Cupom> buscaPorNome(String n){
		return this.getCupomDAO().buscaNome(n);
	}
	
}
