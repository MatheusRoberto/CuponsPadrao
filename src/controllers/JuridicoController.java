package controllers;

import java.util.ArrayList;

import dao.CompraDAO;
import dao.CompraDAOImpl;
import dao.CupomDAO;
import dao.CupomDAOImpl;
import dao.JuridicaDAO;
import dao.JuridicaDAOImpl;
import entities.Cupom;
import entities.ItemCompra;
import entities.Juridica;

public class JuridicoController {

	private JuridicaDAO jDAO;
	private Juridica juridica;
	private CupomDAO cDAO;
	private CompraDAO coDAO;

	public Juridica getJuridica() {
		if (juridica == null)
			juridica = new Juridica();
		return juridica;
	}

	private JuridicaDAO getJuridicaDAO() {
		if (jDAO == null)
			jDAO = new JuridicaDAOImpl();
		return jDAO;
	}

	private CupomDAO getCupomDAO() {
		if (cDAO == null)
			cDAO = new CupomDAOImpl();
		return cDAO;
	}

	private CompraDAO getCompraDAO() {
		if (coDAO == null)
			coDAO = new CompraDAOImpl();
		return coDAO;
	}

	private void newJuridica() {
		juridica = new Juridica();
	}

	public void cadastrar() {
		this.getJuridicaDAO().save(juridica);
		this.newJuridica();
	}

	public void excluir() {
		this.getJuridicaDAO().remove(juridica);
		this.newJuridica();
	}

	public void editar() {
		this.getJuridicaDAO().editar(juridica);
		this.newJuridica();
	}

	public Juridica buscaJuridica(Juridica Juridica) {
		this.juridica = this.getJuridicaDAO().busca(Juridica);
		return this.getJuridica();
	}

	public ArrayList<Juridica> buscaPorCNPJ(String cnpj) {
		return this.getJuridicaDAO().buscaCNPJ(cnpj);
	}

	public ArrayList<Cupom> listaCupons() {
		return this.getCupomDAO().buscaJuridica(juridica);
	}

	public boolean validaCupom(ItemCompra ic) {
		if (ic.isValido() && ic.getCupom().getFornecedor().equals(this.getJuridica())) {
			this.salvaUsoCupom(ic);
			return true;
		}
		return false;
	}

	private void salvaUsoCupom(ItemCompra ic) {
		for (ItemCompra itemCompra : ic.getCompra().getItens()) {
			if (itemCompra.getCodigoValidacao() == ic.getCodigoValidacao()) {
				ic.getCompra().getItens();
				break;
			}
		}
		this.getCompraDAO().editar(ic.getCompra());
	}

}
