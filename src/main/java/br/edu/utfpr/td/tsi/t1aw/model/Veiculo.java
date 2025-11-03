package br.edu.utfpr.td.tsi.t1aw.model;

public class Veiculo {
	private int anoFabricacao;
	private String cor, marca, tipoVeiculo;
	private Emplacamento emplacamento;
	
	public Veiculo() {}
	
	public Veiculo(int anoFabricacao, String cor, String marca, String tipoVeiculo, Emplacamento emplacamento) {
		super();
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.emplacamento = emplacamento;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Emplacamento getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}
}
