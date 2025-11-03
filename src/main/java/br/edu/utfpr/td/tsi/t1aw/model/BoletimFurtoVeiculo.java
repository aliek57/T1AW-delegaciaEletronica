package br.edu.utfpr.td.tsi.t1aw.model;

import java.time.LocalDate;
import java.util.List;

public class BoletimFurtoVeiculo {
	private String identificador;
	private LocalDate dataOcorrencia;
	private String periodoOcorrencia;
	private Endereco localOcorrencia;
	private List<Parte> partes;
	private Veiculo veiculoFurtado;
	
	public BoletimFurtoVeiculo() { 
        super();
    }
	
	public BoletimFurtoVeiculo(String identificador, LocalDate dataOcorrencia, String periodoOcorrencia,
			Endereco localOcorrencia, List<Parte> partes, Veiculo veiculoFurtado) {
		super();
		this.identificador = identificador;
		this.dataOcorrencia = dataOcorrencia;
		this.periodoOcorrencia = periodoOcorrencia;
		this.localOcorrencia = localOcorrencia;
		this.partes = partes;
		this.veiculoFurtado = veiculoFurtado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public LocalDate getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(LocalDate dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getPeriodoOcorrencia() {
		return periodoOcorrencia;
	}

	public void setPeriodoOcorrencia(String periodoOcorrencia) {
		this.periodoOcorrencia = periodoOcorrencia;
	}

	public Endereco getLocalOcorrencia() {
		return localOcorrencia;
	}

	public void setLocalOcorrencia(Endereco localOcorrencia) {
		this.localOcorrencia = localOcorrencia;
	}

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

	public Veiculo getVeiculoFurtado() {
		return veiculoFurtado;
	}

	public void setVeiculoFurtado(Veiculo veiculoFurtado) {
		this.veiculoFurtado = veiculoFurtado;
	}
}
