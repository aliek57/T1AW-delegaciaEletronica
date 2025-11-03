package br.edu.utfpr.td.tsi.t1aw.model;

public class Parte {
	private String nome, email, telefone, tipoEnvolvimento;
	
	public Parte() {}

	public Parte(String nome, String email, String telefone, String tipoEnvolvimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.tipoEnvolvimento = tipoEnvolvimento;
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

	public String getTipoEnvolvimento() {
		return tipoEnvolvimento;
	}

	public void setTipoEnvolvimento(String tipoEnvolvimento) {
		this.tipoEnvolvimento = tipoEnvolvimento;
	}
}
