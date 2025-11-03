package br.edu.utfpr.td.tsi.t1aw.model;

public class Emplacamento {
	private String placa, cidade, estado;
	
	public Emplacamento() {}

	public Emplacamento(String placa, String cidade, String estado) {
		super();
		this.placa = placa;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
