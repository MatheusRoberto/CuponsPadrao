package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import dao.CompraDAO;
import dao.CompraDAOImpl;
import entities.ColecaoCupom;
import entities.ColecaoCupomAlimentos;
import entities.ColecaoCupomCombustivel;
import entities.Compra;
import entities.Cupom;
import entities.Fisica;
import entities.ItemCompra;
import entities.Pagamento;

public class CompraController {

	private Compra compra;
	private CompraDAO cDAO;
	private Map<ColecaoCupom, Integer> itens;

	public CompraController() {
		// TODO Auto-generated constructor stub
		itens = new HashMap<>();
	}

	public Compra getCompra() {
		if (compra == null)
			compra = new Compra();
		return compra;
	}

	private CompraDAO getCompraDAO() {
		if (cDAO == null)
			cDAO = new CompraDAOImpl();
		return cDAO;
	}

	private void newCompra() {
		compra = new Compra();
	}

	public void cadastrar() {
		this.getCompraDAO().save(compra);
		this.newCompra();
	}

	public void excluir() {
		this.getCompraDAO().remove(compra);
		this.newCompra();
	}

	public void editar() {
		this.getCompraDAO().editar(compra);
		this.newCompra();
	}

	public Compra buscaCompra(Compra compra) {
		this.compra = this.getCompraDAO().busca(compra);
		return this.getCompra();
	}

	public ArrayList<Compra> buscaPor(Fisica f) {
		return this.getCompraDAO().buscaFisica(f);
	}

	public ArrayList<ColecaoCupom> listaColecoes() {
		ArrayList<ColecaoCupom> colecoes = new ArrayList<>();
		for (ColecaoCupom key : this.itens.keySet()) {
			colecoes.add(key);
		}
		return colecoes;
	}

	public HashMap<ColecaoCupom, Integer> getItens() {
		return new HashMap<>(itens);
	}

	public void adicionaColecao(ColecaoCupom cc, int qtde) {
		this.itens.put(cc, qtde);
	}

	public void alteraQuantidade(ColecaoCupom cc, int qtde) {
		int total = qtde;
		if (this.itens.containsKey(cc))
			total += this.itens.get(cc);
		this.itens.put(cc, total);
	}

	public void removeColecao(ColecaoCupom cc) {
		this.itens.remove(cc);
	}

	public boolean finalizaCompra(Pagamento p) {
		this.getCompra().setPagamento(p);
		this.getCompra().setDataVenda(new Date());
		this.adicionaItens();
		if (this.getCompra().getFisica() == null || this.getCompra().getItens().isEmpty())
			return false;
		this.getCompraDAO().save(this.getCompra());
		return true;
	}

	private void adicionaItens() {
		for (ColecaoCupom key : this.itens.keySet()) {
			for (int i = 0; i < this.itens.get(key); i++) {
				if (key instanceof ColecaoCupomCombustivel) {
					ColecaoCupomCombustivel ccc = (ColecaoCupomCombustivel) key;
					for (Cupom cupom : ccc.getCupons()) {
						this.adicionaItemCompra(cupom, ccc);
					}
				}
				if (key instanceof ColecaoCupomAlimentos) {
					ColecaoCupomAlimentos cca = (ColecaoCupomAlimentos) key;
					for (Cupom cupom : cca.getCupons()) {
						this.adicionaItemCompra(cupom, cca);
					}
				}

			}
		}
	}

	private void adicionaItemCompra(Cupom c, ColecaoCupom cc) {
		ItemCompra ic = new ItemCompra();
		ic.setCodigoValidacao(this.geraCodigo());
		ic.setColecaoCupom(cc);
		ic.setCompra(this.getCompra());
		ic.setCupom(c);
		ic.setValido(false);
		this.getCompra().getItens().add(ic);
	}

	private long geraCodigo() {
		return (long) (1000000000000l + Math.random() * 8999999999999l);
	}
}
