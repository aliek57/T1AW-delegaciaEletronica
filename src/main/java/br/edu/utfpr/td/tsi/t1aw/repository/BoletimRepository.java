package br.edu.utfpr.td.tsi.t1aw.repository;

import java.util.List;
import br.edu.utfpr.td.tsi.t1aw.model.BoletimFurtoVeiculo;

public interface BoletimRepository {
    List<BoletimFurtoVeiculo> carregarDados();
}
