package entities;

import java.util.*;

/**
 * 
 */
public class Compra {

	private Date dataVenda;
	private Fisica fisica;
	private ArrayList<ItemCompra> itens;
	private Pagamento pagamento;

	public Compra() {
		// TODO Auto-generated constructor stub
		itens = new ArrayList<>();
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Fisica getFisica() {
		return fisica;
	}

	public void setFisica(Fisica fisica) {
		this.fisica = fisica;
	}

	public ArrayList<ItemCompra> getItens() {
		return this.itens;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}