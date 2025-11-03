package br.edu.utfpr.td.tsi.t1aw.controller;

import br.edu.utfpr.td.tsi.t1aw.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.t1aw.service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/boletins")
public class BoletimController {

    private final BoletimService boletimService;

    @Autowired
    public BoletimController(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @GetMapping
    public List<BoletimFurtoVeiculo> getAll() {
        return boletimService.getAllBoletins();
    }

    @GetMapping("/identificador")
    public List<BoletimFurtoVeiculo> getByIdentificador(@RequestParam String identificador) {
        return boletimService.filterByIdentificador(identificador);
    }

    @GetMapping("/cidade")
    public List<BoletimFurtoVeiculo> getByCidadeOcorrencia(@RequestParam String cidade) {
        return boletimService.filterByCidadeOcorrencia(cidade);
    }
    
    @GetMapping("/periodo")
    public List<BoletimFurtoVeiculo> getByPeriodoOcorrencia(@RequestParam String periodo) {
        return boletimService.filterByPeriodoOcorrencia(periodo);
    }
    
    @GetMapping("/veiculos/placa")
    public List<BoletimFurtoVeiculo> getByPlacaVeiculo(@RequestParam String placa) {
        return boletimService.filterByPlacaVeiculo(placa);
    }
    
    @GetMapping("/veiculos/cor")
    public List<BoletimFurtoVeiculo> getByCorVeiculo(@RequestParam String cor) {
        return boletimService.filterByCorVeiculo(cor);
    }

    @GetMapping("/veiculos/tipo")
    public List<BoletimFurtoVeiculo> getByTipoVeiculo(@RequestParam String tipo) {
        return boletimService.filterByTipoVeiculo(tipo);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoletimFurtoVeiculo createBoletim(@RequestBody BoletimFurtoVeiculo boletim) {
        return boletimService.createBoletim(boletim);
    }
    
    @PutMapping("/{identificador}")
    public BoletimFurtoVeiculo updateBoletim(@PathVariable String identificador, @RequestBody BoletimFurtoVeiculo boletim) {
        return boletimService.updateBoletim(identificador, boletim);
    }
    
    @DeleteMapping("/{identificador}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBoletim(@PathVariable String identificador) {
        boletimService.deleteBoletim(identificador);
    }
}