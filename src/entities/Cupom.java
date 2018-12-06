package entities;

public abstract class Cupom implements Cloneable{

	private String nome;
	private String promocao;
	private String descricao;
	private String tipo;
	private Juridica fornecedor;

	public Cupom() {
		// TODO Auto-generated constructor stub
	}

	public Cupom(String n, String d, String t, Juridica j) {
		// TODO Auto-generated constructor stub
		setNome(n);
		setDescricao(d);
		setTipo(t);
		setFornecedor(j);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Juridica getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Juridica fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void listarCupom() {
		System.out.println("Cupom: "+getNome()+" - Fornecedor: "+ getFornecedor());
		System.out.println("Promo��o: "+getPromocao());
		System.out.println("Tipo: "+getTipo());
		System.out.println("Descri��o: "+getDescricao());
		System.out.println();
	}
	


	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		this.listarCupom();
		return super.toString();
	}
}