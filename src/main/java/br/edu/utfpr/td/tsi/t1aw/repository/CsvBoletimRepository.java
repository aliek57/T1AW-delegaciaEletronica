package br.edu.utfpr.td.tsi.t1aw.repository;

import br.edu.utfpr.td.tsi.t1aw.model.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.t1aw.model.Emplacamento;
import br.edu.utfpr.td.tsi.t1aw.model.Endereco;
import br.edu.utfpr.td.tsi.t1aw.model.Veiculo;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class CsvBoletimRepository implements BoletimRepository {

    private static final String CSV_FILE_PATH = "src/main/resources/furtos.csv";
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String getDadosOuVazio(String[] dados, Integer index) {
	    if (index != null && index >= 0 && dados.length > index) {
	        return dados[index];
	    }
	    return "";
    }

    @Override
    public List<BoletimFurtoVeiculo> carregarDados() {
        List<BoletimFurtoVeiculo> boletins = new ArrayList<>();
        Map<String, Integer> colIndex = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String header = br.readLine();
            String[] colunas = header.split("\t");
            
            for (int i = 0; i < colunas.length; i++) {
                String columnName = colunas[i].trim();
                colIndex.put(columnName, i);
            }

            Integer numBoIndex = colIndex.get("NUM_BO"); 
            Integer dataOcorrenciaIndex = colIndex.get("DATAOCORRENCIA");
            Integer periodoOcorrenciaIndex = colIndex.get("PERIDOOCORRENCIA"); 
            Integer logradouroIndex = colIndex.get("LOGRADOURO");
            Integer numeroIndex = colIndex.get("NUMERO");
            Integer bairroIndex = colIndex.get("BAIRRO");
            Integer cidadeIndex = colIndex.get("CIDADE");
            Integer ufIndex = colIndex.get("UF");
            Integer rubricaIndex = colIndex.get("RUBRICA");
            Integer placaVeiculoIndex = colIndex.get("PLACA_VEICULO");
            Integer cidadeVeiculoIndex = colIndex.get("CIDADE_VEICULO");
            Integer ufVeiculoIndex = colIndex.get("UF_VEICULO");
            Integer corVeiculoIndex = colIndex.get("DESCR_COR_VEICULO");
            Integer marcaVeiculoIndex = colIndex.get("DESCR_MARCA_VEICULO");
            Integer anoFabricacaoIndex = colIndex.get("ANO_FABRICACAO");
            Integer tipoVeiculoIndex = colIndex.get("DESCR_TIPO_VEICULO");
            
            if (numBoIndex == null || periodoOcorrenciaIndex == null || rubricaIndex == null ||
                anoFabricacaoIndex == null || logradouroIndex == null || dataOcorrenciaIndex == null) {
                System.err.println("ERRO: Uma ou mais colunas essenciais não foram encontradas no CSV. Verifique os nomes das colunas.");
                return Collections.emptyList();
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] dados = line.split("\t", -1);

                try {
                    String rubrica = getDadosOuVazio(dados, rubricaIndex);
                    if (!rubrica.contains("VEICULO")) {
                        continue;
                    }

                    Emplacamento emplacamento = new Emplacamento(
                        getDadosOuVazio(dados, placaVeiculoIndex),
                        getDadosOuVazio(dados, cidadeVeiculoIndex),
                        getDadosOuVazio(dados, ufVeiculoIndex)
                    );
                    
                    int anoFabricacao = 0;
                    String anoStr = getDadosOuVazio(dados, anoFabricacaoIndex);
                    
                    if (!anoStr.isBlank()) {
                        anoFabricacao = Integer.parseInt(anoStr.trim());
                    }

                    Veiculo veiculo = new Veiculo(
                        anoFabricacao,
                        getDadosOuVazio(dados, corVeiculoIndex),
                        getDadosOuVazio(dados, marcaVeiculoIndex),
                        getDadosOuVazio(dados, tipoVeiculoIndex),
                        emplacamento
                    );
                    
                    Endereco endereco = new Endereco(
                        getDadosOuVazio(dados, logradouroIndex),
                        getDadosOuVazio(dados, numeroIndex),
                        getDadosOuVazio(dados, bairroIndex),
                        getDadosOuVazio(dados, cidadeIndex),
                        getDadosOuVazio(dados, ufIndex)
                    );

                    String dataOcorrenciaStr = getDadosOuVazio(dados, dataOcorrenciaIndex);

                    if (dataOcorrenciaStr.isBlank()) {
                        throw new IllegalArgumentException("Data de Ocorrência vazia para a linha: " + line);
                    }
                    
                    BoletimFurtoVeiculo boletim = new BoletimFurtoVeiculo(
                        getDadosOuVazio(dados, numBoIndex),
                        LocalDate.parse(dataOcorrenciaStr.trim(), DATE_FORMATTER),
                        getDadosOuVazio(dados, periodoOcorrenciaIndex),
                        endereco,
                        new ArrayList<>(),
                        veiculo
                    );

                    boletins.add(boletim);
                } catch (Exception e) {
                    System.err.println("Erro ao processar linha: " + line);
                    e.printStackTrace();
                };
            }
            System.out.println("Lista de boletins concluída! Total de registros carregados: " + boletins.size());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return boletins;
    }
}