package entities;

import java.util.Date;

public abstract class ColecaoCupom implements Cloneable{
	
	private String nome;
	private String versao;
	private String descricao;
	private Date dataValidade;
	private Date dataInicio;
	private float preco;
	
	public ColecaoCupom() {
		// TODO Auto-generated constructor stub
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	

	public void listarColecao() {
		// TODO implement here
		System.out.println("Cole��o: "+getNome());
		System.out.println(" - Vers�o: "+ getVersao());
		System.out.println("Valor: R$"+getPreco());
		System.out.println("Data de Inicio: "+getDataInicio()+"/ Data Termino: " + getDataValidade());
		System.out.println("Descri��o: "+getDescricao());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
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
	
	@Override
	protected ColecaoCupom clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (ColecaoCupom) super.clone();
	}

}