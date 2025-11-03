package br.edu.utfpr.td.tsi.t1aw.service;

import br.edu.utfpr.td.tsi.t1aw.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.t1aw.repository.BoletimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoletimService {

    private final BoletimRepository boletimRepository;
    private final List<BoletimFurtoVeiculo> todosBoletins;

    @Autowired
    public BoletimService(BoletimRepository boletimRepository) {
        this.boletimRepository = boletimRepository;
        this.todosBoletins = this.boletimRepository.carregarDados();
    }

    public List<BoletimFurtoVeiculo> getAllBoletins() {
        return todosBoletins;
    }

    public List<BoletimFurtoVeiculo> filterByIdentificador(String identificador) {
        return todosBoletins.stream()
                .filter(b -> b.getIdentificador().equalsIgnoreCase(identificador))
                .collect(Collectors.toList());
    }
    
    public List<BoletimFurtoVeiculo> filterByCidadeOcorrencia(String cidade) {
        return todosBoletins.stream()
                .filter(b -> b.getLocalOcorrencia().getCidade().equalsIgnoreCase(cidade))
                .collect(Collectors.toList());
    }

    public List<BoletimFurtoVeiculo> filterByPeriodoOcorrencia(String periodo) {
        return todosBoletins.stream()
                .filter(b -> b.getPeriodoOcorrencia().equalsIgnoreCase(periodo))
                .collect(Collectors.toList());
    }
    
    public List<BoletimFurtoVeiculo> filterByPlacaVeiculo(String placa) {
        return todosBoletins.stream()
                .filter(b -> b.getVeiculoFurtado().getEmplacamento().getPlaca().equalsIgnoreCase(placa))
                .collect(Collectors.toList());
    }
    
    public List<BoletimFurtoVeiculo> filterByCorVeiculo(String cor) {
        return todosBoletins.stream()
                .filter(b -> b.getVeiculoFurtado().getCor().equalsIgnoreCase(cor))
                .collect(Collectors.toList());
    }

    public List<BoletimFurtoVeiculo> filterByTipoVeiculo(String tipo) {
        return todosBoletins.stream()
                .filter(b -> b.getVeiculoFurtado().getTipoVeiculo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
    
    /* CRUD */
    public BoletimFurtoVeiculo createBoletim(BoletimFurtoVeiculo novoBoletim) {
        novoBoletim.setIdentificador(UUID.randomUUID().toString());
        novoBoletim.setPartes(null); 
        
        todosBoletins.add(novoBoletim);
        return novoBoletim;
    }
    
    public BoletimFurtoVeiculo updateBoletim(String identificador, BoletimFurtoVeiculo boletimAtualizado) {
        for (int i = 0; i < todosBoletins.size(); i++) {
            BoletimFurtoVeiculo b = todosBoletins.get(i);
            
            if (b.getIdentificador().equalsIgnoreCase(identificador)) {
                b.setDataOcorrencia(boletimAtualizado.getDataOcorrencia());
                b.setPeriodoOcorrencia(boletimAtualizado.getPeriodoOcorrencia());
                b.setLocalOcorrencia(boletimAtualizado.getLocalOcorrencia());
                b.setVeiculoFurtado(boletimAtualizado.getVeiculoFurtado());
                b.setPartes(null); 

                return b;
            }
        }
        throw new RuntimeException("Boletim não encontrado com identificador: " + identificador);
    }
    
    public void deleteBoletim(String identificador) {
        boolean removed = todosBoletins.removeIf(b -> b.getIdentificador().equalsIgnoreCase(identificador));
        
        if (!removed) {
             throw new RuntimeException("Boletim não encontrado com identificador: " + identificador);
        }
    }
}