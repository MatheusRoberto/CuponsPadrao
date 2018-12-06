package entities;


public class Fisica extends Cliente {

	private String CPF;

	public Fisica(String n, String e, String t, String s, String c, Endereco en) {
		// TODO Auto-generated constructor stub
		super(n, e, t, s, en);
		setCpf(c);
	}

	public Fisica() {
		// TODO Auto-generated constructor stub
	}

	public String getCpf() {
		return CPF;
	}

	public void setCpf(String cpf) {
		this.CPF = cpf;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome() + " CPF: " + getCpf();
	}


}