var limparTabela = function() {
    $("#tabelaBos tbody").empty(); 
}

var renderizarTabela = function(resultados) {
    limparTabela();
    var $tbody = $("#tabelaBos tbody"); 
    
    if (!resultados || resultados.length === 0) {
        $("#loading").text('Nenhum boletim de ocorrência encontrado para o critério de busca.');
        $tbody.html('<tr><td colspan="9" style="text-align: center;">Nenhum boletim de ocorrência encontrado.</td></tr>');
        return;
    }
    
    $.each(resultados, function(index, item) { 
        var identificador, dataOcorrencia, cidade, bairro, periodoOcorrencia, marca, placa, cor, tipo;

        var bo = item;
        identificador = bo.identificador || '';
        dataOcorrencia = bo.dataOcorrencia || '';
        periodoOcorrencia = bo.periodoOcorrencia || '';
        cidade = bo.localOcorrencia ? bo.localOcorrencia.cidade : '';
		bairro = bo.localOcorrencia ? bo.localOcorrencia.bairro : '';
        marca = bo.veiculoFurtado ? bo.veiculoFurtado.marca : '';
        cor = bo.veiculoFurtado ? bo.veiculoFurtado.cor : '';
        placa = (bo.veiculoFurtado && bo.veiculoFurtado.emplacamento) ? bo.veiculoFurtado.emplacamento.placa : '';
		tipo = bo.veiculoFurtado ? bo.veiculoFurtado.tipoVeiculo : '';

        var novaLinha =
        '<tr>' +
        '<td style="text-align: center">' + identificador + '</td>' +
        '<td style="text-align: center">' + dataOcorrencia + '</td>' +
        '<td style="text-align: center">' + cidade + '</td>' +
		'<td style="text-align: center">' + bairro + '</td>' +
        '<td style="text-align: center">' + periodoOcorrencia + '</td>' +
        '<td style="text-align: center">' + marca + '</td>' +
        '<td style="text-align: center">' + placa + '</td>' +
        '<td style="text-align: center">' + cor +'</td>' +
		'<td style="text-align: center">' + tipo +'</td>' +
        '</tr>';
    
        $tbody.append(novaLinha);
    });
};

var realizarConsulta = function() {
    var criterio = $("#search-criteria").val();
    var valor = $("#search-value").val().trim();
    var baseUrl = "http://localhost:8080/api/boletins";
    var apiUrl = "";

	$("#loading").text("Carregando dados...");
    limparTabela();

    if (valor === '') {
        $("#loading").text("Por favor, informe um valor de busca.");
        return; 
    }
    
    var valorCodificado = encodeURIComponent(valor);

    switch(criterio) {
        case 'identificador':
            apiUrl = `${baseUrl}/identificador?identificador=${valorCodificado}`;;
            break;
        case 'cidade':
            apiUrl = `${baseUrl}/cidade?cidade=${valorCodificado}`;
            break;
        case 'periodo':
            apiUrl = `${baseUrl}/periodo?periodo=${valorCodificado}`;
            break;
        case 'placa':
            apiUrl = `${baseUrl}/veiculos/placa?placa=${valorCodificado}`; 
            break;
        case 'cor':
            apiUrl = `${baseUrl}/veiculos/cor?cor=${valorCodificado}`;
            break;
        case 'tipo':
            apiUrl = `${baseUrl}/veiculos/tipo?tipo=${valorCodificado}`;
            break;
        default:
			$("#loading").text("Critério inválido");
			return;
    }
	
	$.ajax({
	    url: apiUrl,
	    type: 'GET',
	    async: true,
	    contentType: 'application/json',
	    
	    success: function(resultadoBusca) {
	        renderizarTabela(resultadoBusca);
	    },
	    error: function() {
			$("#loading").html(`Erro ao carregar dados.`);
	    }
	});
};


$(document).ready(function() {    
    $("#search-button").on('click', realizarConsulta);
    
    $("#loading").text("Use a área de filtros para iniciar sua busca.");
});