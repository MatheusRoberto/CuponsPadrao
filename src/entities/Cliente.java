package entities;

public abstract class Cliente {
	
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private Endereco endereco;

	public Cliente(String n, String e, String t, String s, Endereco en) {
		// TODO Auto-generated constructor stub
		setNome(n);
		setEmail(e);
		setTelefone(t);
		setSenha(s);
		setEndereco(en);
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}