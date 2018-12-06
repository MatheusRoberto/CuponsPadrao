package entities;

public class ItemCompra {

	private Cupom cupom;
	private Compra compra;
	private ColecaoCupom colecaoCupom;
	private long codigoValidacao;
	private boolean valido;

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public long getCodigoValidacao() {
		return codigoValidacao;
	}

	public void setCodigoValidacao(long codigoValidacao) {
		this.codigoValidacao = codigoValidacao;
	}

	public void setColecaoCupom(ColecaoCupom colecaoCupom) {
		this.colecaoCupom = colecaoCupom;
	}

	public ColecaoCupom getColecaoCupom() {
		return colecaoCupom;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

}