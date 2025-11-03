var listarBoletins = function() {    
    $.ajax({
        url: "http://localhost:8080/api/boletins",
        type: 'GET',
        async: true,
        contentType: 'application/json',
        
        success: function(boletins) {
            $("#loading").hide();
            limparTabela();
            
            var $tbody = $("#tabelaBos tbody"); 
            
            if (boletins && boletins.length > 0) {
                $.each(boletins, function(index, bo) {                                          
                    var novaLinha =
                    '<tr>' +
                    '<td style="text-align: center">' + bo.identificador + '</td>' +
                    '<td style="text-align: center">' + bo.dataOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.localOcorrencia.cidade + '</td>' +
					'<td style="text-align: center">' + bo.localOcorrencia.bairro + '</td>' +
                    '<td style="text-align: center">' + bo.periodoOcorrencia + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.marca + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.emplacamento.placa + '</td>' +
                    '<td style="text-align: center">' + bo.veiculoFurtado.cor +'</td>' +
					'<td style="text-align: center">' + bo.veiculoFurtado.tipoVeiculo +'</td>' +
                    '</tr>';
                
                    $tbody.append(novaLinha);
                });
            } else {
                $tbody.html('<tr><td colspan="9" style="text-align: center;">Nenhum boletim de ocorrência encontrado.</td></tr>');
            }

        },
        error: function() {
 			$("#loading").html(`Erro ao carregar dados.`);
        }
    });
};

var limparTabela = function() {
    $("#tabelaBos tbody").empty(); 
}

var consultar = function(urlContato) {
    sessionStorage.setItem("urlContato", urlContato);
    window.location.href = "consulta.html";
}

$(document).ready(function() {
    listarBoletins();    
});